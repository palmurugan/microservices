package com.macts.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 
 * @author PalMurugan C
 *
 */

@SpringBootApplication
@EnableConfigServer
public class ConfigurationService {

	public static void main(String[] args) {
		SpringApplication.run(ConfigurationService.class, args);
	}
}
