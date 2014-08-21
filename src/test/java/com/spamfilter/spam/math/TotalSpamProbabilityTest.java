package com.spamfilter.spam.math;

import com.spamfilter.spam.spammath.TotalSpamProbability;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by ketan on 7/26/2014.
 */
public class TotalSpamProbabilityTest{

    @Test
    public void ItShouldCountTotalProb(){
        //given
        Double []t={1.0,1.0,1.0,1.0,1.0,0.5};

        Double actual=  TotalSpamProbability.calulate(t);
        System.out.println(actual);

        Double expected=0.5;
        assertEquals(expected,actual);
    }
}
