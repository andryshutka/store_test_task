package com.ashutka.app.configuration;

import com.github.mongobee.Mongobee;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.internal.MongoClientImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDbFactory;

import java.util.Collection;
import java.util.Collections;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Bean
    public Mongobee mongobee(){
        Mongobee runner = new Mongobee("mongodb://localhost:27017/store");
        runner.setDbName("store");         // host must be set if not set in URI
        runner.setChangeLogsScanPackage(
                "com.ashutka.migrations"); // the package to be scanned for changesets

        return runner;
    }
    private String mongoHost = "localhost";

    private String mongoPort = "27017";

    private String mongoDB = "store";

    @Bean
    public MongoDbFactory mongoDbFactory() {
        return new SimpleMongoClientDbFactory(mongoClient(), mongoDB);
    }

    @Bean
    public MongoClient mongoClient() {
        return new MongoClientImpl(MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString("mongodb://localhost:27017/store"))
                .build(), null);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongoDbFactory(), mappingMongoConverter());
    }

    @Override
    protected String getDatabaseName() {
        return "store";
    }

    @Override
    protected Collection<String> getMappingBasePackages() {
        return Collections.singleton("com.ashutka.app.entity");
    }
}
