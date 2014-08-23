package com.spamfilter.dataaccesslayer.Mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.spamfilter.dataaccesslayer.QueryEngine;
import com.spamfilter.spam.Word;
import com.spamfilter.spam.EmailAddress;

/*
Created by ketan on 7/23/2014.
*/


public class MongoQueryEngine implements QueryEngine {
    private static BasicDBObject query;
    private static BasicDBObject count;
    private static BasicDBObject probability;
    private static DBCursor cursor;


    @Override
    public void saveSclarValue(EmailAddress emailAddress) {
        MongoQuery.insert(emailAddress.getLabel(), emailAddress.getId());

    }

    @Override
    public boolean isPresent(EmailAddress emailAddress) {
        return MongoQuery.isPresentEmailId(emailAddress.getLabel(), emailAddress.getId());
    }

    @Override
    public void remove(EmailAddress emailAddress) {
         MongoQuery.RemoveEmailId(emailAddress.getLabel(),emailAddress.getId());

    }

    @Override
    public Double getScalarValue(Word word) {
        return MongoQuery.getAttribute(word.getKeyWord(),word.getSubkey());
    }

    @Override
    public void saveScalarValues(Word word) {
        MongoQuery.updateWord(word.getKeyWord(),word.getSpamLabel(),word.getSpamCount(),word.getGenuineLabel(), word.getGeuineCount(),word.getProb());

    }

    public double getScalarValue(String key, String subkey) {
        return MongoQuery.getAttribute(key,subkey);
    }




    public void saveSclarValue(String key, String value) {
        MongoQuery.insert(key,value);
    }

    public boolean isPresent(String key, String value) {
        return MongoQuery.isPresentEmailId(key,value);
    }


    public void remove(String key, String value) {
        MongoQuery.RemoveEmailId(key,value);

    }

    private static class MongoQuery {


        private static BasicDBObject  setValue(String attribute, Double value,String operator ) {
            return makeDocument().append(operator , makeDocument()
                    .append(attribute, value));
        }

        private static BasicDBObject getQuery(String wordType) {
            return makeDocument().append("word", wordType);
        }

        private static BasicDBObject makeDocument() {
            return new BasicDBObject();
        }

        public static Double getAttribute(String key, String subKey) {
            query =getQuery(key);
            cursor = MongoConfig.getCollection("spamwords").find(query);
            Double value=null;
            while(cursor.hasNext()) {
                DBObject obj = cursor.next();
                value = (Double)obj.get(subKey);
                if(value!=null)
                    return  value ;
            }
            return 0.0;
        }

        public static void insert(String key, String id) {
            DBObject doc=new BasicDBObject(key,id);
            MongoConfig.getCollection("emailIdSet").insert(doc);
        }
        private static boolean isPresentEmailId(String key, String value) {
            DBObject document=new BasicDBObject(key,value);
            return MongoConfig.getCollection("emailIdSet").findOne(document) != null;
        }
        private static  void RemoveEmailId(String key, String value) {
            DBObject doc=new BasicDBObject(key,value);
            MongoConfig.getCollection("emailIdSet").remove(doc);
        }

        public static void updateWord(String keyWord, String spamLabel, Double spamCount, String genuineLabel, Double genuineCount, Double prob) {
            BasicDBObject value=new BasicDBObject("word",keyWord).append(spamLabel,spamCount).append(genuineLabel,genuineCount)
                    .append("probability", prob);
             DBObject wordqurey=new BasicDBObject("word",keyWord);
            MongoConfig.getCollection("spamwords").update(wordqurey,value,true,false);
        }
    }

}
