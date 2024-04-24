package com.itx.ecommerceprices.infraestructure.db.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity(name = "PRICES")
public class PricesEntity {

    @Id
    private String id;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Integer priceList;

    private BigDecimal productId;

    private Integer priority;

    private BigDecimal price;

    private String curr;

    @ManyToOne
    @JoinColumn(name = "BRAND_ID")
    private BrandEntity brandId;
}
