package com.bebestlang.bebest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.gridfs.ReactiveGridFsTemplate;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class CommonConfiguration {

   // @Bean
    public RouterFunction<ServerResponse> staticResourceRouter() {
        System.out.println("RouterFunction:: ");
        return RouterFunctions.resources("/**", new ClassPathResource("images/"));
    }

    @Bean
    public ReactiveGridFsTemplate reactiveGridFsTemplate(
            ReactiveMongoDatabaseFactory databaseFactory,
            MappingMongoConverter mongoConverter) {
        return new ReactiveGridFsTemplate(databaseFactory, mongoConverter);
    }
}
