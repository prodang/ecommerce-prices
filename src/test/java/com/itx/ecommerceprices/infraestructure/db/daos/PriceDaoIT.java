package com.itx.ecommerceprices.infraestructure.db.daos;

import com.itx.ecommerceprices.infraestructure.db.entities.PriceEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class PriceDaoIT {

    @Autowired
    private PriceDao priceDao;

    @Test
    void shouldFindOK(){

        LocalDateTime dateTime = LocalDateTime.of(2020,6,14,18,0,0);
        Integer productId = 35455;
        Integer brandId = 1;

        LocalDateTime startDate = LocalDateTime.of(2020,6,14,15,0,0);
        LocalDateTime endDate = LocalDateTime.of(2020,6,14,18,30,0);

        List<PriceEntity> pricesEntities = this.priceDao.findByDateAndProductIdAndBrandId(dateTime, productId, brandId);

        assertEquals(2, pricesEntities.size());
        assertTrue(pricesEntities.stream()
                .anyMatch(price ->
                        1 == price.getBrand().getBrandId() &&
                        "ZARA".equals(price.getBrand().getDescription()) &&
                        startDate.equals(price.getStartDate()) &&
                        endDate.equals(price.getEndDate()) &&
                        2 == price.getPriceList() &&
                        35455 == price.getProductId() &&
                        1 == price.getPriority() &&
                        0 == new BigDecimal("25.45").compareTo(price.getFinalPrice()) &&
                        "EUR".equals(price.getCurr())));

    }
}
