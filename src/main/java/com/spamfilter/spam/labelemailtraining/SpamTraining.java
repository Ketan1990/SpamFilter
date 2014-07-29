package com.spamfilter.spam.labelemailtraining;

import com.spamfilter.dataaccesslayer.Mongo.MongoQueryEngine;
import com.spamfilter.dataaccesslayer.SpamDAO;
import com.spamfilter.spam.WordCounter;
import com.spamfilter.spam.WordCounts;
import com.spamfilter.utility.MailContainExtractor;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Ketan on 7/22/2014.
 */
public class SpamTraining {
    private String mailText;
    private SpamDAO db;
    private WordCounter wco;
    private WordCounts textProcessing;
    private Map<String, Integer> map;
    private MailContainExtractor mailContainExtractor;
    public SpamTraining(String mail) {
        this.mailText =mail;
        db=new SpamDAO(new MongoQueryEngine());
        wco=new WordCounter();
        textProcessing =new WordCounts();
        map=new HashMap<String,Integer>();
        mailContainExtractor=new MailContainExtractor();
    }

    public void addEmailId() {
        db.insertSpamEmailID(mailContainExtractor.getSenderId(mailText));
    }

    public void addContain() {
        wco= textProcessing.counts(mailContainExtractor.getBodyContantOfSpamEmail(mailText));
        map=wco.getWordCounter();
        Iterator<String> it=map.keySet().iterator();
        while (it.hasNext()) {
            String word = (String) it.next();
            Integer frequency=map.get(word);
            System.out.println(word+" "+frequency);
            db.updateSpamFrequency(word, frequency);
        }


    }
}
