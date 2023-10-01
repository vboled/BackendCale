package com.keypopsh.cale;

import com.keypopsh.cale.config.ApplicationConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationConfiguration.class)
public class CaleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaleApplication.class, args);
	}

}
