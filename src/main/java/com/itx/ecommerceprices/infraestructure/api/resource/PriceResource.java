package com.itx.ecommerceprices.infraestructure.api.resource;

import com.itx.ecommerceprices.domain.model.Price;
import com.itx.ecommerceprices.domain.services.PriceService;
import com.itx.ecommerceprices.infraestructure.api.dto.PriceDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping(PriceResource.PRICES)
@Slf4j
public class PriceResource {

    public static final String PRICES = "/prices";

    public static final String SEARCH = "/search";

    private final PriceService priceService;

    @Autowired
    public PriceResource(PriceService priceService){
        this.priceService = priceService;
    }

    @GetMapping(SEARCH)
    public PriceDto findByDateAndProductIdAndBrandId(
            @RequestParam("dateTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTime,
            @RequestParam("productId") Integer productId, @RequestParam("brandId") Integer brandId){

        log.warn("Data -> dateTime: {}, productId: {}, brandId: {}", dateTime, productId, brandId);
        Price price = priceService.findByDateAndProductIdAndBrandId(dateTime, productId, brandId);

        return new PriceDto(price);
    }
}
