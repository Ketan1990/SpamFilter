package com.spamfilter.spam.spammath;

/**
 * Created by ketan on 7/26/2014.
 */
public class TotalSpamProbability {


    public static Double calulate(Double[] prob) {
        Double probability=1.0;
        for (int i = 0; i < prob.length; i++) {
            probability=probability*prob[i];
        }
        String d=probability.toString();
       return  Double.parseDouble(d.substring(0,d.indexOf(".")+2));
    }


}
