package com.spamfilter.spam;

import com.spamfilter.spam.WordCounter;
import com.spamfilter.spam.WordCounts;
import org.junit.Test;

import java.util.Iterator;

/**
 * Created by Ketan on 7/18/2014.
 */
public class WordContsTest {
    WordCounts wds=new WordCounts();

    @Test
    public void itShouldCountWords(){
        String setence="this is@#$%% why $ $ working for me as well as you too";
        WordCounter wc=wds.counts(setence);
        Iterator<String>it=wc.getWordCounter().keySet().iterator();
        while(it.hasNext()){
            String key=it.next();
            Integer value=wc.getWordCounter().get(key);
            System.out.println(key+":"+value);
        }
    }

}
