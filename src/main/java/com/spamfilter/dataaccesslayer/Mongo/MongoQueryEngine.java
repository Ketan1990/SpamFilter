package com.spamfilter.dataaccesslayer.Mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.spamfilter.dataaccesslayer.QueryEngine;

/**
 * Created by ketan on 7/23/2014.
 */
public class MongoQueryEngine implements QueryEngine {
    private static BasicDBObject query;
    private static BasicDBObject count;
    private static BasicDBObject probability;
    private static DBCursor cursor;


    @Override
    public double getScalarValue(String key, String subkey) {
        return MongoQuery.getAttribute(key,subkey);
    }

    @Override
    public void saveScalarValues(String key, String subkey, Double value, Double value2) {
        MongoQuery.updateWord(key, subkey, value, value2);
    }

    @Override
    public void saveSingleValue(String key, String value) {
        MongoQuery.insert(key,value);
    }

    @Override
    public boolean isPresent(String key, String value) {
        return MongoQuery.isPresentEmailId(key,value);
    }

    @Override
    public void remove(String key, String value) {
        MongoQuery.RemoveEmailId(key,value);

    }
  private static class MongoQuery {
       public static void updateWord(String word, String attribute,Double frequency,Double prob) {
           query=getQuery(word);
           count=setFrequency(attribute, frequency);
           probability=setProbability(prob);
           MongoConfig.getCollection("words").update(query, count,true,false);
           MongoConfig.getCollection("words").update(query, probability,true,false);
       }
       public static BasicDBObject setProbability(Double prob) {
           return makeDocument().append("$set", makeDocument()
                   .append("probability", prob));
       }

       private static BasicDBObject  setFrequency(String attribute, Double sFrequency) {
           return makeDocument().append("$inc", makeDocument()
                   .append(attribute, sFrequency));
       }
       private static BasicDBObject getQuery(String wordType) {
           return makeDocument().append("word", wordType);
       }

       private static BasicDBObject makeDocument() {
           return new BasicDBObject();
       }

       public static Double getAttribute(String key, String subKey) {
           query =getQuery(key);
           cursor = MongoConfig.getCollection("words").find(query);
           Double value=null;
           while(cursor.hasNext()) {
               DBObject obj = cursor.next();
               value = (Double)obj.get(subKey);
               return  value!=null?value :0.0;
           }
           return subKey.equals("Probability")?1.0:0.0;
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

   }

}
