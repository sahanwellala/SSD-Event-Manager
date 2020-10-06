

package com.sliit.ssd.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

/**
 * RestTemplate Configuration
 *
 * Authors: Wellala S. S.(IT17009096) | M. A Ashhar Ahamed (IT17043588)
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.setConnectTimeout(Duration.ofSeconds(30000)).setReadTimeout(Duration.ofSeconds(30000)).build();
    }
}
