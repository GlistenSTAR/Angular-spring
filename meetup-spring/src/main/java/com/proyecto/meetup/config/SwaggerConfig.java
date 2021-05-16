package com.proyecto.meetup.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.List;

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
                .apiInfo(apiInfo())
                .securitySchemes(this.schemeList())
                .securityContexts(this.securityContext());
    }

    // http://localhost:8080/api/v0/swagger-ui.html
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Plataforma Meetup")
                .description("Plataforma de redes sociales para conectar personas con intereses comunes. " + "https://github.com/devcodxec/meetup-spring").build();
    }

    private List<SecurityScheme> schemeList() {
        return Arrays.asList(new BasicAuth("Basic"),
                new ApiKey("Bearer", "Authorization", "header"));
    }

    private List<SecurityContext> securityContext() {
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[]{new AuthorizationScope(
                "global", "accessEverything")};
        List<SecurityReference> BearerSecurityReferences = Arrays.asList(new SecurityReference("Bearer",
                authorizationScopes));
        List<SecurityReference> BasicSecurityReferences = Arrays.asList(new SecurityReference("Basic",
                authorizationScopes));
        return Arrays.asList(
                SecurityContext.builder().securityReferences(
                        BasicSecurityReferences).forPaths(PathSelectors.ant("/users/token/**")).build(),
                SecurityContext.builder().securityReferences(
                        BearerSecurityReferences).forPaths(PathSelectors.any()).build());
    }

}
