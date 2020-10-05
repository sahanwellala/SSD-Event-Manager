package com.sliit.ssd.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Domain class that store the Access token
 */
@Component
@Data
public class AccessTokenDTO {
    private String accessToken;
}
