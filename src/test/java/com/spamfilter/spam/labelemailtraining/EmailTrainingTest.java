package com.spamfilter.spam.labelemailtraining;

import com.spamfilter.dataaccesslayer.QueryEngine;
import com.spamfilter.dataaccesslayer.SpamDAO;
import com.spamfilter.dataaccesslayer.testdouble.QueryEngineTestDouble;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmailTrainingTest {
    @Test
    public void shouldTraingSpamEmailAddress(){
        //given
        String EmailMetaData="From craig@deersoft.com  Fri Aug 23 11:07:09 2002\n" +
                "Return-Path: <craig@deersoft.com>\n" +
                "Delivered-To: yyyy@localhost.netnoteinc.com\n" +
                "Received: from mclean.mail.mindspring.net (mclean.mail.mindspring.net\n" +
                "    [207.69.200.57]) by dogma.slashnull.org (8.11.6/8.11.6) with ESMTP id\n" +
                "    g7N5rgZ12375 for <jm@jmason.org>; Fri, 23 Aug 2002 06:53:42 +0100\n" +
                "Date: Thu, 22 Aug 2002 22:53:44 -0700\n" +
                "Subject: Re: results for giant mass-check (phew)\n" +
                "Content-Type: text/plain; charset=US-ASCII; format=flowed\n" +
                "MIME-Version: 1.0 (Apple Message framework v482)\n" +
                "Cc: yyyy@example.com (Justin Mason),\n" +
                "To: Scott A Crosby <scrosby@cs.rice.edu>\n" +
                "From: \"Craig R.Hughes\" <craig@deersoft.com>\n" +
                "In-Reply-To: <oydit2248oi.fsf@bert.cs.rice.edu>\n" +
                "Message-Id: <AF40EEDE-B65C-11D6-8F61-00039396ECF2@deersoft.com>\n" +
                "I never claimed it could learn *all* combinatorial \n" +
                "possibilities, but it certainly can learn some.\n";
        QueryEngine queryEngine=new QueryEngineTestDouble();
        EmailTraining emailTraining=new EmailTraining(queryEngine,EmailMetaData);
        emailTraining.emailId(EmailType.spamMail);
        assertTrue(new SpamDAO(queryEngine).isPresentSpamId("craig@deersoft.com"));
    }
    @Test
    public void shouldTraingGeniuneEmailAddress(){
        //given
        String EmailMetaData="From:Psychiccenter.com Specials <sqpecials@psychiccenter.com>\n" +
                "To:Customer <rockexample123@gmail.com>\n" +
                "Subject:Want a bargain?\n" +
                "Reply-To:<feedback-508102099-RPBLNBTE@astrocenter.com>\n";
        QueryEngine queryEngine=new QueryEngineTestDouble();
        EmailTraining emailTraining=new EmailTraining(queryEngine,EmailMetaData);
        emailTraining.emailId(EmailType.Geniune);
        assertTrue(new SpamDAO(queryEngine).isPresentGenuineId("sqpecials@psychiccenter.com"));

    }
    @Test
    public void shouldTraingSpamEmailContent(){
        //given
        String EmailMetaData="From craig@deersoft.com  Fri Aug 23 11:07:09 2002\n" +
                "Return-Path: <craig@deersoft.com>\n" +
                "Delivered-To: yyyy@localhost.netnoteinc.com\n" +
                "Received: from mclean.mail.mindspring.net (mclean.mail.mindspring.net\n" +
                "    [207.69.200.57]) by dogma.slashnull.org (8.11.6/8.11.6) with ESMTP id\n" +
                "    g7N5rgZ12375 for <jm@jmason.org>; Fri, 23 Aug 2002 06:53:42 +0100\n" +
                "Date: Thu, 22 Aug 2002 22:53:44 -0700\n" +
                "Subject: Re: results for giant mass-check (phew)\n" +
                "Content-Type: text/plain; charset=US-ASCII; format=flowed\n" +
                "MIME-Version: 1.0 (Apple Message framework v482)\n" +
                "Cc: yyyy@example.com (Justin Mason),\n" +
                "To: Scott A Crosby <scrosby@cs.rice.edu>\n" +
                "From: \"Craig R.Hughes\" <craig@deersoft.com>\n" +
                "In-Reply-To: <oydit2248oi.fsf@bert.cs.rice.edu>\n" +
                "Message-Id: <AF40EEDE-B65C-11D6-8F61-00039396ECF2@deersoft.com>\n" +
                "I never claimed it could learn *all* combinatorial";
        QueryEngine queryEngine=new QueryEngineTestDouble();
        EmailTraining emailTraining=new EmailTraining(queryEngine,EmailMetaData);
        emailTraining.messageBody(EmailType.spamMail);
  //      assertEquals();
    }


}