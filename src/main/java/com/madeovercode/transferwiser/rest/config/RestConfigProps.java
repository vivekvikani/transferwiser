package com.madeovercode.transferwiser.rest.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix="rest")
public class RestConfigProps {
    String baseUrl;
    String authenticationToken;
}
