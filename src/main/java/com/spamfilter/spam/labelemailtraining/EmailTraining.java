package com.spamfilter.spam.labelemailtraining;
import com.spamfilter.dataaccesslayer.QueryEngine;
import com.spamfilter.dataaccesslayer.SpamDAO;
import com.spamfilter.spam.WordCounts;
import com.spamfilter.utility.MailContainExtractor;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by ketan on 8/21/2014.
 */
public class EmailTraining {
    private final QueryEngine queryEngine;
    private final String mailContent;
    private final WordCounts wordCounts;
    private final SpamDAO spamDAO;
    private EmailType type;

    public EmailTraining(QueryEngine queryEngine ,String mailContent) {
        this.queryEngine=queryEngine;
        this.mailContent =mailContent;
        wordCounts =new WordCounts();
        spamDAO =new SpamDAO(queryEngine);
    }


    public void emailId(EmailType type) {
        this.type=type;
        if(this.type==EmailType.spamMail) {
            spamDAO.insertSpamEmailID(MailContainExtractor.getSenderId(mailContent));
        }
        spamDAO.insertGeniuneEmailID(MailContainExtractor.getSenderId(mailContent));
    }
}
