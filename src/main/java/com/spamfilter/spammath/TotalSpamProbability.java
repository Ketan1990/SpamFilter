package com.spamfilter.spammath;

/**
 * Created by ketan on 7/26/2014.
 */
public class TotalSpamProbability {


    public static Double calulate(Double[] prob) {
        double probability=1.0;
        for (int i = 0; i < prob.length; i++) {
            probability=probability*prob[i];
        }

        return probability;
    }


}
