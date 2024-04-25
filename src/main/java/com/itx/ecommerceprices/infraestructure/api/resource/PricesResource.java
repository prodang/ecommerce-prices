package com.itx.ecommerceprices.infraestructure.api.resource;

import com.itx.ecommerceprices.domain.model.Prices;
import com.itx.ecommerceprices.domain.services.PricesService;
import com.itx.ecommerceprices.infraestructure.api.dto.PricesDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping(PricesResource.PRICES)
@Slf4j
public class PricesResource {

    public static final String PRICES = "/prices";

    public static final String SEARCH = "/search";

    private final PricesService pricesService;

    @Autowired
    public PricesResource(PricesService pricesService){
        this.pricesService = pricesService;
    }

    @GetMapping(SEARCH)
    public PricesDto findByDateAndProductIdAndBrandId(
            @RequestParam("dateTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTime,
            @RequestParam("productId") Integer productId, @RequestParam("brandId") Integer brandId){

        log.warn("Data -> dateTime: {}, productId: {}, brandId: {}", dateTime, productId, brandId);
        Prices prices = pricesService.findByDateAndProductIdAndBrandId(dateTime, productId, brandId);

        return new PricesDto(prices);
    }
}
