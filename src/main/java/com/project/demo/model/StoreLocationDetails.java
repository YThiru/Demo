package com.project.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Setter;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Table(name="stores", uniqueConstraints = { @UniqueConstraint(columnNames = { "locationId", "parentId"}) })
public class StoreLocationDetails implements Serializable {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String locationId;

    private BigDecimal amount;
    private String parentId;

   public static StoreLocationDetails of(String locationId, String parentId, BigDecimal amount) {
       StoreLocationDetails storeDetail = new StoreLocationDetails();
       storeDetail.setLocationId(locationId);
       storeDetail.setParentId(parentId);
       storeDetail.setAmount(amount);
        return storeDetail;
   }
}
