package com.itx.ecommerceprices.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;

@Getter
@Builder
@AllArgsConstructor
public class Brand {

    @Id
    private Integer brandId;

    private String description;
}
