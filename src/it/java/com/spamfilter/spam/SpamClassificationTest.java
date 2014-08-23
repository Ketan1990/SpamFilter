package com.spamfilter.spam;

import com.spamfilter.dataaccesslayer.Mongo.MongoConfig;
import com.spamfilter.dataaccesslayer.Mongo.MongoQueryEngine;
import com.spamfilter.spam.fileopreation.FileRead;
import com.spamfilter.spam.labelemailtraining.EmailType;
import com.spamfilter.spam.labelemailtraining.SpamFilterTraining;
import com.spamfilter.spam.spamclassification.SpamClassification;

import com.spamfilter.spam.spamclassification.SpamDetection;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by ketan on 8/23/2014.
 */
public class SpamClassificationTest {
    private SpamFilterTraining spamFilterTraining;

    @Test
    public void shouldClassifyWheterMailIsSpam(){
        //given
        spamFilterTraining=new SpamFilterTraining(EmailType.Geniune);
        spamFilterTraining.doSpamTraining("E:\\git\\SpamFilter\\testmails\\gmailstest");
        spamFilterTraining=new SpamFilterTraining(EmailType.spamMail);
        spamFilterTraining.doSpamTraining("E:\\git\\SpamFilter\\testmails\\spam");
        //when
        SpamClassification spamClassification=new SpamClassification();
        //then


        assertTrue(spamClassification.isSpamClassified("E:\\git\\SpamFilter\\testmails\\spam\\TRAIN_00007.eml"));
    }
    @Test
    public void shouldClassifyWheterMailIsNOtSpamO(){
        //given
        spamFilterTraining=new SpamFilterTraining(EmailType.Geniune);
        spamFilterTraining.doSpamTraining("E:\\git\\SpamFilter\\testmails\\gmailstest");
        spamFilterTraining=new SpamFilterTraining(EmailType.spamMail);
        spamFilterTraining.doSpamTraining("E:\\git\\SpamFilter\\testmails\\spam");
        //when
        SpamClassification spamClassification=new SpamClassification();
        //then


        assertFalse(spamClassification.isSpamClassified("E:\\git\\SpamFilter\\testmails\\gmailstest\\508102099.RPBLNBTE.36445.635320417278915000@GEN2.center.com.eml"));
    }
    @After
    public void tearDown(){
        MongoConfig.deleteDB();
    }

}
