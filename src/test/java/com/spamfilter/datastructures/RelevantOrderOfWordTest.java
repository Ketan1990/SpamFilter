package com.spamfilter.datastructures;

import com.sun.corba.se.impl.util.RepositoryId;
import com.spamfilter.datastructures.RelevantOrderOfWord;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Ketan on 7/17/2014.
 */
public class RelevantOrderOfWordTest {

    @Test
    public void itShouldInsertWordInRelevantOrder(){
        RelevantOrderOfWord t=new RelevantOrderOfWord();
        t.insert("ketan",1.0);
        t.insert("hitesh",0.86);

    }
    @Test
    public void test(){
        //given
        Map<String,Double> normal=new TreeMap<String, Double>();
        normal.put("ketan", 1.0);
        normal.put("hitesh", 0.85);
        normal.put("ankit", 1.0);
        normal.put("ketan1", 0.70);
        normal.put("hitesh1", 0.85);
        normal.put("ankit1", 1.0);
        System.out.println(normal);
        //when
        Map<String,Double> soreted=new  RelevantOrderOfWord().sortedByValue(normal);
        System.out.println(soreted);
    }

}
