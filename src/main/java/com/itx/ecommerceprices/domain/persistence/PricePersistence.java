package com.itx.ecommerceprices.domain.persistence;

import com.itx.ecommerceprices.domain.model.Price;

import java.time.LocalDateTime;

public interface PricePersistence {
    Price findByDateAndProductIdAndBrandId(LocalDateTime dateTime, Integer productId, Integer brandId);
}
