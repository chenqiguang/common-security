package com.common.cn.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.List;

@Profile({"!prod"})
@Configuration
@EnableSwagger2
public class SpringFoxConfiguration {
    @Bean
    public Docket imscApiV1Docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .securitySchemes(apiKeys())
                .securityContexts(Arrays.asList(securityContext()))
                .select()
                .paths(PathSelectors.regex("/.*/storage.*"))
                .build()
                .groupName("api-v1");
    }

    private List<ApiKey> apiKeys() {
        return Arrays.asList(
                new ApiKey("x-access-token", "x-access-token", "header")
        );
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(path -> !PathSelectors.regex("/security/.*").apply(path))
                .build();
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope
                = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(
                new SecurityReference("x-access-token", authorizationScopes)
        );
    }

}
