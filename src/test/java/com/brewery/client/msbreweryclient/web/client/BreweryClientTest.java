package com.brewery.client.msbreweryclient.web.client;

import com.brewery.client.msbreweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@Disabled("Disabled due circle ci integration")
@SpringBootTest
class BreweryClientTest {

    @Autowired
    private BreweryClient breweryClient;


    @Test
    void getBeerById() {
        BeerDto dto = breweryClient.getBeerById(UUID.randomUUID());

        assertNotNull(dto);
    }

    @Test
    void testNewBeer(){
        BeerDto dto = BeerDto.builder()
                .beerName("Rose grasshopper")
                .beerStyle("Lager")
                .id(UUID.randomUUID())
                .build();
        URI uri = breweryClient.saveNewBeer(dto);

        assertNotNull(uri);
    }

    @Test
    void testUpdateBeer(){
        BeerDto dto = BeerDto.builder()
                .beerName("Rose grasshopper")
                .beerStyle("Lager")
                .id(UUID.randomUUID())
                .build();
        breweryClient.updateBeer(UUID.randomUUID(), dto);
    }

    @Test
    void testDeleteBeer(){
        breweryClient.deleteBeer(UUID.randomUUID());
    }
}