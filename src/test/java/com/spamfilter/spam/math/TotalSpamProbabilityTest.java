package com.spamfilter.spam.math;

import com.spamfilter.spammath.TotalSpamProbability;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by ketan on 7/26/2014.
 */
public class TotalSpamProbabilityTest{




    @Test
    public void ItShouldCountTotalProb(){
        //given
        Double []t={1.0,1.0,1.0,1.0,1.0,0.5,0.76,0.456,0.23,0.4777777,0.54,0.456,0.67,0.776,0.7};

        Double actual=  TotalSpamProbability.calulate(t);
        System.out.println(actual);
        Double expected=0.019041543566880002;
        assertEquals(actual,expected);

    }
}
