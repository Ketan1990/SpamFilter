package com.spamfilter.spam.labelemailtraining;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
public class TrainingTest {
    SpamFilterTraining training=new SpamFilterTraining();
    @Test
    public void itShouldTrainSpamDatabase() {
     training.trainSpam("E:\\spamfilter_v1.0\\mongoDB");
        assertNotNull(training);
    }
    @Test
    public void itShouldTrainGenuineDatabase() {
        training.trainGenuine("E:\\git\\SpamFilter\\testmails\\gmailstest");
        assertNotNull(training);
    }
}

