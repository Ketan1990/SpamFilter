
package com.spamfilter.spam.spamclassification;

import com.spamfilter.dataaccesslayer.QueryEngine;
import com.spamfilter.dataaccesslayer.testdouble.QueryEngineTestDouble;
import com.spamfilter.spam.labelemailtraining.EmailTraining;
import com.spamfilter.spam.labelemailtraining.EmailType;
import org.junit.Test;


import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Created by ketan on 7/26/2014.
 */

public class SpamClassificationTest {
    QueryEngine queryEngine= new QueryEngineTestDouble() ;


    @Test
    public void shouldCheckWhetherMailIsNOtSpam() {
        //given
        String mailData="From craig@deersoft.com  Fri Aug 23 11:07:09 2002\n" +
                "Return-Path: <craig@deersoft.com>\n" +
                "Delivered-To: yyyy@localhost.netnoteinc.com\n" +
                "\tfor jm@localhost (single-drop); Fri, 23 Aug 2002 11:05:15 +0100 (IST)\n" +
                "Received: from mclean.mail.mindspring.net (mclean.mail.mindspring.net\n" +
                "    [207.69.200.57]) by dogma.slashnull.org (8.11.6/8.11.6) with ESMTP id\n" +
                "    g7N5rgZ12375 for <jm@jmason.org>; Fri, 23 Aug 2002 06:53:42 +0100\n" +
                "Received: from user-105nd99.dialup.mindspring.com ([64.91.181.41]\n" +
                "    helo=belphegore.hughes-family.org) by mclean.mail.mindspring.net with\n" +
                "    esmtp (Exim 3.33 #1) id 17i7OE-00023R-00; Fri, 23 Aug 2002 01:53:46 -0400\n" +
                "Date: Thu, 22 Aug 2002 22:53:44 -0700\n" +
                "Subject: Re: results for giant mass-check (phew)\n" +
                "To: Scott A Crosby <scrosby@cs.rice.edu>\n" +
                "From: \"Craig R.Hughes\" <craig@deersoft.com>\n" +
                "In-Reply-To: <oydit2248oi.fsf@bert.cs.rice.edu>\n" +
                "Message-Id: <AF40EEDE-B65C-11D6-8F61-00039396ECF2@deersoft.com>\n" +
               "Content:I never claimed it could learn *all* combinatorial \n" +
                "possibilities, but it certainly can learn some.\n" +
                "On Thursday, August 22, 2002, at 07:21  PM, Scott A Crosby wrote:\n" +
                "> It can learn a few examples that happen to be linearily seperable,\n" +
                "> like those you gave. It cannot learn the example I gave below, which\n" ;
        //when
        EmailTraining emailTraining=new EmailTraining(queryEngine,EmailType.Geniune);
        emailTraining.filterSaveMessage(mailData);
        emailTraining.saveEmailId(mailData);
        SpamDetection spamClassification=new SpamDetection(queryEngine);
        //then
        assertFalse(spamClassification.isSpam(mailData));
    }

    @Test
    public void shouldCheckEmailIsSpam() {
        //given
        String emaildata="From craig@deersoft.com  Fri Aug 23 11:07:09 2002\n" +
                "Return-Path: <craig@deersoft.com>\n" +
                "Delivered-To: yyyy@localhost.netnoteinc.com\n" +
                "\tfor jm@localhost (single-drop); Fri, 23 Aug 2002 11:05:15 +0100 (IST)\n" +
                "Received: from mclean.mail.mindspring.net (mclean.mail.mindspring.net\n" +
                "    [207.69.200.57]) by dogma.slashnull.org (8.11.6/8.11.6) with ESMTP id\n" +
                "    g7N5rgZ12375 for <jm@jmason.org>; Fri, 23 Aug 2002 06:53:42 +0100\n" +
                "Received: from user-105nd99.dialup.mindspring.com ([64.91.181.41]\n" +
                "    helo=belphegore.hughes-family.org) by mclean.mail.mindspring.net with\n" +
                "    esmtp (Exim 3.33 #1) id 17i7OE-00023R-00; Fri, 23 Aug 2002 01:53:46 -0400\n" +
                "Date: Thu, 22 Aug 2002 22:53:44 -0700\n" +
                "Subject: Re: results for giant mass-check (phew)\n" +
                "To: Scott A Crosby <scrosby@cs.rice.edu>\n" +
                "From: \"Craig R.Hughes\" <craig@deersoft.com>\n" +
                "In-Reply-To: <oydit2248oi.fsf@bert.cs.rice.edu>\n" +
                "Message-Id: <AF40EEDE-B65C-11D6-8F61-00039396ECF2@deersoft.com>\n" +
                "I never claimed it could learn *all* combinatorial \n" +
                "possibilities, but it certainly can learn some.\n" +
                "On Thursday, August 22, 2002, at 07:21  PM, Scott A Crosby wrote:\n" +
                "> It can learn a few examples that happen to be linearily seperable,\n" +
                "> like those you gave. It cannot learn the example I gave below, which\n" ;
        //when
        EmailTraining emailTraining=new EmailTraining(queryEngine,EmailType.spamMail);
        emailTraining.filterSaveMessage(emaildata);
        emailTraining.saveEmailId(emaildata);
        SpamDetection spamClassification=new SpamDetection(queryEngine);
        //then
        assertTrue(spamClassification.isSpam(emaildata));
    }

}

