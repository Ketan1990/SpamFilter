package com.spamfilter.spam.math;

import com.spamfilter.spam.spammath.SpamProbability;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Ketan on 7/17/2014.
 */
public class SpamProbabilityTest {
    @Test
    public void itShouldCalculateProbWhenGenuineCountIsHigh(){
        int spamCount=1;
        int genuineCount=2;
        Double actual= SpamProbability.calculate(spamCount, genuineCount);
        Double expected=0.3333333333333333;
        assertEquals(expected,actual);
    }
    @Test
    public void itShouldCalculateProbWhenSpamCountIsHigh(){
        int spamCount=15;
        int genuineCount=2;
        Double actual= SpamProbability.calculate(spamCount, genuineCount);
        Double expected=1.0;
        assertEquals(expected,actual);
    }

}
