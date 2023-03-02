package com.rent.car.api.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("Car Rental Methods API")
            .description("API for Car Rental")
            .license("Test 2.0")
            .licenseUrl("https://www.google.com")
            .termsOfServiceUrl("")
            .version("1.1.0")
            .contact(new Contact("", "", "test@test.com"))
            .build();
    }

    @Bean
    public Docket customImplementation() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.rent.car.api"))
            .build()
            .tags(new Tag("Customer", "customer information"), new Tag("Reservation", "reservation information"))
            .directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
            .directModelSubstitute(java.time.OffsetDateTime.class, java.util.Date.class)
            .apiInfo(apiInfo());
    }

}
