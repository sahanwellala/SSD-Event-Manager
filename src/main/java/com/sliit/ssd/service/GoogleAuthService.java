package com.sliit.ssd.service;

import com.sliit.ssd.constants.Constants;
import com.sliit.ssd.dto.AccessTokenDTO;
import com.sliit.ssd.dto.AccessTokenRequestDTO;
import com.sliit.ssd.dto.AccessTokenResponseDTO;
import com.sliit.ssd.util.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

@Service
public class GoogleAuthService {

    @Value("${google.accessTokenUri}")
    private String userAuthorizationUri;
    @Value("${google.redirectUri}")
    private String redirectUri;
    @Value("${google.clientId}")
    private String clientId;
    @Value("${google.clientSecret}")
    private String clientSecret;
    @Autowired
    private RestClient restClient;
    @Autowired
    private AccessTokenDTO accessTokenDTO;


    public String obtainAccessToken(String code) {

        AccessTokenRequestDTO request = new AccessTokenRequestDTO();
        request.setCode(code);
        request.setClient_id(clientId);
        request.setClient_secret(clientSecret);
        request.setRedirect_uri(redirectUri);
        request.setGrant_type(Constants.AUTHORIZATION_CODE);

        // retrieve access_token,token_type,expires_in
        AccessTokenResponseDTO response = restClient.tokenExchange(userAuthorizationUri, request, HttpMethod.POST, AccessTokenResponseDTO.class).getBody();
        accessTokenDTO.setAccessToken(response.getAccess_token());
        System.out.println(response.getAccess_token());

        return response.getToken_type();
    }
}
