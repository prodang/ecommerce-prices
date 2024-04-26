package com.itx.ecommerceprices.domain.services;

import com.itx.ecommerceprices.domain.model.Price;
import com.itx.ecommerceprices.domain.persistence.PricePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PriceService {

    private final PricePersistence pricePersistence;

    @Autowired
    public PriceService(PricePersistence pricePersistence){
        this.pricePersistence = pricePersistence;
    }

    public Price findByDateAndProductIdAndBrandId(LocalDateTime dateTime, Integer productId, Integer brandId) {
        return this.pricePersistence.findByDateAndProductIdAndBrandId(dateTime, productId, brandId);
    }
}
