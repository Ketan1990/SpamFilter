package com.spamfilter.dataaccesslayer;

import com.spamfilter.spam.Word;
import com.spamfilter.spam.EmailAddress;
import com.spamfilter.spam.spammath.SpamProbability;
import com.spamfilter.utility.DuplicateWordFilter;

/**
 * Created by ketan on 7/23/2014.
 */
public class SpamDAO {
    private QueryEngine queryEngine;

    public SpamDAO(QueryEngine queryEngine) {
        this.queryEngine=queryEngine;
    }

    public double getSpamFrequencyCount(String key) {
        Double count= queryEngine.getScalarValue(new Word(key,"spamFrequency"));
        return count;
    }

    public double getGenuinFrequencyCount(String key) {
        return queryEngine.getScalarValue(new Word(key,"genuineFrequency"));
    }

    public double getProbability(String key) {
        return queryEngine.getScalarValue(new Word(key, "probability"));
    }

    public void updateSpamFrequency(String key, Integer value) {
        Double sf=new Double(value);
        Double spamFrequency=getSpamFrequencyCount(key)+sf;
        Double genuineFrequency=getGenuinFrequencyCount(key);
        Double prob=SpamProbability.calculate(spamFrequency, genuineFrequency);
        queryEngine.saveScalarValues(new Word(key,"spamFrequency",spamFrequency,"genuineFrequency",genuineFrequency,prob));
    }

    public void updateGeniunFrequency(String key, Integer value) {
        Double gf=new Double(value);
        Double spamFrequency=getSpamFrequencyCount(key);
        Double genuineFrequency=getGenuinFrequencyCount(key)+gf;
        Double prob= SpamProbability.calculate(spamFrequency, genuineFrequency);
        queryEngine.saveScalarValues(new Word(key,"spamFrequency",spamFrequency,"genuineFrequency",genuineFrequency,prob));
    }

    public void insertGeniuneEmailID(String id) {
        if(!isPresentGenuineId(id))
            queryEngine.saveSclarValue(new EmailAddress("genuineEmailId", id));
    }

    public void insertSpamEmailID(String id) {
        if(!isPresentSpamId(id))
            queryEngine.saveSclarValue(new EmailAddress("spamEmailId", id));
    }

    public boolean isPresentGenuineId(String id) {
        return queryEngine.isPresent(new EmailAddress("genuineEmailId", id));
    }

    public boolean isPresentSpamId(String id) {
        return queryEngine.isPresent(new EmailAddress("spamEmailId", id));
    }

    public void removeSpamEmailID(String id) {
        queryEngine.remove(new EmailAddress("spamEmailId", id));
    }

    public void removeGeniuneEmailID(String id) {
        queryEngine.remove(new EmailAddress("genuineEmailId", id));
    }
    public Double[] getAllProbability(String[] word) {
        String[]spamwords= DuplicateWordFilter.uniqueWords(word);
        Double[] finalprobabilty = new Double[spamwords.length];
        for (int i = 0; i <spamwords.length; i++) {

            finalprobabilty[i]=getProbability(word[i]);
        }
        return finalprobabilty;
    }

}
