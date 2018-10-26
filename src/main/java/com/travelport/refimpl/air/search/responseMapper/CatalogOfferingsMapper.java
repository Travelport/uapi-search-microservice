package com.travelport.refimpl.air.search.responseMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.travelport.refimpl.air.search.models.CatalogOffering;
import com.travelport.refimpl.air.search.models.CatalogOfferings;
import com.travelport.refimpl.air.search.models.DefaultCurrency;
import com.travelport.refimpl.air.search.models.Identifier;
import com.travelport.schema.air_v45_0.AirPricePoint;
import com.travelport.schema.air_v45_0.Brand;
import com.travelport.schema.air_v45_0.FareInfo;
import com.travelport.schema.air_v45_0.LowFareSearchRsp;
import com.travelport.schema.air_v45_0.TypeBaseAirSegment;

/**
 * The Class CatalogOfferingsMapper.
 */
@Component
public class CatalogOfferingsMapper {
  
  /** The tc mapper. */
  @Autowired
  TermsAndConditionsObjectMapper tcMapper;

  /** The price mapper. */
  @Autowired
  PriceMapper priceMapper;

  /** The product mapper. */
  @Autowired
  ProductMapper productMapper;

  /**
   * Map catalog offerings.
   *
   * @param lfsResponse the lfs response
   * @param view the view
   * @return the catalog offerings
   */
  public CatalogOfferings mapCatalogOfferings(LowFareSearchRsp lfsResponse, String view) {
    CatalogOfferings offerings = new CatalogOfferings();

    offerings.setCatalogOffering(mapCatalogOfferinglist(lfsResponse, view));
    offerings.setDefaultCurrency(mapDefaultCurrency(lfsResponse.getCurrencyType()));
    offerings.setId("s1");
    offerings.setIdentifier(mapIdentifier(java.util.UUID.randomUUID().toString()));

    return offerings;
  }

  /**
   * Map default currency.
   *
   * @param currency the currency
   * @return the default currency
   */
  private DefaultCurrency mapDefaultCurrency(String currency) {
    DefaultCurrency defCur = new DefaultCurrency();
    defCur.setCode(currency);
    return defCur;
  }

  /**
   * Map identifier.
   *
   * @param identifier the identifier
   * @return the identifier
   */
  private Identifier mapIdentifier(String identifier) {
    Identifier id = new Identifier();
    id.setValue(identifier);
    id.setAuthority("Travelport");
    return id;
  }

  /**
   * Map catalog offeringlist.
   *
   * @param lfsResponse the lfs response
   * @param view the view
   * @return the list
   */
  private List<CatalogOffering> mapCatalogOfferinglist(LowFareSearchRsp lfsResponse, String view) {
    List<CatalogOffering> offeringsList = new ArrayList<CatalogOffering>();
    List<AirPricePoint> airPricePointList = lfsResponse.getAirPricePointList().getAirPricePoint();
    List<FareInfo> fareInfo = lfsResponse.getFareInfoList().getFareInfo();
    List<Brand> brandList = lfsResponse.getBrandList().getBrand();
    Map<String, TypeBaseAirSegment> segmentsMap = createAirSegmentHashMap(
        lfsResponse.getAirSegmentList().getAirSegment());
    Map<String, FareInfo> faresMap = createFareInfoHashMap(fareInfo);
    Map<String, Brand> brandMap = createBrandHashMap(brandList);
    int offeringIterator = 0;

    for (AirPricePoint pricePoint : airPricePointList) {
      offeringsList.add(mapCatalogOffering(pricePoint, faresMap, segmentsMap, brandMap, view,
          offeringIterator++));
    }

    return offeringsList;
  }

  /**
   * Creates the fare info hash map.
   *
   * @param fareInfo the fare info
   * @return the map
   */
  private static Map<String, FareInfo> createFareInfoHashMap(List<FareInfo> fareInfo) {

    Map<String, FareInfo> map = fareInfo.stream()
        .collect(Collectors.toMap(FareInfo::getKey, Function.identity()));

    return map;
  }

  /**
   * Creates the air segment hash map.
   *
   * @param segmentList the segment list
   * @return the map
   */
  private static Map<String, TypeBaseAirSegment> createAirSegmentHashMap(
      List<TypeBaseAirSegment> segmentList) {

    Map<String, TypeBaseAirSegment> map = segmentList.stream()
        .collect(Collectors.toMap(TypeBaseAirSegment::getKey, Function.identity()));

    return map;
  }

  /**
   * Creates the brand hash map.
   *
   * @param brand the brand
   * @return the map
   */
  private static Map<String, Brand> createBrandHashMap(List<Brand> brand) {

    Map<String, Brand> map = brand.stream()
        .collect(Collectors.toMap(Brand::getBrandID, Function.identity()));

    return map;
  }

  /**
   * Map catalog offering.
   *
   * @param pricePoint the price point
   * @param ppFareInfo the pp fare info
   * @param segmentsMap the segments map
   * @param brandMap the brand map
   * @param view the view
   * @param offeringIterator the offering iterator
   * @return the catalog offering
   */
  private CatalogOffering mapCatalogOffering(AirPricePoint pricePoint,
      Map<String, FareInfo> ppFareInfo, Map<String, TypeBaseAirSegment> segmentsMap,
      Map<String, Brand> brandMap, String view, int offeringIterator) {
    // TripServices::CatalogOffering == UAPI::AirPricePoint
    CatalogOffering catalogOffering = new CatalogOffering();

    catalogOffering.setTermsAndConditions(tcMapper.mapTermsAndConditions(pricePoint, ppFareInfo));
    catalogOffering.setPrice(priceMapper.mapPrice(pricePoint, view));
    catalogOffering.setProductOptions(
        productMapper.mapProductOptions(pricePoint, ppFareInfo, segmentsMap, brandMap));
    catalogOffering.setType("CatalogOffering");
    catalogOffering.setId("o" + offeringIterator);

    return catalogOffering;
  }

}
