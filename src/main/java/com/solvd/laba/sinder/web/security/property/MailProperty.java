package com.solvd.laba.sinder.web.security.property;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "sinder.mail")
@AllArgsConstructor
@Getter
public class MailProperty {

    private final String host;
    private final String username;
    private final String password;
    private final Integer port;
    private final String protocol;

}
