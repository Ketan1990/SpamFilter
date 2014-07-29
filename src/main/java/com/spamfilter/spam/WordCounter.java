package com.spamfilter.spam;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ketan on 7/17/2014.
 */
public class WordCounter {
    private Map<String, Integer> wordCounter;
    private Integer defaultCount =1;

    public WordCounter(){
        setWordCounter(new HashMap<String, Integer>());
    }
    public void setWordCounter(Map<String, Integer> dummy) {
        this.wordCounter =dummy;
    }


    public boolean isWordPresent(String word) {

        return wordCounter.containsKey(word);
    }

    public void insert(String word) {
        if(isWordPresent(word)){
            wordCounter.put(word, wordCounter.get(word)+1);
        }else
            wordCounter.put(word, defaultCount);
    }

    public Map<String, Integer> getWordCounter() {

        return wordCounter;
    }

    public void insertWords(String[] words){
        for (String word : words)
            insert(word);
    }
}
