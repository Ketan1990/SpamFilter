package com.spamfilter.spam.spamclassification;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ketan on 7/27/2014.
 */
public class FinalProbabilityTest {
    @Test
    public void itShouldFetchFinalProbaility(){
        FinalProbability probability=new FinalProbability();
        String[]proStrings={"happen","happen","below","it","those","all","wrote","in","few","you","ML"};
        Double []actual=probability.fetchThem(proStrings);
        Double[]expected={1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void ItShouldCalculateTotalProbabiltyWhenSizeIsBelow10(){
        FinalProbability probability=new FinalProbability();
        Double[]values={1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0,1.0};

        Double actual= probability.totalProbablity(values);
        Double expected=1.0;
        assertEquals(expected,actual);

    }
    @Test
    public void ItShouldCalculateTotalProbabiltyWhenSizeIsAbove10(){
        FinalProbability probability=new FinalProbability();
        Double[]values={1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0,1.0,0.765,0.865,0.987};

        Double actual= probability.totalProbablity(values);
        Double expected=0.653122575;
        assertEquals(expected,actual);

    }

}
