package org.labisd.rpc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
	
	@Bean
	RestTemplate restTempalte() {
		return new RestTemplate();
	}
}
