package com.itx.ecommerceprices.infraestructure.api.dto;

import com.itx.ecommerceprices.domain.model.Prices;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class PricesDto {

    private Integer productId;

    private Integer brandId;

    private Integer priceList;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private BigDecimal price;

    public PricesDto(Prices prices){
        BeanUtils.copyProperties(prices, this);
    }
}
