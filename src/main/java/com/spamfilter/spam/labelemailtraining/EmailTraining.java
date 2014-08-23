package com.spamfilter.spam.labelemailtraining;
import com.spamfilter.dataaccesslayer.QueryEngine;
import com.spamfilter.dataaccesslayer.SpamDAO;
import com.spamfilter.spam.WordCounter;
import com.spamfilter.spam.WordCounts;
import com.spamfilter.utility.MailContainExtractor;

import java.util.Map;

/**
 * Created by ketan on 8/21/2014.
 */
public class EmailTraining {
    private final QueryEngine queryEngine;
    private final WordCounts wordCounts;
    private final SpamDAO spamDAO;
    private EmailType type;
    public EmailTraining(QueryEngine queryEngine ,EmailType type) {
        this.type=type;
        this.queryEngine=queryEngine;
        wordCounts =new WordCounts();
        spamDAO =new SpamDAO(queryEngine);
    }




    public void saveEmailId(String maildata){
        if(isSpam()) {
            spamDAO.insertSpamEmailID(MailContainExtractor.getSenderId(maildata));
        }else
            spamDAO.insertGeniuneEmailID(MailContainExtractor.getSenderId(maildata));
    }

    public void filterSaveMessage(String maildata) {
        for (Map.Entry<String, Integer> entry : getWordCounts(maildata).getWordCounter().entrySet()) {
            updateWordFrequency(entry.getKey(), entry.getValue());
        }
    }

    private void updateWordFrequency(String word, Integer frequency) {
        if(isSpam()) {
            spamDAO.updateSpamFrequency(word, frequency);
        }else
            spamDAO.updateGeniunFrequency(word,frequency);
    }

    private boolean isSpam() {
        return this.type== EmailType.spamMail;
    }

    private WordCounter getWordCounts(String maildata) {
        return wordCounts.counts( MailContainExtractor.getMessageContent(maildata));
    }


}
