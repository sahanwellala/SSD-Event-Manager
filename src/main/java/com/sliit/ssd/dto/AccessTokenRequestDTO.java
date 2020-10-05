package com.sliit.ssd.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Domain class for Access token request
 */
@Component
@Data
public class AccessTokenRequestDTO {
    private String code;
    private String client_id;
    private String client_secret;
    private String redirect_uri;
    private String grant_type;
}
