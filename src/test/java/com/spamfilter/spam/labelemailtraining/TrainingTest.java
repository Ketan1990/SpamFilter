package com.spamfilter.spam.labelemailtraining;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Ketan on 7/22/2014.
 */
public class TrainingTest {
    Training training=new Training();

    @Test
    public void itShouldTrainSpamDatabase() {
     training.trainSpam("E:\\spamfilter_v1.0\\spam");
        assertNotNull(training);
    }
    @Test
    public void itShouldTrainGenuineDatabase() {
        training.trainGenuine("E:\\git\\SpamFilter\\gmailstest");
        assertNotNull(training);
    }
}
