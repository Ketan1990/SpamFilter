package com.spamfilter.dataaccesslayer;
import com.spamfilter.dataaccesslayer.testdouble.QueryEngineTestDouble;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/*
  Created by ketan on 7/23/2014.*/


public class SpamDAOTest {
   private  QueryEngine queryEngine=new QueryEngineTestDouble();


    @Test
    public void itShouldGetSpamFreqeuncyForGivenWord() {

    }
    @Test
    public void itShouldGetGeniunFreqeuncyForGivenWord() {


    }
    @Test
    public void itShouldGetProbabilityForGivenWord() {
        //given
        SpamDAO spamdao = new SpamDAO(queryEngine);
        //when
        Double actual = spamdao.getProbability("so");
        //then
        Double expected=0.33;
        assertEquals(expected, actual);
    }
    @Test
    public void itShouldUpdateWithSpamWord(){
        //given

        SpamDAO spamdao = new SpamDAO(queryEngine);
        //when
        spamdao.updateSpamFrequency("so",12);
        //then
    }
    @Test
    public void itShouldUpdateWithGenuincount(){
        //given
        SpamDAO spamdao = new SpamDAO(queryEngine);
        //when
        spamdao.updateGeniunFrequency("so",4);
        //then
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
    public void itShouldRemoveSpamEmailId() {
        //give
        SpamDAO spamdao = new SpamDAO(queryEngine);
        String id="rocky.jain@gmail.com";
        //when
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
    public void itShouldFetchFinalProbaility(){
        SpamDAO spamdao = new SpamDAO(queryEngine);
        String[]proStrings={"do","enter","Best"};
        Double []actual=spamdao.getAllProbability(proStrings);
        Double[]expected={0.33,0.33, 0.33};
        assertArrayEquals(expected, actual);
    }
}
