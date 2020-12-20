package com.uol.CompassoWS.config;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {

        ApiInfo apiInfo = new ApiInfo(
                "UOL Compasso API REST",
                "API REST de cadastro de cidade e cliente.",
                "1.0",
                null,
                new Contact("Rafael Gustavo Onorio", "https://github.com/ronorio/",
                        "rafaelonorio@outlook.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0.txt", new ArrayList<VendorExtension>()
        );

        return apiInfo;
    }

}