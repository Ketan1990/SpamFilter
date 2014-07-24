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
        String maildata=fr.read("E:\\git\\SpamFilter\\testmails\\TRAIN_00011.eml");
        MailContainExtractor mt=new MailContainExtractor();
        String actual =mt.getBodyContantOfSpamEmail(maildata);
        System.out.println(actual);
        assertEquals(actual.length(),5374);


    }
    @Test
    public void shouldExtractMessaggBodyFromGEmail()   {
        FileRead fr=new FileRead();
        String maildata=fr.read("E:\\git\\SpamFilter\\gmailstest\\508102099.RPBLNBTE.36445.635320417278915000@GEN2.center.com.eml");
        MailContainExtractor mt=new MailContainExtractor();
        String actual =mt.getBodyContantOfEmail(maildata);
        System.out.println(actual);
        assertEquals(actual.length(),1446);


    }

}
