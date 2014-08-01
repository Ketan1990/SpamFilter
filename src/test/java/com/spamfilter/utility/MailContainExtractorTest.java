package com.spamfilter.utility;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Ketan on 7/19/2014.
 */
public class MailContainExtractorTest {
    @Test
    public void shouldExtractIdFromEmail()   {
        String maildata="To: Scott A Crosby <scrosby@cs.rice.edu>\n" +
                "\" +\n" +
                "                \"From: \\\"Craig R.Hughes\\\" <craig@deersoft.com>\\n\" +\n" +
                "                \"In-Reply-To: <oydit2248oi.fsf@bert.cs.rice.edu>\\n\" +\n" +
                "                \"Message-Id: <AF40EEDE-B65C-11D6-8F61-00039396ECF2@deersoft.com>\\n\" ";
        String actual = MailContainExtractor.getSenderId(maildata);
        // System.out.println(actual);
        assertEquals("craig@deersoft.com",actual);

    }

    @Test
    public void shouldExtractMessage_idFromEmail()   {

        String maildata="To: Scott A Crosby <scrosby@cs.rice.edu>\n" +
                "\"From: \\\"Craig R.Hughes\\\" <craig@deersoft.com>\\n\" +\n" +
                "\"In-Reply-To: <oydit2248oi.fsf@bert.cs.rice.edu>\\n\" +\n" +
                "\"Message-Id: <AF40EEDE-B65C-11D6-8F61-00039396ECF2@deersoft.com>\\n\" ";
        MailContainExtractor mt=new MailContainExtractor();
        String actual =mt.getMessageID(maildata);
       // System.out.println(actual);
        assertEquals("AF40EEDE-B65C-11D6-8F61-00039396ECF2@deersoft.com",actual);

    }
    @Test
    public void shouldExtractMessaggBodyFromEmail()   {
        String maildata=  "Content-Transfer-Encoding: 7bit\n" +
                "X-Mailer: Apple Mail (2.482)\n" +
                "X-Pyzor: Reported 0 times.\n" +
                "I never claimed it could learn *all* combinatorial \n" +
                "possibilities, but it certainly can learn some.\n" ;
        String expected="I never claimed it could learn *all* combinatorial possibilities, but it certainly can learn some.";
        String actual =MailContainExtractor.getBodyContantOfSpamEmail(maildata);
        //    System.out.println(actual);
        assertEquals(expected,actual);
    }
    @Test
    public void shouldExtractMessaggBodyFromG_Email()   {

        String maildata="From:ketan jain <jain.ketan2008@gmail.com>\n" +
                "To:rockexample123@gmail.com\n" +
                "Content-Type:multipart/alternative; boundary=001a11c16daa1b59d404f532bb31\n" +
                "Bodycontent:Sat Mar 22 19:52:23 IST 2014\n" +
                "Content:\n" +
                "Kavita has invited you to join Websol Affiliates\n" +
                "if intersted you can join her Click here to";
        String expected="Kavita has invited you to join Websol Affiliates if intersted you can join her Click here to";
        String actual =(MailContainExtractor.getBodyContantOfEmail(maildata)).trim();
       // System.out.println(actual);
        assertEquals(expected,actual);

    }

}
