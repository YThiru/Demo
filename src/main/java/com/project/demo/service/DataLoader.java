package com.project.demo.service;

import com.project.demo.dao.StoreLocationRepository;
import com.project.demo.model.StoreLocationDetails;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Configuration
@Component
public class DataLoader implements CommandLineRunner {

    private StoreLocationRepository storeLocationRepository;

    public DataLoader(StoreLocationRepository storeLocationRepository) {
        this.storeLocationRepository = storeLocationRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        LoadStoreDetails();
    }

    private void LoadStoreDetails() {

        StoreLocationDetails storeDetail = StoreLocationDetails.of("Australia",null, null);
        storeLocationRepository.save(storeDetail);

        storeDetail = StoreLocationDetails.of("NSW","Australia", null);
        storeLocationRepository.save(storeDetail);

        storeDetail = StoreLocationDetails.of("Sydney","NSW", null);
        storeLocationRepository.save(storeDetail);

        storeDetail = StoreLocationDetails.of("Newcastle","NSW", null);
        storeLocationRepository.save(storeDetail);

        storeDetail = StoreLocationDetails.of("Sydney Store 1" ,"Sydney", new BigDecimal(10000));
        storeLocationRepository.save(storeDetail);

        storeDetail = StoreLocationDetails.of("Sydney Store 2","Sydney", new BigDecimal(15000));
        storeLocationRepository.save(storeDetail);

        storeDetail = StoreLocationDetails.of("Sydney Sub Store 21" ,"Sydney Store 2", new BigDecimal(8000));
        storeLocationRepository.save(storeDetail);

        storeDetail = StoreLocationDetails.of("Sydney Sub Store 22","Sydney Store 2", new BigDecimal(9000));
        storeLocationRepository.save(storeDetail);
    }
}
