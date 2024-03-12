package com.brestrai.utils.configurations.database.mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.stereotype.Component;

@Component
public abstract class MongoConfiguration extends AbstractMongoClientConfiguration {

    public abstract String getHost();

    public abstract String getPort();

    public abstract String getDb();


    @Override
    protected String getDatabaseName() {
        return getDb();
    }

    @Override
    public MongoClient mongoClient() {
        return MongoClients.create("mongodb://"
                .concat(getHost())
                .concat(":")
                .concat(getPort()));
    }

}
