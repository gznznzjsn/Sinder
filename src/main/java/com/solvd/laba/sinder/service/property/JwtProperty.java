package com.solvd.laba.sinder.service.property;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "sinder.security")
@AllArgsConstructor
@Getter
public class JwtProperty {

    private final String accessKey;
    private final String refreshKey;
    private final String enableKey;
    private final String passwordRefreshKey;
    private final Integer accessExpirationTime;
    private final Integer refreshExpirationTime;

}
