package com.itx.ecommerceprices.infraestructure.db.daos;

import com.itx.ecommerceprices.infraestructure.db.entities.PricesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PricesDao extends JpaRepository<PricesEntity, String> {
}
