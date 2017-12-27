package com.genesis.party;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.undertow.UndertowEmbeddedServletContainerFactory;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.genesis.common.configuration.AuditConfiguration;

/**
 * 
 * @author PalMurugan C
 *
 */

@EnableJpaAuditing
@EnableJpaRepositories
@SpringBootApplication
@Import(AuditConfiguration.class)
public class PartyManagementApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(PartyManagementApplication.class, args);
	}

	@Bean
	public UndertowEmbeddedServletContainerFactory embeddedServletContainerFactory() {
		UndertowEmbeddedServletContainerFactory factory = new UndertowEmbeddedServletContainerFactory();
		return factory;
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PartyManagementApplication.class);
	}

}
