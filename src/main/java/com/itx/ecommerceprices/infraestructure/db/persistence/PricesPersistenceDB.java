package com.itx.ecommerceprices.infraestructure.db.persistence;

import com.itx.ecommerceprices.domain.expections.NotFoundException;
import com.itx.ecommerceprices.domain.model.Prices;
import com.itx.ecommerceprices.domain.persistence.PricesPersistence;
import com.itx.ecommerceprices.infraestructure.db.daos.PricesDao;
import com.itx.ecommerceprices.infraestructure.db.entities.PricesEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@Slf4j
public class PricesPersistenceDB implements PricesPersistence {

    private final static String DATA_NOT_FOUND = "Data not found";

    private final PricesDao pricesDao;

    @Autowired
    public PricesPersistenceDB(PricesDao pricesDao){
        this.pricesDao = pricesDao;
    }

    @Override
    public Prices findByDateAndProductIdAndBrandId(LocalDateTime dateTime, Integer productId, Integer brandId) {

        List<PricesEntity> pricesFound = this.pricesDao.findByDateAndProductIdAndBrandId(dateTime, productId, brandId);
        log.warn("Found: {} price/s", pricesFound.size());

        if(!pricesFound.isEmpty()){
            return this.getPrices(pricesFound);

        }else{

            log.warn(DATA_NOT_FOUND);
            throw new NotFoundException(DATA_NOT_FOUND);
        }
    }

    private Prices getPrices(List<PricesEntity> pricesFound){

        if(pricesFound.size() == 2){

            int priceOne = pricesFound.get(0).getPriority();
            int priceTwo = pricesFound.get(1).getPriority();
            log.warn("Depend on priority. First price: {}, second price: {}", priceOne, priceTwo);

            if(priceOne > priceTwo){
                return pricesFound.get(0).toPrices();
            }else{
                return pricesFound.get(1).toPrices();
            }
        }else{
            return pricesFound.get(0).toPrices();
        }
    }
}
