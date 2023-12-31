package com.keypopsh.cale.config;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@ConfigurationProperties(prefix = "application")
@Slf4j
public class ApplicationConfiguration {
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
        log.info(this + "ALIVE");
    }
}
