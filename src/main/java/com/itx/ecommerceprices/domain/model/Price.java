package com.itx.ecommerceprices.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Price {

    @NotBlank
    private Integer brandId;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Integer priceList;

    @NotBlank
    private Integer productId;

    private Integer priority;

    private BigDecimal price;

    private String curr;
}
