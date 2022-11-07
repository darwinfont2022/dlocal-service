package com.payment.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public org.modelmapper.ModelMapper mapper(){
        return new org.modelmapper.ModelMapper();
    }
}
