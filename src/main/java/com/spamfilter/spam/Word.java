package com.spamfilter.spam;

/**
 * Created by ketan on 8/22/2014.
 */
public class Word {

    private  String keyWord;
    private  String spamLabel;
    private  Double spamCount;
    private  String genuineLabel;
    private  Double geuineCount;
    private  Double prob;
    private  String subkey;

    public Word(String keyWord, String spamLabel, Double spamCount, String genuineLabel, Double genuineCount, Double prob) {
        this.keyWord=keyWord;
        this.spamLabel=spamLabel;
        this.spamCount=spamCount;
        this.genuineLabel=genuineLabel;
        this.geuineCount=genuineCount;
        this.prob=prob;
    }

    public Word(String keyWord, String subKey) {
        this.keyWord=keyWord;
        this.subkey=subKey;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public String getSpamLabel() {
        return spamLabel;
    }

    public Double getSpamCount() {
        return spamCount;
    }

    public String getGenuineLabel() {
        return genuineLabel;
    }

    public Double getProb() {
        return prob;
    }

    public Double getGeuineCount() {
        return geuineCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word word = (Word) o;

        if (keyWord != null ? !keyWord.equals(word.keyWord) : word.keyWord != null) return false;
        if (genuineLabel != null ? !genuineLabel.equals(word.genuineLabel) : word.genuineLabel != null) return false;
        if (geuineCount != null ? !geuineCount.equals(word.geuineCount) : word.geuineCount != null) return false;
        if (prob != null ? !prob.equals(word.prob) : word.prob != null) return false;
        if (spamCount != null ? !spamCount.equals(word.spamCount) : word.spamCount != null) return false;
        if (spamLabel != null ? !spamLabel.equals(word.spamLabel) : word.spamLabel != null) return false;

        return true;
    }

    public String getSubkey() {
        return subkey;
    }
}
