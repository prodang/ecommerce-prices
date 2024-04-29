package com.itx.ecommerceprices.infraestructure.api.resource;

import com.itx.ecommerceprices.infraestructure.api.dto.PriceDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.itx.ecommerceprices.infraestructure.api.resource.PriceResource.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class PriceResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void shouldFindTest1_OK(){
        LocalDateTime dateTime = LocalDateTime.of(2020,6,14,10,0,0);

        LocalDateTime startDateExpect = LocalDateTime.of(2020, 6, 14, 0, 0, 0);
        LocalDateTime endDateExpect = LocalDateTime.of(2020, 12, 31, 23, 59, 59);

        this.webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(PRICES + SEARCH)
                        .queryParam("dateTime", dateTime.format(DateTimeFormatter.ISO_DATE_TIME))
                        .queryParam("productId", 35455)
                        .queryParam("brandId", 1)
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody(PriceDto.class)
                .value(priceDto -> assertEquals(new BigDecimal("35.50"), priceDto.getFinalPrice()))
                .value(priceDto -> assertEquals(startDateExpect, priceDto.getStartDate()))
                .value(priceDto -> assertEquals(endDateExpect, priceDto.getEndDate()))
                .value(priceDto -> assertEquals(1, priceDto.getBrandId()))
                .value(priceDto -> assertEquals(1, priceDto.getPriceList()))
                .value(priceDto -> assertEquals(35455, priceDto.getProductId()));
    }

    @Test
    void shouldFindTest2_OK(){
        LocalDateTime dateTime = LocalDateTime.of(2020,6,14,16,0,0);

        LocalDateTime startDateExpect = LocalDateTime.of(2020, 6, 14, 15, 0, 0);
        LocalDateTime endDateExpect = LocalDateTime.of(2020, 6, 14, 18, 30, 0);

        this.webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(PRICES + SEARCH)
                        .queryParam("dateTime", dateTime.format(DateTimeFormatter.ISO_DATE_TIME))
                        .queryParam("productId", 35455)
                        .queryParam("brandId", 1)
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody(PriceDto.class)
                .value(priceDto -> assertEquals(new BigDecimal("25.45"), priceDto.getFinalPrice()))
                .value(priceDto -> assertEquals(startDateExpect, priceDto.getStartDate()))
                .value(priceDto -> assertEquals(endDateExpect, priceDto.getEndDate()))
                .value(priceDto -> assertEquals(1, priceDto.getBrandId()))
                .value(priceDto -> assertEquals(2, priceDto.getPriceList()))
                .value(priceDto -> assertEquals(35455, priceDto.getProductId()));
    }

    @Test
    void shouldFindTest3_OK(){
        LocalDateTime dateTime = LocalDateTime.of(2020,6,14,21,0,0);

        LocalDateTime startDateExpect = LocalDateTime.of(2020, 6, 14, 0, 0, 0);
        LocalDateTime endDateExpect = LocalDateTime.of(2020, 12, 31, 23, 59, 59);

        this.webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(PRICES + SEARCH)
                        .queryParam("dateTime", dateTime.format(DateTimeFormatter.ISO_DATE_TIME))
                        .queryParam("productId", 35455)
                        .queryParam("brandId", 1)
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody(PriceDto.class)
                .value(priceDto -> assertEquals(new BigDecimal("35.50"), priceDto.getFinalPrice()))
                .value(priceDto -> assertEquals(startDateExpect, priceDto.getStartDate()))
                .value(priceDto -> assertEquals(endDateExpect, priceDto.getEndDate()))
                .value(priceDto -> assertEquals(1, priceDto.getBrandId()))
                .value(priceDto -> assertEquals(1, priceDto.getPriceList()))
                .value(priceDto -> assertEquals(35455, priceDto.getProductId()));
    }

    @Test
    void shouldFindTest4_OK(){
        LocalDateTime dateTime = LocalDateTime.of(2020,6,15,10,0,0);

        LocalDateTime startDateExpect = LocalDateTime.of(2020, 6, 15, 0, 0, 0);
        LocalDateTime endDateExpect = LocalDateTime.of(2020, 6, 15, 11, 0, 0);

        this.webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(PRICES + SEARCH)
                        .queryParam("dateTime", dateTime.format(DateTimeFormatter.ISO_DATE_TIME))
                        .queryParam("productId", 35455)
                        .queryParam("brandId", 1)
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody(PriceDto.class)
                .value(priceDto -> assertEquals(new BigDecimal("30.50"), priceDto.getFinalPrice()))
                .value(priceDto -> assertEquals(startDateExpect, priceDto.getStartDate()))
                .value(priceDto -> assertEquals(endDateExpect, priceDto.getEndDate()))
                .value(priceDto -> assertEquals(1, priceDto.getBrandId()))
                .value(priceDto -> assertEquals(3, priceDto.getPriceList()))
                .value(priceDto -> assertEquals(35455, priceDto.getProductId()));
    }

    @Test
    void shouldFindTest5_OK(){
        LocalDateTime dateTime = LocalDateTime.of(2020,6,16,21,0,0);

        LocalDateTime startDateExpect = LocalDateTime.of(2020, 6, 15, 16, 0, 0);
        LocalDateTime endDateExpect = LocalDateTime.of(2020, 12, 31, 23, 59, 59);

        this.webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(PRICES + SEARCH)
                        .queryParam("dateTime", dateTime.format(DateTimeFormatter.ISO_DATE_TIME))
                        .queryParam("productId", 35455)
                        .queryParam("brandId", 1)
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody(PriceDto.class)
                .value(priceDto -> assertEquals(new BigDecimal("38.95"), priceDto.getFinalPrice()))
                .value(priceDto -> assertEquals(startDateExpect, priceDto.getStartDate()))
                .value(priceDto -> assertEquals(endDateExpect, priceDto.getEndDate()))
                .value(priceDto -> assertEquals(1, priceDto.getBrandId()))
                .value(priceDto -> assertEquals(4, priceDto.getPriceList()))
                .value(priceDto -> assertEquals(35455, priceDto.getProductId()));
    }

    @Test
    void findKO_NotFoundException(){
        LocalDateTime dateTime = LocalDateTime.of(2022,6,14,10,0,0);

        this.webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(PRICES + SEARCH)
                        .queryParam("dateTime", dateTime.format(DateTimeFormatter.ISO_DATE_TIME))
                        .queryParam("productId", 28745)
                        .queryParam("brandId", 2)
                        .build())
                .exchange()
                .expectStatus().isNotFound();
    }
}
