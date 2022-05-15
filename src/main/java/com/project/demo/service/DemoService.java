package com.project.demo.service;

import com.project.demo.model.StoreLocationDetails;

import java.math.BigDecimal;
import java.util.List;

public interface DemoService {
    BigDecimal getStoresAmountByLocationId(String locationId);
    List<StoreLocationDetails> getStoresRevenue(String locationId, List<StoreLocationDetails> stores);
    void loadLocationAmount(List<StoreLocationDetails> storeDetails);
}
