package com.travelport.refimpl.air.search.requestMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import com.travelport.refimpl.air.search.models.CatalogOfferingsRequestAir;
import com.travelport.refimpl.air.search.models.Request;
import com.travelport.schema.air_v45_0.AirSearchModifiers.PreferredProviders;
import com.travelport.schema.air_v45_0.LowFareSearchReq;
import com.travelport.schema.common_v45_0.BillingPointOfSaleInfo;
import com.travelport.schema.common_v45_0.Provider;

/**
 * The Class RequestMapper.
 */
@Component
@EnableConfigurationProperties
@ConfigurationProperties("air")

public class RequestMapper {

  /** The Constant LOG. */
  private static final Logger LOG = LoggerFactory.getLogger(RequestMapper.class);

  /** The branch. */
  @Value("${air.branch}")
  private String branch;

  /** The price mod mapper. */
  @Autowired
  PriceModifiersMapper priceModMapper;

  /** The search mod mapper. */
  @Autowired
  SearchModifiersMapper searchModMapper;

  /** The air leg mapper. */
  @Autowired
  AirLegMapper airLegMapper;

  /** The passenger mapper. */
  @Autowired
  SearchPassengerMapper passengerMapper;

  /**
   * Instantiates a new request mapper.
   */
  public RequestMapper() {
  }

  /**
   * Map low fare search req.
   *
   * @param request the request
   * @param sccType the scc type
   * @param sccChannelId the scc channel id
   * @return the low fare search req
   */
  public LowFareSearchReq mapLowFareSearchReq(Request request, String sccType,
      String sccChannelId) {
    LOG.debug("*Entered AirMapper");
    LowFareSearchReq lfsRequest = new LowFareSearchReq();
    CatalogOfferingsRequestAir catalogofferings = request.getCatalogOfferingsRequestAir();

    lfsRequest.setTargetBranch(branch);
    lfsRequest.setNSCC(sccType);
    lfsRequest.setSolutionResult(false);
    lfsRequest.setBillingPointOfSaleInfo(mapBillingPointOfSale());

    lfsRequest.getSearchAirLeg()
        .addAll(airLegMapper.mapSearchAirLegs(catalogofferings.getSearchCriteriaFlight()));
    lfsRequest.getSearchPassenger()
        .addAll(passengerMapper.mapSearchPassengers(catalogofferings.getPassengerCriteria()));
    lfsRequest.setAirPricingModifiers(priceModMapper.mapAirPricingModifiers(sccChannelId,
        catalogofferings.getPricingModifiersAir()));
    lfsRequest.setAirSearchModifiers(searchModMapper.mapSearchModifiers(
        catalogofferings.getOffersPerPage(), catalogofferings.getSearchModifiersAir()));

    return lfsRequest;
  }

  /**
   * Map billing point of sale.
   *
   * @return the billing point of sale info
   */
  private BillingPointOfSaleInfo mapBillingPointOfSale() {
    BillingPointOfSaleInfo bpos = new BillingPointOfSaleInfo();

    bpos.setOriginApplication("UAPI");

    return bpos;
  }

  /**
   * Map providers.
   *
   * @param provider the provider
   * @return the preferred providers
   */
  // UAPI allows for referencing preferred cores. Trip Services does not use the cores.
  private PreferredProviders mapProviders(String provider) {
    PreferredProviders providers = new PreferredProviders();
    Provider p = new Provider();

    p.setCode(provider);
    providers.getProvider().add(p);

    return providers;
  }
}