package com.brewery.client.msbreweryclient.web.client;


import com.brewery.client.msbreweryclient.web.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "sfg.brewery", ignoreUnknownFields = true)
public class CustomerClient {

    public final String CUSTOMER_PATH_V1 = "/api/v1/customers/";
    private String apiHost;

    private final RestTemplate restTemplate;

    public CustomerClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public CustomerDto getCustomer(UUID uuid) {
        return restTemplate.getForObject(apiHost + CUSTOMER_PATH_V1 + uuid.toString(), CustomerDto.class);
    }
    public URI addNewCustomer(CustomerDto customerDto){
        return restTemplate.postForLocation(apiHost + CUSTOMER_PATH_V1, customerDto);
    }
    public void updateBeer(UUID uuid, CustomerDto customerDto){
        restTemplate.put(apiHost + "/update" + CUSTOMER_PATH_V1 + uuid.toString(), customerDto);
    }
    public void deleteBeer(UUID uuid){
        restTemplate.delete(apiHost + "/delete" + CUSTOMER_PATH_V1 + uuid.toString());
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }
}
