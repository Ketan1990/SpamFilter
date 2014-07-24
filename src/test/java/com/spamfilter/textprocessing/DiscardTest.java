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
        String text="its! ok-dude $#%(^&)@";
        String expected="its ok dude";
        Discard d=new Discard();

        //when
        String actual= d.discardSpecialSymbol(text);
        assertEquals(expected,actual);
        //then


    }
    @Test
    public void itShouldRemoveArticleAndConjunctions(){
        //given

        String text="this is why where working for me as well as you too";
        String expected="working me you";
        Discard d=new Discard();

        //when
        String actual= d.discardConjunctionAndArticles(text);
        System.out.println(actual);
        assertEquals(expected,actual);
        //then


    }

}
