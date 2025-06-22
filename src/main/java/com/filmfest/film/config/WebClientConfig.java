package com.filmfest.film.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    private static final String BASE_URL = "https://sitgesfilmfestival.com";

    @Bean
    public WebClient sitgesWebClient() {
        return WebClient.builder()
                .baseUrl(BASE_URL)
                .codecs(config -> config.defaultCodecs().maxInMemorySize(5 * 1024 * 1024))
                .build();
    }
}