package com.spamfilter.dataaccesslayer;

import com.spamfilter.math.SpamProbability;

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
        return queryEngine.getScalarValue(key, "Probability");
    }

    public void updateSpamFrequency(String key, Integer value) {
        Double sf=new Double(value);
        Double spamFrequency=getSpamFrequencyCount(key)+value;
        Double genuineFrequency=getGenuinFrequencyCount(key);
        Double prob=SpamProbability.Calculate(spamFrequency, genuineFrequency);
        queryEngine.saveScalarValues(key, "spamFrequency",sf, prob);
    }

    public void updateGeniunFrequency(String key, Integer value) {
        Double gf=new Double(value);
        Double spamFrequency=getSpamFrequencyCount(key);
        Double genuineFrequency=getGenuinFrequencyCount(key)+value;
        Double prob= SpamProbability.Calculate(spamFrequency, genuineFrequency);
        queryEngine.saveScalarValues(key,"genuineFrequency",gf, prob);
    }

    public void insertGeniuneEmailID(String id) {
        if(!isPresentGenuineId(id)&&!isPresentSpamId(id))
            queryEngine.saveSingleValue("genuineEmailId", id);
    }

    public void insertSpamEmailID(String id) {
        if(!isPresentSpamId(id)&&!isPresentGenuineId(id))
            queryEngine.saveSingleValue("spamEmailId", id);
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

}
