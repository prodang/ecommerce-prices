package com.itx.ecommerceprices.infraestructure.db.entities;

import com.itx.ecommerceprices.domain.model.Price;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "PRICES")
public class PriceEntity {

    @Id
    private String id;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Integer priceList;

    private Integer productId;

    private Integer priority;

    private BigDecimal finalPrice;

    private String curr;

    @ManyToOne
    @JoinColumn(name = "BRAND_ID")
    private BrandEntity brand;

    public Price toPrices() {
        Price priceResult = new Price();

        BeanUtils.copyProperties(this, priceResult);
        priceResult.setBrandId(this.brand.getBrandId());

        return priceResult;
    }
}
