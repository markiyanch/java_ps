package com.project_java_ps.mchakloshl3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
public class SwaggerConfig {

    private ApiInfo apiInfo() {
        return new ApiInfo("Blog REST APIs",
                "REST APIs for Student Account Management",
                "1.0",
                "Terms of service",
                new Contact("Markiian Chaklosh", "uken.krakow.pl", "markiian.chaklosh@student.up.krakow.pl"),
                "License of API",
                "API license URL",
                Collections.emptyList());
    }
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}