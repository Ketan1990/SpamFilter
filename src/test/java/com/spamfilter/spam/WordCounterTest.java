package com.spamfilter.spam;

import com.spamfilter.spam.WordCounter;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;


/**
 * Created by Ketan on 7/17/2014.
 */
public class WordCounterTest {
    WordCounter counter=new WordCounter();

    @Before
    public  void setup() {
        Map<String, Integer> dummy=new HashMap<String,Integer>();
        dummy.put("ketan", new Integer(1));
        dummy.put("jain", new Integer(5));
        counter.setWordCounter(dummy);
    }
    @Test
    public void itShouldCheckWhetherWordPresentExistsWordCounter() {

        boolean condition=counter.isWordPresent("jain");
        assertTrue(condition);
    }
    @Test
    public void itShouldInsertWordOrIncrementCount(){
        counter.insert("ketan");
        counter.insert("Hitesh");
        assertEquals(counter.getWordCounter().get("ketan"), new Integer(2));
        assertEquals(counter.getWordCounter().get("Hitesh"), new Integer(1));
    }



}
