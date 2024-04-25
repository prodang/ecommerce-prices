package com.itx.ecommerceprices.infraestructure.db.entities;

import com.itx.ecommerceprices.domain.model.Prices;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "PRICES")
public class PricesEntity {

    @Id
    private String id;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Integer priceList;

    private Integer productId;

    private Integer priority;

    private BigDecimal price;

    private String curr;

    @ManyToOne
    @JoinColumn(name = "BRAND_ID")
    private BrandEntity brand;

    public Prices toPrices() {
        Prices prices = new Prices();

        BeanUtils.copyProperties(this, prices);
        prices.setBrandId(this.brand.getBrandId());

        return prices;
    }
}
