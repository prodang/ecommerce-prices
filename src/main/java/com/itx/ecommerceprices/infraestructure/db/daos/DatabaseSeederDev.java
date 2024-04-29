package com.itx.ecommerceprices.infraestructure.db.daos;

import com.itx.ecommerceprices.infraestructure.db.entities.BrandEntity;
import com.itx.ecommerceprices.infraestructure.db.entities.PriceEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@Profile("dev")
public class DatabaseSeederDev {

    private final PriceDao priceDao;

    private final BrandDao brandDao;

    @Autowired
    public DatabaseSeederDev(PriceDao priceDao, BrandDao brandDao){
        this.brandDao = brandDao;
        this.priceDao = priceDao;
        this.seedDataBaseJava();
    }

    private void seedDataBaseJava() {
        log.warn("------- Initial Load from JAVA -----------");

        BrandEntity brandEntity = BrandEntity.builder().brandId(1).description("ZARA").build();
        this.brandDao.save(brandEntity);
        log.warn("        ------- brands");

        PriceEntity[] prices = {
          PriceEntity.builder()
                  .id("1")
                  .brand(brandEntity)
                  .startDate(LocalDateTime.of(2020, 6, 14, 0, 0, 0))
                  .endDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59))
                  .priceList(1)
                  .productId(35455)
                  .priority(0)
                  .price(new BigDecimal("35.50"))
                  .curr("EUR")
                  .build(),
            PriceEntity.builder()
                    .id("2")
                    .brand(brandEntity)
                    .startDate(LocalDateTime.of(2020, 6, 14, 15, 0, 0))
                    .endDate(LocalDateTime.of(2020, 6, 14, 18, 30, 0))
                    .priceList(2)
                    .productId(35455)
                    .priority(1)
                    .price(new BigDecimal("25.45"))
                    .curr("EUR")
                    .build(),
            PriceEntity.builder()
                    .id("3")
                    .brand(brandEntity)
                    .startDate(LocalDateTime.of(2020, 6, 15, 0, 0, 0))
                    .endDate(LocalDateTime.of(2020, 6, 15, 11, 0, 0))
                    .priceList(3)
                    .productId(35455)
                    .priority(1)
                    .price(new BigDecimal("30.50"))
                    .curr("EUR")
                    .build(),
            PriceEntity.builder()
                    .id("4")
                    .brand(brandEntity)
                    .startDate(LocalDateTime.of(2020, 6, 15, 16, 0, 0))
                    .endDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59))
                    .priceList(4)
                    .productId(35455)
                    .priority(1)
                    .price(new BigDecimal("38.95"))
                    .curr("EUR")
                    .build()
        };
        this.priceDao.saveAll(List.of(prices));
        log.warn("        ------- prices");
    }
}
