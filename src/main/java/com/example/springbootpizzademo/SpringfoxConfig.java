package com.example.springbootpizzademo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

//url för att få dokumentet med grafiskt gränssnitt:  localhost:8080/swagger-ui/

@Configuration
public class SpringfoxConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.OAS_30)
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.any())
                .build();
    }
}
