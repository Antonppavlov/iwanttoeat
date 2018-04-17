package ru.appavlov.iwanttoeat;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("ru.appavlov.iwanttoeat.controller"))
                //.paths(regex(".*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {


        return new ApiInfo(
                "API сервиса 'I want to eat'",
                "Автоматически сгенерированная Swagger документация по API сервиса 'I want to eat'",
                "0.0.1",

                "Terms of Service",

                new Contact(
                        "Anton Pavlov",
                        "https://github.com/Antonppavlov",
                        "anton.it.pavlov@gmail.com"),

                "Apache License Version 2.0",
                "https://www.apache.org/licesen.html",

                Collections.emptyList());
    }
}