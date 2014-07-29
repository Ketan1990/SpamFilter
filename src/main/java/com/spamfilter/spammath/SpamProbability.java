package com.spamfilter.spammath;

/**
 * Created by Ketan on 7/17/2014.
 */
public class SpamProbability {
    private static Double defaultValue=1.0;

    public static Double calculate(int spamCount, int genuineCount) {
           Double prob=  (((double)spamCount/ ((double)spamCount+(double)genuineCount)));

        return prob>=0.85?defaultValue:prob;
        }
    public static Double calculate(Double spamFrequency,Double genuineFrequency) {
        Double prob=spamFrequency/ (spamFrequency+genuineFrequency);

        return prob>=0.85?defaultValue:prob;
    }


    }

