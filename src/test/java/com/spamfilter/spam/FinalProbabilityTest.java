package com.spamfilter.spam;

import com.spamfilter.dataaccesslayer.QueryEngine;
import com.spamfilter.dataaccesslayer.SpamDAO;
import com.spamfilter.dataaccesslayer.testdouble.QueryEngineTestDouble;
import com.spamfilter.spam.spamclassification.FinalProbability;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ketan on 7/27/2014.
 */
public class FinalProbabilityTest {

    @Test
    public void ItShouldCalculateTotalProbabiltyWhenSizeIsBelow10(){
        FinalProbability probability=new FinalProbability(new SpamDAO(new QueryEngineTestDouble()));
        Double[]values={1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0,1.0};

        Double actual= probability.totalProbablity(values);
        Double expected=1.0;
        assertEquals(expected,actual);

    }
    @Test
    public void ItShouldCalculateTotalProbabiltyWhenSizeIsAbove10(){
        FinalProbability probability=new FinalProbability(new SpamDAO(new QueryEngineTestDouble()));
        Double[]values={1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0,1.0,0.765,0.865,0.987};

        Double actual= probability.totalProbablity(values);
        Double expected=0.653122575;
        assertEquals(expected,actual);

    }

}
