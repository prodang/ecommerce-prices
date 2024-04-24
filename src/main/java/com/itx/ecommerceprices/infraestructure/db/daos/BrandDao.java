package com.itx.ecommerceprices.infraestructure.db.daos;

import com.itx.ecommerceprices.infraestructure.db.entities.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandDao extends JpaRepository<BrandEntity, Integer> {
}
