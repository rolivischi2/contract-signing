package com.example.demo.configuration;

import com.example.demo.model.Address;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AddressConfiguration {

    @Bean
    List<Address> addresses(){
        return List.of(
                new Address("London", 10001),
                new Address("New York", 3990)
        );
    }

}
