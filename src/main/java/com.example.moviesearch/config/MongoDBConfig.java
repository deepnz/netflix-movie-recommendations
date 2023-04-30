// MongoDBConfig.java
package com.example.moviesearch.config;

import com.mongodb.MongoClientURI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.example.moviesearch.repository")
public class MongoDBConfig {
    @Bean
    public MongoTemplate mongoTemplate() {
        MongoClientURI uri = new MongoClientURI("mongodb://localhost:27017/movies");
        SimpleMongoClientDbFactory dbFactory = new SimpleMongoClientDbFactory(uri);
        return new MongoTemplate(dbFactory);
    }
}
