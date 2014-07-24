package com.spamfilter.opreation;

import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

/**
 * Created by ketan on 7/24/2014.
 */
public class FileListingTest {
    @Test
    public void itShouldAbleToGiveLIstOfMailFile() {
        //given
        FileListing files=new FileListing();
        LinkedList<String> expecteds=new LinkedList<String>();
        expecteds.add("TRAIN_00007.eml");

        //when
        LinkedList<String>actual=files.listOf("E:\\git\\SpamFilter\\testmails");
        assertEquals(actual.getFirst(), expecteds.getFirst());
    }
}
