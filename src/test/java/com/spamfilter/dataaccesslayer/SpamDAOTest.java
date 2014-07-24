package com.spamfilter.dataaccesslayer;

import com.spamfilter.dataaccesslayer.Mongo.MongoQueryEngine;
import com.spamfilter.dataaccesslayer.testdouble.MockQueryEngine;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by ketan on 7/23/2014.
 */
public class SpamDAOTest {
   private  QueryEngine queryEngine = new MockQueryEngine();

    @Test
    public void itShouldGetSpamFreqeuncyForGivenWord() {
        //given
        SpamDAO spamdao = new SpamDAO(queryEngine);
        //when
        double actual = spamdao.getSpamFrequencyCount("someword");
        //then
        assertEquals(1, actual,0.0);
    }
    @Test
    public void itShouldGetGeniunFreqeuncyForGivenWord() {
        //given
        QueryEngine queryEngine = new MockQueryEngine();
        SpamDAO spamdao = new SpamDAO(queryEngine);
        //when
        double actual = spamdao.getGenuinFrequencyCount("someword");
        //then
        assertEquals(0.33, actual,0.0);
    }
    @Test
    public void itShouldGetProbabilityForGivenWord() {
        //given
        SpamDAO spamdao = new SpamDAO(queryEngine);
        //when
        double actual = spamdao.getProbability("someword");
        //then
        assertEquals(0.33, actual,0);
    }
    @Test
    public void itShouldUpdateWithSpamWord(){
        //given
        QueryEngine queryEngine = new MongoQueryEngine();

        SpamDAO spamdao = new SpamDAO(queryEngine);
        //when
        spamdao.updateSpamFrequency("so",14);
        //then



    }
    @Test
    public void itShouldUpdateWithGenuincount(){
        //given
          QueryEngine queryEngine = new MongoQueryEngine();

        SpamDAO spamdao = new SpamDAO(queryEngine);
        //when
        spamdao.updateGeniunFrequency("so",4);
        //then

    }
    @Test
    public void itShouldStoreGeniuneEmailId() {
        //give
          QueryEngine queryEngine = new MongoQueryEngine();

        SpamDAO spamdao = new SpamDAO(queryEngine);
        String id="ketan.jain@gmail.com";
        //when
        spamdao.insertGeniuneEmailID(id);
        //then
        assertTrue(spamdao.isPresentGenuineId(id));
    }
    @Test
    public void itShouldStoreSpamEmailId() {
        //give

        SpamDAO spamdao = new SpamDAO(queryEngine);
        String id="rocky.jain@gmail.com";
        //when
        spamdao.insertSpamEmailID(id);
        //then
        assertTrue(spamdao.isPresentSpamId(id));
    }
    @Test
    public void itShouldRemoveSpamEmailId() {
        //give


        SpamDAO spamdao = new SpamDAO(queryEngine);
        String id="rocky.jain@gmail.com";
        //when
        spamdao.removeSpamEmailID(id);
        //then
        assertFalse(spamdao.isPresentSpamId(id));
    }
    @Test
    public void itShouldRemoveGeniuneEmailId() {
        //give

        SpamDAO spamdao = new SpamDAO(queryEngine);
        //when
        String id="rocky.jain@gmail.com";
        spamdao.removeGeniuneEmailID(id);
        //then
        	assertFalse(spamdao.isPresentSpamId(id));
    }
}
