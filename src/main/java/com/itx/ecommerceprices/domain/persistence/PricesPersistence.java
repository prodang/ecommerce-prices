package com.itx.ecommerceprices.domain.persistence;

import com.itx.ecommerceprices.domain.model.Prices;

import java.time.LocalDateTime;

public interface PricesPersistence {
    Prices findByDateAndProductIdAndBrandId(LocalDateTime dateTime, Integer productId, Integer brandId);
}
