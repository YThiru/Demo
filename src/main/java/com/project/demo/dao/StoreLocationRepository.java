package com.project.demo.dao;

import com.project.demo.model.StoreLocationDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StoreLocationRepository extends JpaRepository<StoreLocationDetails, Long> {

    Optional<StoreLocationDetails> findStoresByLocationId(String locationId);
    List<StoreLocationDetails> findStoresByParentId(String parentId);
}

