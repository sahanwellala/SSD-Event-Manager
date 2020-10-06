package com.sliit.ssd.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Domain class that store the Access token
 * Authors: Wellala S. S.(IT17009096) | M. A Ashhar Ahamed (IT17043588)
 */
@Component
@Data
public class AccessTokenDTO {
    private String accessToken;
}
