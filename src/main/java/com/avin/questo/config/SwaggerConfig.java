package com.avin.questo.config;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.AuthorizationCodeGrantBuilder;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.GrantType;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.service.TokenEndpoint;
import springfox.documentation.service.TokenRequestEndpoint;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {                                    
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
          .select()       
          .apis(RequestHandlerSelectors.basePackage("com.avin.questo.controller"))
          .paths(PathSelectors.any())
          .build().apiInfo(apiInfo())
          .securitySchemes(Arrays.asList(SecurityScheme()))
          .securityContexts(Arrays.asList(SecurityContext()));
    }
    @Bean
    public SecurityConfiguration security() {
        return SecurityConfigurationBuilder.builder()
            .clientId(CLIENT_ID)
            .clientSecret(CLIENT_SECRET)
            .scopeSeparator(" ")
            .useBasicAuthenticationWithAccessCodeGrant(true)
            .build();
    }
    
	private SecurityScheme securityScheme() {
    	GrantType grantType = new AuthorizationCodeGrantBuilder()
    	.tokenEndpoint(new TokenEndpoint(AUTH_SERVER + "/token", "oauthtoken"))
    	.tokenRequestEndpoint(
    	new TokenRequestEndpoint(AUTH_SERVER + "/authorize", CLIENT_ID, CLIENT_ID))
    	.build();
    	
    	SecurityScheme oauth = new OAuthBuilder().name("spring_oauth")
    	.grantTypes(Arrays.asList(grantType))
    	.scopes(Arrays.asList(scopes()))
    	.build();
    	return oauth;
    	}
    
    private ApiInfo apiInfo() {
        return new ApiInfo(
          "Questo", 
          "A Quiz platform API.", 
          "v1", 
          "Terms of service", 
          new Contact("Aravind S", "http://localhost:8080/v1/rest/questions", "iamaravinds@questo.com"), 
          "License of API", "API license URL", Collections.emptyList());
    }
}
