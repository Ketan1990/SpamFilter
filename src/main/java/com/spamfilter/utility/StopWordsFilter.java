package com.spamfilter.utility;

/**
 * Created by Ketan on 7/17/2014.
 */
public class StopWordsFilter {

    public static String discardConjunctionAndArticles(String sentence) {
        String[] words = StringUtility.separateBySpace(sentence);
        String text="";
        for (int i = 0; i < words.length; i++) {
            if(!isMatch(words[i]))
                text=text+words[i]+" ";
        }
        return text.trim();
    }


    private static boolean isMatch(String word) {
       // Pattern p=Pattern.compile("Why",Pattern.CASE_INSENSITIVE);
        return word.matches(StopWords.getString("regX"));

    }
}
