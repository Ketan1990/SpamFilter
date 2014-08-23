package com.spamfilter.dataaccesslayer.Mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.spamfilter.dataaccesslayer.QueryEngine;
import com.spamfilter.spam.entity.Word;
import com.spamfilter.spam.entity.EmailAddress;

/*
Created by ketan on 7/23/2014.
*/


public class MongoQueryEngine implements QueryEngine {
    private static BasicDBObject query;
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

    private static class MongoQuery {


        public static final String SPAMWORD = "spamwords";
        public static final String WORD = "word";
        public static final String PROBABILITY = "probability";
        public static final String EMAIL_ID_SET = "emailIdSet";



     /*   private static BasicDBObject getQuery(String wordType) {
            return makeDocument().append("word", wordType);
        }

        private static BasicDBObject makeDocument() {
            return new BasicDBObject();
        }
*/
        public static Double getAttribute(String keyWord, String subKey) {
            query =getBasicDBObject("word",keyWord);
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
            MongoConfig.getCollection(EMAIL_ID_SET).insert(getBasicDBObject(key, id));
        }

        private static BasicDBObject getBasicDBObject(String key, String value) {
            return new BasicDBObject(key,value);
        }

        private static boolean isPresentEmailId(String key, String value) {
            return MongoConfig.getCollection(EMAIL_ID_SET).findOne(getBasicDBObject(key, value)) != null;
        }
        private static  void RemoveEmailId(String key, String value) {
            DBObject doc= getBasicDBObject(key, value);
            MongoConfig.getCollection(EMAIL_ID_SET).remove(doc);
        }

        public static void updateWord(String keyWord, String spamLabel, Double spamCount, String genuineLabel, Double genuineCount, Double prob) {
            BasicDBObject value= getBasicDBObject(WORD, keyWord).append(spamLabel, spamCount).append(genuineLabel,genuineCount)
                    .append(PROBABILITY, prob);
             DBObject wordqurey= getBasicDBObject(WORD, keyWord);
            MongoConfig.getCollection(SPAMWORD).update(wordqurey,value,true,false);
        }
    }

}
