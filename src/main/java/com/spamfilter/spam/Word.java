package com.spamfilter.spam;

/**
 * Created by ketan on 8/21/2014.
 */
public class Word {
    private final String key;
    private final String type;
    private final Double count;
    private final Double prob;

    public Word(String key, String type, Double count, Double prob) {
        this.key=key;
        this.type=type;
        this.count=count;
        this.prob=prob;
    }

    public String getKey() {
        return key;
    }

    public String getType() {
        return type;
    }

    public Double getCount() {
        return count;
    }

    public Double getProb() {
        return prob;
    }
}
