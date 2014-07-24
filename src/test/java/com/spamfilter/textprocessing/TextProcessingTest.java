package com.spamfilter.textprocessing;

import com.spamfilter.datastructures.WordCounter;
import com.spamfilter.textprocessing.TextProcessing;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;
/**
 * Created by Ketan on 7/18/2014.
 */
public class TextProcessingTest {
    @Test
    public void itShouldCountWords(){
        String setence="this is@#$%% why $ $ working for me as well as you too";
        TextProcessing wds=new TextProcessing();
        WordCounter wc=wds.process(setence);
        Iterator<String>it=wc.getWordCounter().keySet().iterator();
        while(it.hasNext()){
            String key=it.next();
            Integer value=wc.getWordCounter().get(key);
            System.out.println(key+":"+value);
        }
    }

}
