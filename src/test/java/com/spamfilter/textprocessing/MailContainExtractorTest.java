package com.spamfilter.textprocessing;


import com.spamfilter.opreation.FileRead;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Ketan on 7/19/2014.
 */
public class MailContainExtractorTest {
    @Test
    public void shouldExtractIdFromEmail()   {
        FileRead fr=new FileRead();
        String maildata=fr.read("F:\\spamprojct\\TRAIN_00007.eml");
        MailContainExtractor mt=new MailContainExtractor();
        String actual =mt.getEmailId(maildata);
        System.out.println(actual);
        assertEquals("craig@deersoft.com",actual);

    }

    @Test
    public void shouldExtractMessage_idFromEmail()   {
        FileRead fr=new FileRead();
        String maildata=fr.read("F:\\spamprojct\\testmails\\TRAIN_00007.eml");
        MailContainExtractor mt=new MailContainExtractor();
        String actual =mt.getMessageID(maildata);
        System.out.println(actual);
        assertEquals("AF40EEDE-B65C-11D6-8F61-00039396ECF2@deersoft.com",actual);

    }
    @Test
    public void shouldExtractMessaggBodyFromEmail()   {
        FileRead fr=new FileRead();
        String maildata=fr.read("F:\\spamprojct\\testmails\\TRAIN_00011.eml");
        MailContainExtractor mt=new MailContainExtractor();
        String actual =mt.getBodyContant(maildata);
        System.out.println(actual);


    }

}
