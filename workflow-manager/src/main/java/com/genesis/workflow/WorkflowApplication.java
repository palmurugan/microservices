package com.genesis.workflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

/**
 * 
 * @author palmurugan
 *
 */
@SpringBootApplication
public class WorkflowApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(WorkflowApplication.class, args);
	}

	@Bean
	public UndertowServletWebServerFactory embeddedServletContainerFactory() {
		UndertowServletWebServerFactory factory = new UndertowServletWebServerFactory();
		return factory;
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WorkflowApplication.class);
	}
}
