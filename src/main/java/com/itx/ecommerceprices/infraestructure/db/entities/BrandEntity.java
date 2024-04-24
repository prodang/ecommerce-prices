package com.itx.ecommerceprices.infraestructure.db.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity(name = "BRAND")
public class BrandEntity {

    @Id
    @Column(name = "BRAND_ID")
    private Integer brandId;

    private String description;
}
