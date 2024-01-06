package com.keypopsh.cale;

import com.keypopsh.cale.config.ApplicationConfiguration;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationConfiguration.class)
public class CaleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaleApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapperBean() {
		return new ModelMapper();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(12);
	}
}
