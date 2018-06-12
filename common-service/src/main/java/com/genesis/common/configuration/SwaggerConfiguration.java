package com.genesis.common.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * 
 * @author PalMurugan C
 *
 */

public class SwaggerConfiguration {

	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("PTracker", "PTracker REST API's", "PTracker", "Terms of service",
                new Contact("PalMurugan", "http://ptracker.in", "palmurugan.c@gmail.com"), "License of API", "API license URL", Collections.emptyList());
    }
}
