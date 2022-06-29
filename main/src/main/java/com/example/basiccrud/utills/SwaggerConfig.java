package com.example.basiccrud.utills;


import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi openApi(){
        return GroupedOpenApi.builder() // 사용
                .group("mit.shop") // swagger 에나오는 definition
                .pathsToMatch("/api/**") //api에 해당하는 거 다
                .packagesToScan("com.example.basiccrud.api")// 컨트롤 패키기 몽땅
                .build();
    }



}