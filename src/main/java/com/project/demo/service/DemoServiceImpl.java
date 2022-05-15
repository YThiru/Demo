package com.project.demo.service;

import com.project.demo.dao.StoreLocationRepository;
import com.project.demo.model.StoreLocationDetails;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DemoServiceImpl implements DemoService {

    private final StoreLocationRepository storeRepository;

    public DemoServiceImpl(final StoreLocationRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public BigDecimal getStoresAmountByLocationId(String locationId) {
        Optional<StoreLocationDetails> stores = storeRepository.findStoresByLocationId(locationId);
        BigDecimal totalStoreAmount = BigDecimal.ZERO;
        if (stores.isPresent()) {
            totalStoreAmount = totalStoreAmount.add(stores.get().getAmount() != null ? stores.get().getAmount() : new BigDecimal(0));
            List<StoreLocationDetails> subStoreDetails = getStoresRevenue(locationId, new ArrayList<>());
            totalStoreAmount = subStoreDetails.stream()
                    .filter(store -> store.getAmount() != null && store.getAmount().compareTo(BigDecimal.ZERO) > 0)
                    .map(StoreLocationDetails::getAmount)
                    .reduce(BigDecimal.ZERO, BigDecimal::add)
                    .add(totalStoreAmount);
        }
        return totalStoreAmount;
    }

    @Override
    public List<StoreLocationDetails> getStoresRevenue(String locationId, List<StoreLocationDetails> subStoresList) {
        List<StoreLocationDetails> stores = storeRepository.findStoresByParentId(locationId);
        stores.stream().forEach(dtl -> {
            subStoresList.add(dtl);
            getStoresRevenue(dtl.getLocationId(), subStoresList);
        });
        return subStoresList;
    }

    @Override
    public void loadLocationAmount(List<StoreLocationDetails> storeDetails) {
        storeRepository.saveAllAndFlush(storeDetails);
    }
}