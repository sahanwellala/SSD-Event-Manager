package com.sliit.ssd.util;

import com.sliit.ssd.constants.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Component
public class RestClient {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${google.clientId}")
    private String clientId;

    @Value("${google.clientSecret}")
    private String clientSecret;

    @Value("${google.redirectUri}")
    private String redirectUri;

    @Value("${google.authUrl}")
    private String authUrl;
    @Value("${google.profileScope}")
    private String profileScope;

    @Value("${google.calendarScope}")
    private String calendarScope;

    private HttpHeaders getRequestHeader() {

        HttpHeaders headers = new HttpHeaders();
        headers.add(Constants.Headers.AUTHORIZATION, Constants.Headers.BASIC.concat(EncodingUtility.getBase64EncodedString(clientId.concat(":").concat(clientSecret))));
        headers.add(Constants.Headers.CONTENT_TYPE, Constants.Headers.APPLICATION_JSON);
        return headers;
    }

    private HttpHeaders getRequestHeader(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(Constants.Headers.AUTHORIZATION, Constants.Headers.BEARER.concat(token));
        return headers;
    }

    public <T> ResponseEntity<T> restExchange(String url, String token, Class<T> classObj) {
        return restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(this.getRequestHeader(token)), classObj);
    }

    public <T> ResponseEntity<T> restExchangeWithParams(URI url, String token, Class<T> classObj) {
        return restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(this.getRequestHeader(token)), classObj);
    }

    public <T> ResponseEntity<T> tokenExchange(String url, Object entity, HttpMethod httpMethod, Class<T> classObj) {
        return restTemplate.exchange(url, httpMethod, new HttpEntity<>(entity, this.getRequestHeader()), classObj);
    }
}
