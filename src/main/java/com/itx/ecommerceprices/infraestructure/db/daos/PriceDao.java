package com.itx.ecommerceprices.infraestructure.db.daos;

import com.itx.ecommerceprices.infraestructure.db.entities.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceDao extends JpaRepository<PriceEntity, String> {

    @Query("SELECT pe FROM PriceEntity pe WHERE pe.productId = ?2 AND pe.brand.brandId = ?3 " +
            "AND pe.startDate < ?1 AND pe.endDate > ?1")
    List<PriceEntity> findByDateAndProductIdAndBrandId(LocalDateTime dateTime, Integer productId, Integer brandId);
}
