package com.spamfilter.dataaccesslayer.testdouble;

import com.spamfilter.dataaccesslayer.QueryEngine;

/**
 * Created by ketan on 7/23/2014.
 */
public class QueryEngineTestDouble implements QueryEngine {
    private String key;
    private String subkey;
    private Double value;
    private Double value2;
    private String caption;
    private String id;

    @Override
    public double getScalarValue(String key, String subkey) {
        if (subkey.equals("spamFrequency")) {
            return 1.0;
        }else if (subkey.equals("geniunFrequecy")) {
            return 2.0;
        }
        return 0.33;
    }

    @Override
    public void saveScalarValues(String key, String subkey, Double value, Double value2) {
        this.key=key;
        this.subkey=subkey;
        this.value=value;
        this.value2=value2;
    }

    @Override
    public void saveSclarValue(String caption, String id) {
        this.caption=caption;
        this.id=id;

    }

    @Override
    public boolean isPresent(String caption, String id) {
        if(this.id!=null)
            return true;
        return false;
    }

    @Override
    public void remove(String key, String value) {

    }
}
