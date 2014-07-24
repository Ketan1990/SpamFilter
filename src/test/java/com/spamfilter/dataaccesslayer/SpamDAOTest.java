package com.spamfilter.dataaccesslayer;

import com.spamfilter.dataaccesslayer.testdouble.MockQueryEngine;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by ketan on 7/23/2014.
 */
public class SpamDAOTest {
    @Test
    public void itShouldGetSpamFreqeuncyForGivenWord() {
        //given
        QueryEngine queryEngine = new MockQueryEngine();
        SpamDAO spamdao = new SpamDAO(queryEngine);
        //when
        double actual = spamdao.getSpamFrequencyCount("someword");
        //then
        assertEquals(1, actual,0.0);
    }
    @Test
    public void itShouldGetGeniunFreqeuncyForGivenWord() {
        //given
        QueryEngine queryEngine = new MongoQueryEngine();
        SpamDAO spamdao = new SpamDAO(queryEngine);
        //when
        double actual = spamdao.getGenuinFrequencyCount("offer");
        //then
        assertEquals(0.0, actual,0.0);
    }
    @Test
    public void itShouldGetProbabilityForGivenWord() {
        //given
        QueryEngine queryEngine = new MockQueryEngine();
        SpamDAO spamdao = new SpamDAO(queryEngine);
        //when
        double actual = spamdao.getProbability("someword");
        //then
        assertEquals(0.33, actual,0);
    }
    @Test
    public void itShouldupdatewithSpamWord(){
        //given
        QueryEngine queryEngine = new MockQueryEngine();
        SpamDAO spamdao = new SpamDAO(queryEngine);
        //when
        spamdao.updateSpamFrequency("so",4);
        //then

    }
    @Test
    public void itShouldupdatewithGenuincount(){
        //given
        QueryEngine queryEngine = new MockQueryEngine();
        SpamDAO spamdao = new SpamDAO(queryEngine);
        //when
        spamdao.updateGeniunFrequency("so",4);
        //then

    }
    @Test
    public void itShouldStoreGeniuneEmailId() {
        //give
        QueryEngine queryEngine = new MockQueryEngine();
        SpamDAO spamdao = new SpamDAO(queryEngine);
        String id="ketan.jain@gmail.com";
        //when
        spamdao.insertGeniuneEmailID(id);
        //then
        assertTrue(spamdao.ispresentGeniunId(id));
    }
    @Test
    public void itShouldStoreSpamEmailId() {
        //give
        QueryEngine queryEngine = new MockQueryEngine();
        SpamDAO spamdao = new SpamDAO(queryEngine);
        String id="rocky.jain@gmail.com";
        //when
        spamdao.insertSpamEmailID(id);
        //then
        assertTrue(spamdao.ispresentSpamId(id));
    }
    @Test
    public void itShouldRemoveSpamEmailId() {
        //give
        QueryEngine queryEngine = new MockQueryEngine();
        SpamDAO spamdao = new SpamDAO(queryEngine);
        String id="rocky.jain@gmail.com";
        //when
        spamdao.removeSpamEmailID(id);
        //then
        //assertFalse(spamdao.ispresentSpamId(id));
    }
    @Test
    public void itShouldRemoveGeniuneEmailId() {
        //give
        QueryEngine queryEngine = new MockQueryEngine();
        SpamDAO spamdao = new SpamDAO(queryEngine);
        //when
        String id="ketan.jain@gmail.com";
        spamdao.removeGeninueEmailID(id);
        //then
        //	assertFalse(spamdao.ispresentSpamId(id));
    }
}
