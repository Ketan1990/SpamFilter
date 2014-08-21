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
 * Created by Ketan on 7/22/2014.
 */
public class SpamTraining {
    private String mailContent;
    private SpamDAO spamDAO;
    private WordCounter wco;
    private WordCounts wordCounts;
    private Map<String, Integer> map;
    private MailContainExtractor mailContainExtractor;
    private QueryEngine queryEngine;
    public SpamTraining(QueryEngine queryEngine ,String mailContent) {
        this.queryEngine=queryEngine;
        this.mailContent =mailContent;
        wco=new WordCounter();
        wordCounts =new WordCounts();
        map=new HashMap<String,Integer>();
        mailContainExtractor=new MailContainExtractor();
        spamDAO =new SpamDAO(queryEngine);

    }

    public void addEmailId() {
        spamDAO.insertSpamEmailID(mailContainExtractor.getSenderId(mailContent));
    }

    public void addContain() {
        wco= wordCounts.counts(mailContainExtractor.getMessageContent(mailContent));
        map=wco.getWordCounter();
        Iterator<String> it=map.keySet().iterator();
        while (it.hasNext()) {
            String word =it.next();
            Integer frequency=map.get(word);
            spamDAO.updateSpamFrequency(word, frequency);
        }
    }
}
