package com.spamfilter.spam.spamclassification;

import com.spamfilter.dataaccesslayer.QueryEngine;
import com.spamfilter.dataaccesslayer.SpamDAO;
import com.spamfilter.utility.MailContainExtractor;
import com.spamfilter.utility.StopWordsFilter;
import com.spamfilter.utility.StringUtility;

/* Created by ketan on 7/26/2014.
* need some changes*/



public class SpamClassification {

    public static final double spamThreshold = 0.5;
    private final QueryEngine queryEngine;
    private FinalProbability finalProbability;
    private String emailID;
    private SpamDAO spamDAO;
    private double totalProbablity;
    private String maildata;

    public SpamClassification(final QueryEngine queryEngine){
        this.queryEngine=queryEngine;
        spamDAO=new SpamDAO(queryEngine);
        finalProbability =new FinalProbability(spamDAO);
    }
    public  boolean isSpam(final String maildata) {
        this.maildata=maildata;
        emailID=MailContainExtractor.getSenderId(maildata);
        String messageContent = getFilteredBodyContent(maildata);
        Double spamprob=getTotalprobability(messageContent);
        return spamprob >= spamThreshold;
    }

    private Double getTotalprobability(final String messageContent) {
        String[]spamWords= StringUtility.separateBySpace(messageContent);
        Double[]probValues=spamDAO.getAllProbability(spamWords);
        totalProbablity=finalProbability.totalProbablity(probValues);
        return probabilityAfterSenderVerification();
    }
    private Double probabilityAfterSenderVerification() {
        if(spamDAO.isPresentGenuineId(emailID)) {
            return totalProbablity - 0.2;
        }else if(spamDAO.isPresentSpamId(emailID)) {
            return totalProbablity + 0.2;
        }
        return totalProbablity;
    }

    private String getFilteredBodyContent(final String mailContent) {
        String bodyContent=getMessageBody(mailContent);
        return StopWordsFilter.discardConjunctionAndArticles(StringUtility.discardSpecialSymbol(bodyContent));
    }

    public String getMessageBody(final String mailContent) {
       return MailContainExtractor.getMessageContent(mailContent);
          }




}
