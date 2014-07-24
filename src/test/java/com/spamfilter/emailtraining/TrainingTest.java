package com.spamfilter.emailtraining;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Ketan on 7/22/2014.
 */
public class TrainingTest {
    @Test
    public void itShouldTrainSpamDatabase() {
     Training training=new Training();
     training.trainSpam("E:\\git\\SpamFilter\\testmails");
        assertNotNull(training);
    }
    @Test
    public void itShouldTrainGDatabase() {
        Training training=new Training();
        training.trainGenuine("E:\\git\\SpamFilter\\gmailstest");
        assertNotNull(training);
    }
}
