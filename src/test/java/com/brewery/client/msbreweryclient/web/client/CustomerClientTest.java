package com.brewery.client.msbreweryclient.web.client;

import com.brewery.client.msbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@Disabled("Disabled due circle ci integration")
@SpringBootTest
class CustomerClientTest {

    @Autowired
    private CustomerClient customerClient;


    @Test
    void getCustomer() {
        CustomerDto dto = customerClient.getCustomer(UUID.randomUUID());

        assertNotNull(dto);
    }

    @Test
    void addNewCustomer() {
        CustomerDto dto = CustomerDto.builder()
                .name("Pale ale")
                .id(UUID.randomUUID())
                .build();
        URI uri = customerClient.addNewCustomer(dto);

        assertNotNull(dto);
    }

    @Test
    void updateCustomer() {
        CustomerDto dto = CustomerDto.builder()
                .name("Pale Ale")
                .id(UUID.randomUUID())
                .build();

        customerClient.updateCustomer(UUID.randomUUID(), dto);
    }

    @Test
    void deleteCustomer() {
        customerClient.deleteCustomer(UUID.randomUUID());
    }
}