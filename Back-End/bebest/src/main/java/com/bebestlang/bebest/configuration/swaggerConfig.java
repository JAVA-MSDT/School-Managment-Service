package com.bebestlang.bebest.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class swaggerConfig {
    @Bean
    public Docket swaggerConfiguration() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/api/**"))
                .apis(RequestHandlerSelectors.basePackage("com.bebestlang.bebest"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("Ahmed Samy", "https://www.linkedin.com/in/java-msdt/", "serenitydiver@hotmail.com");
        return new ApiInfo(
                "Be Best Language School",
                "Api to work with Be Best Language School",
                "1.0",
                "Belong to Be Best Language School Project",
                contact,
                "Api license",
                "https://www.linkedin.com/in/java-msdt/",
                Collections.emptyList()
        );
    }
}
