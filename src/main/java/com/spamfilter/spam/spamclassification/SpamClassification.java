package com.spamfilter.spam.spamclassification;

import com.spamfilter.dataaccesslayer.Mongo.MongoQueryEngine;
import com.spamfilter.dataaccesslayer.SpamDAO;
import com.spamfilter.fileopreation.FileRead;
import com.spamfilter.utility.MailContainExtractor;
import com.spamfilter.utility.StopWordsFilter;
import com.spamfilter.utility.StringUtility;

/* Created by ketan on 7/26/2014.
* need some changes*/


public class SpamClassification {

    private String mailContent;
    private FileRead fRead;
    private FinalProbability finalProbability;
    private String emailID;
    private SpamDAO spamDAO;
    private String bodyContent;
    private double totalProbablity;

    public SpamClassification(){
        fRead=new FileRead();
        finalProbability =new FinalProbability(new SpamDAO(new MongoQueryEngine()));
        spamDAO=new SpamDAO(new MongoQueryEngine());
    }
    public  boolean isSpam( String mailFile) {
        emailID=MailContainExtractor.getSenderId(fRead.read(mailFile));
        String content = getBodyContent(mailFile);
        getprobability(content);
       Double spamprob= senderVerification();
        System.out.println(spamprob);
        return spamprob >=0.5;

    }

    private void getprobability(String content) {
        String[]spamWords= StringUtility.separateBySpace(content);
        Double[]values=spamDAO.getAllProbability(spamWords);
        Double Probablity = finalProbability.totalProbablity(values);
        String d=Probablity.toString();
        totalProbablity=Double.parseDouble(d.substring(0,d.indexOf(".")+2));

    }

    private String getBodyContent(String mailFile) {
        mailContent=fRead.read(mailFile);
        bodyContent=Content(mailContent);
        return StopWordsFilter.discardConjunctionAndArticles(StringUtility.discardSpecialSymbol(bodyContent));
    }

    public String Content(String mailContent) {
        if(mailContent.contains("Content:")){
          return  MailContainExtractor.getBodyContantOfEmail(mailContent);
        }else
        return MailContainExtractor.getBodyContantOfSpamEmail(mailContent);
    }

    private Double senderVerification() {
        if(spamDAO.isPresentGenuineId(emailID)) {
            return totalProbablity - 0.2;
        }else if(spamDAO.isPresentSpamId(emailID)) {
            return totalProbablity + 0.2;
        }
        return totalProbablity;


    }


}
