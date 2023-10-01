package com.keypopsh.cale.config;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "application")
public class ApplicationConfiguration {
    private final Logger logger = LoggerFactory.getLogger(ApplicationConfiguration.class);
    @Getter
    private final Security security;

    public ApplicationConfiguration(Security security) {
        this.security = security;
    }

    public record Security(ApplicationConfiguration.Security.Jwt jwt) {
        public record Jwt(String secret, String type, String issuer, String audience, String header, Long expireTimeSeconds, String path) {}
    }

    @Override
    public String toString() {
        return "ApplicationConfiguration{" +
                "securityConfiguration=" + security +
                '}';
    }

    @PostConstruct
    public void postInit(){
        logger.info(this.toString());
    }
}
