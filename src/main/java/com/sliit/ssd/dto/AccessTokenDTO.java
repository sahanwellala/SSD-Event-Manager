package com.sliit.ssd.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class AccessTokenDTO {
    private String accessToken;
}
