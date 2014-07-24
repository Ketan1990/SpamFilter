package com.spamfilter.dataaccesslayer.testdouble;

import com.spamfilter.dataaccesslayer.QueryEngine;

/**
 * Created by ketan on 7/23/2014.
 */
public class MockQueryEngine implements QueryEngine {
    @Override
    public double getScalarValue(String key, String subkey) {

        return 0.0;
    }

    @Override
    public void saveScalarValues(String key, String subkey, Double value, Double value2) {

    }

    @Override
    public void saveSingleValue(String key, String value) {

    }

    @Override
    public boolean isPresent(String key, String value) {
        return false;
    }

    @Override
    public void remove(String key, String value) {

    }
}
