package com.sliit.ssd.dto;

import lombok.Data;

/**
 * Domain class for Access token response
 * Authors: Wellala S. S.(IT17009096) | M. A Ashhar Ahamed (IT17043588)
 */
@Data
public class AccessTokenResponseDTO {
    private String access_token;
    private String token_type;
    private String expires_in;
}
