package com.itx.ecommerceprices.infraestructure.api.dto;

import com.itx.ecommerceprices.domain.model.Price;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class PriceDto {

    private Integer productId;

    private Integer brandId;

    private Integer priceList;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private BigDecimal finalPrice;

    public PriceDto(Price price){
        BeanUtils.copyProperties(price, this);
    }
}
