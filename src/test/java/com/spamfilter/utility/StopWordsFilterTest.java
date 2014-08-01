package com.spamfilter.utility;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Ketan on 7/17/2014.
 */
public class StopWordsFilterTest {

    @Test
    public void itShouldRemoveArticleAndConjunctions(){
        //given

        String text="this is why working for me as well as you too";
        String expected="working me you";

        //when
        String actual= StopWordsFilter.discardConjunctionAndArticles(text);
        assertEquals(expected,actual);
        //then


    }

}
