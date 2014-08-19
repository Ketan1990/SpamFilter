package com.spamfilter.spam.spamclassification;

import com.spamfilter.dataaccesslayer.Mongo.MongoQueryEngine;
import com.spamfilter.dataaccesslayer.SpamDAO;
import com.spamfilter.spammath.TotalSpamProbability;
import com.spamfilter.utility.DuplicateWordFilter;

import java.util.Arrays;

/**
 * Created by ketan on 7/27/2014.
 */
public class FinalProbability {
    private SpamDAO spamDAO;
    private Double[] finalprobabilty;

    public FinalProbability(SpamDAO spamDAO){
        this.spamDAO=spamDAO;
    }



    public Double totalProbablity(Double[] probs) {
        Arrays.sort(probs);
        Double[] newprobs=new Double[10];
        if(probs.length<10) {
            return TotalSpamProbability.calulate(probs);
        }else{
            return calculationAbove10Element(probs, newprobs);
        }
    }

    private Double calculationAbove10Element(Double[] probs, Double[] newprobs) {
        for (int i = 0; i <10 ; i++)
            newprobs[i]=probs[i];
        return  TotalSpamProbability.calulate(newprobs);
    }
}
