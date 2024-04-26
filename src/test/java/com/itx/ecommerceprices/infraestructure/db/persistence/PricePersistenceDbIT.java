package com.itx.ecommerceprices.infraestructure.db.persistence;

import com.itx.ecommerceprices.domain.expections.NotFoundException;
import com.itx.ecommerceprices.domain.model.Price;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class PricePersistenceDbIT {

    @Autowired
    private PricePersistenceDb pricesPersistenceDb;

    @Test
    void shouldFindVariousOK(){
        LocalDateTime dateTime = LocalDateTime.of(2020,10,10,10,0,0);
        Integer productId = 35455;
        Integer brandId = 1;

        LocalDateTime startDate = LocalDateTime.of(2020,6,15,16,0,0);
        LocalDateTime endDate = LocalDateTime.of(2020,12,31,23,59,59);

        Price price = this.pricesPersistenceDb.findByDateAndProductIdAndBrandId(dateTime, productId, brandId);

        assertEquals(startDate, price.getStartDate());
        assertEquals(endDate, price.getEndDate());
        assertEquals(4, price.getPriceList());
        assertEquals(35455, price.getProductId());
        assertEquals(1, price.getPriority());
        assertEquals(new BigDecimal("38.95"), price.getPrice());
        assertEquals("EUR", price.getCurr());
    }

    @Test
    void shouldFindOneOK(){
        LocalDateTime dateTime = LocalDateTime.of(2020,6,14,9,0,0);
        Integer productId = 35455;
        Integer brandId = 1;

        Price price = this.pricesPersistenceDb.findByDateAndProductIdAndBrandId(dateTime, productId, brandId);

        assertEquals(1, price.getBrandId());
    }

    @Test
    void findKO_NotFoundException(){
        LocalDateTime dateTime = LocalDateTime.of(2024,4,25,9,0,0);
        Integer productId = 234;
        Integer brandId = 2;

        assertThrows(NotFoundException.class,
                () -> this.pricesPersistenceDb.findByDateAndProductIdAndBrandId(dateTime, productId, brandId));
    }
}
