package com.projeto.funancial.configuration;

import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Configuration
public class ApplicationConfig {
	@Getter
	private String jwtSecret;
}
