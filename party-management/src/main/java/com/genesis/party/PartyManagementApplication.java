package com.genesis.party;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.genesis.common.configuration.AuditConfiguration;

/**
 * 
 * @author PalMurugan C
 *
 */

@EnableJpaAuditing
// @EnableJpaRepositories(basePackages = "com.genesis.party")
@SpringBootApplication
@Import(AuditConfiguration.class)
public class PartyManagementApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(PartyManagementApplication.class, args);
    }

    @Bean
    public UndertowServletWebServerFactory embeddedServletContainerFactory() {
        UndertowServletWebServerFactory factory = new UndertowServletWebServerFactory();
        return factory;
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PartyManagementApplication.class);
    }

}
