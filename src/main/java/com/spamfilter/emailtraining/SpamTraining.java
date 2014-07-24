package com.spamfilter.emailtraining;

import com.spamfilter.dataaccesslayer.Mongo.MongoQueryEngine;
import com.spamfilter.dataaccesslayer.SpamDAO;
import com.spamfilter.datastructures.WordCounter;
import com.spamfilter.textprocessing.MailContainExtractor;
import com.spamfilter.textprocessing.TextProcessing;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Ketan on 7/22/2014.
 */
public class SpamTraining {
    private String mail;
    private SpamDAO db;
    private WordCounter wco;
    private TextProcessing wc;
    private Map<String, Integer> map;
    private MailContainExtractor mailContainExtractor;
    public SpamTraining(String mail) {
        this.mail=mail;
        db=new SpamDAO(new MongoQueryEngine());
        wco=new WordCounter();
        wc=new TextProcessing();
        map=new HashMap<String,Integer>();
        mailContainExtractor=new MailContainExtractor();
    }

    public void addEmailId() {
        db.insertSpamEmailID(mailContainExtractor.getEmailId(mail));
    }

    public void addContain() {
        wco=wc.process(mailContainExtractor.getBodyContantOfSpamEmail(mail));
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
