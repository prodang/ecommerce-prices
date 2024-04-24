package com.itx.ecommerceprices.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Brand {

    @Id
    private Integer brandId;

    private String description;
}
