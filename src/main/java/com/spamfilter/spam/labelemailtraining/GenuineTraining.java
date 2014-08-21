package com.spamfilter.spam.labelemailtraining;

import com.spamfilter.dataaccesslayer.QueryEngine;
import com.spamfilter.dataaccesslayer.SpamDAO;
import com.spamfilter.spam.WordCounter;
import com.spamfilter.spam.WordCounts;
import com.spamfilter.utility.MailContainExtractor;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by ketan on 7/24/2014.
 */
public class GenuineTraining {
    private final QueryEngine queryEngine;
    private String mail;
    private SpamDAO db;
    private WordCounter wco;
    private WordCounts wc;
    private Map<String, Integer> map;
    private MailContainExtractor mailContainExtractor;
    public GenuineTraining(QueryEngine queryEngine,String mail) {
        this.mail=mail;
        this.queryEngine=queryEngine;
        db=new SpamDAO(queryEngine);
        wco=new WordCounter();
        wc=new WordCounts();
        map=new HashMap<String,Integer>();
        mailContainExtractor=new MailContainExtractor();
    }

    public void addEmailId() {
        db.insertGeniuneEmailID(mailContainExtractor.getSenderId(mail));
    }

    public void addContain() {
        wco=wc.counts(mailContainExtractor.getMessageContent(mail));
        map=wco.getWordCounter();
        Iterator<String> it=map.keySet().iterator();
        while (it.hasNext()) {
            String word = (String) it.next();
            Integer frequency=map.get(word);
            System.out.println(word+" "+frequency);
            db.updateGeniunFrequency(word, frequency);
        }

    }
}
