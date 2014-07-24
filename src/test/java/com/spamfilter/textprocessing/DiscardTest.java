package com.spamfilter.textprocessing;

import com.spamfilter.textprocessing.Discard;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Ketan on 7/17/2014.
 */
public class DiscardTest {
    @Test
    public void itShouldDiscardSpecialSymbol(){
        //given
        String text="this is@#$%% why $ $ working for me as well as you too";
        String expected="this is why working for me as well as you too";
        Discard d=new Discard();

        //when

        String actual= d.discardSpecialSymbol(text);
        assertEquals(expected,actual);
        //then


    }
    @Test
    public void itShouldRemoveArticleAndConjunctions(){
        //given

        String text="this is why working for me as well as you too";
        String expected="working me you";
        Discard d=new Discard();
        String actual1= d.discardSpecialSymbol(text);

        //when
        String actual= d.discardConjunctionAndArticles(actual1);
        assertEquals(expected,actual);
        //then


    }

}
