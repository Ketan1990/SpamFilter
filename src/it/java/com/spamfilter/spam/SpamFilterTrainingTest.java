package com.spamfilter.spam;

import com.spamfilter.dataaccesslayer.Mongo.MongoConfig;
import com.spamfilter.dataaccesslayer.Mongo.MongoQueryEngine;
import com.spamfilter.dataaccesslayer.SpamDAO;
import com.spamfilter.spam.labelemailtraining.EmailType;
import com.spamfilter.spam.labelemailtraining.SpamFilterTraining;
import com.spamfilter.spam.spamclassification.SpamDetection;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class SpamFilterTrainingTest {
    SpamFilterTraining spamFilterTraining;
    @Test
    public void itShouldTrainSpamDatabaseWithSpamMail() {
        spamFilterTraining=new SpamFilterTraining(EmailType.spamMail);
        spamFilterTraining.doSpamTraining("E:\\git\\SpamFilter\\testmails\\spam");
        assertTrue(new SpamDAO(new MongoQueryEngine()).isPresentSpamId("craig@deersoft.com"));

    }

    @Test
    public void itShouldTrainSpamDatabaseWithGeniuneMail() {
        spamFilterTraining=new SpamFilterTraining(EmailType.Geniune);
        spamFilterTraining.doSpamTraining("E:\\git\\SpamFilter\\testmails\\gmailstest");
        assertTrue(new SpamDAO(new MongoQueryEngine()).isPresentGenuineId("sqpecials@psychiccenter.com"));
    }



    @After
    public void tearDown(){
        MongoConfig.deleteDB();
    }

}

