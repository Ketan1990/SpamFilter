package com.spamfilter.utility;


import com.spamfilter.utility.StringUtility;
import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Created by ketan on 7/26/2014.
 */
public class StringUtilityTest {
    @Test
    public void itShouldSeparateBySpace() {
        //given
        String a="it ok dude";
        //when
        String[] actual = StringUtility.separateBySpace(a);
        //then
        String expected[]={"it","ok","dude"};

        assertArrayEquals(actual, expected);
    }
    @Test
    public void itShouldDiscardSpecialSymbol(){
        //given
        String text="this 32is@#$%% @## why 1213131 $$ @working 435for me as well as you too";
        String expected="this is why working for me as well as you too";
        //when

        String actual= StringUtility.discardSpecialSymbol(text);
        assertEquals(expected,actual);
        //then

    }

}
