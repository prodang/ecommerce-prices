package com.itx.ecommerceprices.domain.services;

import com.itx.ecommerceprices.domain.model.Prices;
import com.itx.ecommerceprices.domain.persistence.PricesPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PricesService {

    private final PricesPersistence pricesPersistence;

    @Autowired
    public PricesService(PricesPersistence pricesPersistence){
        this.pricesPersistence =  pricesPersistence;
    }

    public Prices findByDateAndProductIdAndBrandId(LocalDateTime dateTime, Integer productId, Integer brandId) {
        return this.pricesPersistence.findByDateAndProductIdAndBrandId(dateTime, productId, brandId);
    }
}
