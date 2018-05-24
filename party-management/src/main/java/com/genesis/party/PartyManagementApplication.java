package com.genesis.party;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.genesis.common.configuration.AuditConfiguration;
import com.genesis.common.configuration.SwaggerConfiguration;

/**
 * 
 * @author PalMurugan C
 *
 */

@EnableJpaAuditing
@SpringBootApplication
@ComponentScan({ "com.genesis.common", "com.genesis.party" })
@Import({ AuditConfiguration.class, SwaggerConfiguration.class })
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
