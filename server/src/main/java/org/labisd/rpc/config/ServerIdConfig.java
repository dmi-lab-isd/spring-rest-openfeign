package org.labisd.rpc.config;

import java.util.Random;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServerIdConfig {
	
	@Bean
	@Qualifier("serverId")
	String serverId() {
		return "Server_" + new Random().nextInt(1000);
	}
}
