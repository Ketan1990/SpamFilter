package com.spamfilter.utility;

import org.junit.Test;

public class StopWordsTest {
    @Test
    public void test(){
        String s= StopWords.getString("regX");
        System.out.println(s);
    }

}