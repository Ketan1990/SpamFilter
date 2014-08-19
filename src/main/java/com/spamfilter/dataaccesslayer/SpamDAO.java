package com.spamfilter.dataaccesslayer;

import com.spamfilter.spammath.SpamProbability;
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
        return queryEngine.getScalarValue(key,"spamFrequency");
    }

    public double getGenuinFrequencyCount(String key) {
        return queryEngine.getScalarValue(key, "genuineFrequency");
    }

    public double getProbability(String key) {
        return queryEngine.getScalarValue(key, "probability");
    }

    public void updateSpamFrequency(String key, Integer value) {
        Double sf=new Double(value);
        Double spamFrequency=getSpamFrequencyCount(key)+value;
        Double genuineFrequency=getGenuinFrequencyCount(key);
        Double prob=SpamProbability.calculate(spamFrequency, genuineFrequency);
        queryEngine.saveScalarValues(key, "spamFrequency",sf, prob);
    }

    public void updateGeniunFrequency(String key, Integer value) {
        Double gf=new Double(value);
        Double spamFrequency=getSpamFrequencyCount(key);
        Double genuineFrequency=getGenuinFrequencyCount(key)+value;
        Double prob= SpamProbability.calculate(spamFrequency, genuineFrequency);
        queryEngine.saveScalarValues(key,"genuineFrequency",gf, prob);
    }

    public void insertGeniuneEmailID(String id) {
        if(!isPresentGenuineId(id))
            queryEngine.saveSclarValue("genuineEmailId", id);
    }

    public void insertSpamEmailID(String id) {
        if(!isPresentSpamId(id))
            queryEngine.saveSclarValue("spamEmailId", id);
    }

    public boolean isPresentGenuineId(String id) {
        return queryEngine.isPresent("genuineEmailId", id);
    }

    public boolean isPresentSpamId(String id) {
        return queryEngine.isPresent("spamEmailId", id);
    }

    public void removeSpamEmailID(String id) {
        queryEngine.remove("spamEmailId", id);
    }

    public void removeGeniuneEmailID(String id) {
        queryEngine.remove("genuineEmailId", id);

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
