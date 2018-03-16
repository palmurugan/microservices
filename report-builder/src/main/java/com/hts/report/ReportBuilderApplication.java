package com.hts.report;

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
import com.genesis.common.configuration.SwaggerConfiguration;

/**
 * 
 * @author PalMurugan C
 *
 */
@EnableJpaAuditing
@EnableJpaRepositories
@SpringBootApplication
@Import({ AuditConfiguration.class, SwaggerConfiguration.class })
public class ReportBuilderApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ReportBuilderApplication.class, args);
	}

	@Bean
	public UndertowEmbeddedServletContainerFactory embeddedServletContainerFactory() {
		return new UndertowEmbeddedServletContainerFactory();
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ReportBuilderApplication.class);
	}
}
