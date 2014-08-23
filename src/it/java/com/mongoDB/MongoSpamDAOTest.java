package com.mongoDB;
import com.spamfilter.dataaccesslayer.Mongo.MongoConfig;

import com.spamfilter.dataaccesslayer.Mongo.MongoQueryEngine;
import com.spamfilter.dataaccesslayer.QueryEngine;
import com.spamfilter.dataaccesslayer.SpamDAO;

import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by ketan on 8/23/2014.
 */
public class MongoSpamDAOTest {

private QueryEngine queryEngine=new MongoQueryEngine();
    @Test
    public void itShouldInsertSpamEmailId() {
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
        //when
        String id="rocky.jain@gmail.com";
        spamdao.insertSpamEmailID(id);

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
        spamdao.insertGeniuneEmailID(id);
        spamdao.removeGeniuneEmailID(id);
        //then
        assertFalse(spamdao.isPresentSpamId(id));
    }



    @Test
    public void itShouldUpdateWithSpamWord(){
        //given
        SpamDAO spamdao = new SpamDAO(queryEngine);
        //when
        spamdao.updateSpamFrequency("so",4);
        spamdao.updateGeniunFrequency("so", 4);
        Double expected=4.0;
        Double actual=spamdao.getSpamFrequencyCount("so");
        //then
        assertEquals(expected,actual);

    }
    @Test
    public void itShouldUpdateWithGenuincount(){
        //given
        SpamDAO spamdao = new SpamDAO(queryEngine);
        //when
        spamdao.updateGeniunFrequency("so", 4);

        //then
        Double expected=4.0;
        Double actual=spamdao.getGenuinFrequencyCount("so");
        assertEquals(expected,actual);

    }
    @Test
    public void itShouldCheckProbability(){
        //given
        SpamDAO spamdao = new SpamDAO(queryEngine);
        //when
        spamdao.updateGeniunFrequency("so",2);
        spamdao.updateSpamFrequency("so",2);
        //then
        Double expected=0.5;
        Double actual=spamdao.getProbability("so");
        assertEquals(expected,actual);
    }
    @Test
    public void itShouldStoreGeniuneEmailId() {
        //give
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
    public void itShouldFetchFinalProbaility(){
       //given
        SpamDAO spamdao = new SpamDAO(queryEngine);
        spamdao.updateGeniunFrequency("do",2);
        spamdao.updateSpamFrequency("do",2);

        spamdao.updateGeniunFrequency("enter",2);
        spamdao.updateSpamFrequency("enter",2);
        spamdao.updateGeniunFrequency("best",2);
        spamdao.updateSpamFrequency("best",2);
      //when
        String[]proStrings={"do","enter","best"};
        Double []actual=spamdao.getAllProbability(proStrings);
        Double[]expected={0.5,0.5, 0.5};
       //then
        assertArrayEquals(expected, actual);
    }
@After
   public void tearDown(){
       MongoConfig.deleteDB();
    }

}
