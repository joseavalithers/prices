package com.avalith.prices.config;

import com.avalith.prices.calculator.DiscountCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean("restClient")
    public RestTemplate registerRestTemplate(){
        return new RestTemplate();
    }
    @Bean("discount")
    public DiscountCalculator getDiscountCalculator(){
        return new DiscountCalculator();
    }
}