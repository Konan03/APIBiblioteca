package com.biblioteca.biblioteca.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Value("${api.libros.url}")
    private String apiLibrosUrl;

    @Bean
    public RestClient restClient() {
        return RestClient.builder()
                .baseUrl(apiLibrosUrl)
                .build();
    }
}