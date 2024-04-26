package com.itx.ecommerceprices.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BrandTest {

    @Test
    void shouldCreateBrand(){
        Brand brand = Brand.builder().brandId(1).description("ZARA").build();

        assertEquals(1, brand.getBrandId());
        assertEquals("ZARA", brand.getDescription());
    }
}
