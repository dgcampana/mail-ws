package com.kmp.mailws;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.kmp.mailws.application.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public ApiInfo apiInfo() {
        Contact contact = new Contact("Titulo","https://www.dgc.com.mx/","mail@mail.mx");
        return new ApiInfoBuilder().title("API REST")
                .description("Api de consulta para desarrolladores")
                .termsOfServiceUrl("Terminos de servicio N/A").contact(contact)
                .license("Licencia N/A")
                .licenseUrl("contacto@mail.mx").version("1.0").build();

    }
}