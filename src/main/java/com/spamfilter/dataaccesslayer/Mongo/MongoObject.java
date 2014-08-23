package com.spamfilter.dataaccesslayer.Mongo;

import com.mongodb.DBObject;
import com.spamfilter.spam.Word;
import org.bson.BSONObject;

import java.util.Map;
import java.util.Set;

/**
 * Created by ketan on 8/23/2014.
 */
public class MongoObject implements DBObject {
    private final Word word;

    public  MongoObject(Word word){
        this.word=word;
    }
    @Override
    public void markAsPartialObject() {

    }

    @Override
    public boolean isPartialObject() {
        return false;
    }

    @Override
    public Object put(String s, Object o) {
        return null;
    }

    @Override
    public void putAll(BSONObject bsonObject) {

    }

    @Override
    public void putAll(Map map) {

    }

    @Override
    public Object get(String s) {
        return null;
    }

    @Override
    public Map toMap() {
        return null;
    }

    @Override
    public Object removeField(String s) {
        return null;
    }

    @Override
    public boolean containsKey(String s) {
        return false;
    }

    @Override
    public boolean containsField(String s) {
        return false;
    }

    @Override
    public Set<String> keySet() {
        return null;
    }
}
