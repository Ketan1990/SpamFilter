package com.spamfilter.dataaccesslayer;

import com.spamfilter.spam.entity.Word;
import com.spamfilter.spam.entity.EmailAddress;


/**
 * Created by ketan on 7/23/2014.
 */
public interface QueryEngine {
   
    void saveSclarValue(EmailAddress emailAddress);
    boolean isPresent(EmailAddress emailAddress);
    void remove(EmailAddress emailAddress);

    Double getScalarValue(Word word);
    void saveScalarValues(Word word);
}
