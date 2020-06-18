package com.brewery.client.msbreweryclient.web.client;

import com.brewery.client.msbreweryclient.web.model.BeerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "sfg.brewery", ignoreUnknownFields = true)
public class BreweryClient {

    public final String BEER_PATH_V1 = "/api/v1/beer/";
    private String apiHost;

    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplate) {
        this.restTemplate = restTemplate.build();
    }

    public BeerDto getBeerById(UUID uuid) {
        return restTemplate.getForObject(apiHost + BEER_PATH_V1 + uuid.toString(), BeerDto.class);
    }

    public URI saveNewBeer(BeerDto beerDto){
        return restTemplate.postForLocation(apiHost + BEER_PATH_V1, beerDto);
    }
    public void updateBeer(UUID uuid, BeerDto beerDto){
        restTemplate.put(apiHost + BEER_PATH_V1 + "/" + uuid.toString(), beerDto);
    }
    public void deleteBeer(UUID uuid){
        restTemplate.delete(apiHost + BEER_PATH_V1 + "/" + uuid.toString());
    }
    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }
}
