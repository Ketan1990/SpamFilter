package com.spamfilter.dataaccesslayer;

/**
 * Created by ketan on 7/23/2014.
 */
public interface QueryEngine {
    public double getScalarValue(String key,String subkey);
    void saveScalarValues(String key, String subkey, Double value,Double value2);
    void saveSclarValue(String key, String value);
    boolean isPresent(String key,String value);
    void remove(String key,String value);

}
