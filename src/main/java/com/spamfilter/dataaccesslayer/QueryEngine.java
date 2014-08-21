package com.spamfilter.dataaccesslayer;

import com.spamfilter.spam.EmailAddress;

/**
 * Created by ketan on 7/23/2014.
 */
public interface QueryEngine {
    public double getScalarValue(String key,String subkey);
    void saveScalarValues(String key, String subkey, Double value,Double value2);
    void saveSclarValue(EmailAddress emailAddress);
    boolean isPresent(EmailAddress emailAddress);
    void remove(EmailAddress emailAddress);

}
