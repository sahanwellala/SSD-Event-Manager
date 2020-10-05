package com.sliit.ssd.dto;

import lombok.Data;

/**
 * Domain class for Access token response
 */
@Data
public class AccessTokenResponseDTO {
    private String access_token;
    private String token_type;
    private String expires_in;
}
