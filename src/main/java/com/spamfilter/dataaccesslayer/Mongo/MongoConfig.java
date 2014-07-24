package com.spamfilter.dataaccesslayer.Mongo;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;

import java.net.UnknownHostException;

/**
 * Created by ketan on 7/23/2014.
 */
public class MongoConfig {
    private static DB database;
    private static MongoClient mongo;

    public static DBCollection getCollection(String name) {
        getDB();
        return database.getCollection(name);

    }

    private static void getDB() {
        createMongoConnection();
        database=  mongo.getDB("SpamFilterWords");
    }

    private static void createMongoConnection(){
        try {
            if(mongo==null)
                mongo = new MongoClient("localhost", 27017);
        } catch (UnknownHostException e) {
            throw new MongoDBServerNotFound(e.getMessage());
        }

    }

    public static class MongoDBServerNotFound extends RuntimeException {
        public MongoDBServerNotFound(String message) {
            super(message);
        }
    }
}
