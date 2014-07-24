package com.spamfilter.textprocessing;

import com.spamfilter.utility.StopWords;

import java.util.regex.Pattern;

/**
 * Created by Ketan on 7/17/2014.
 */
public class Discard {

    private String words[];
    private String sentence =" ";
    String[] matched;

    public String discardSpecialSymbol(String text) {
        words= text.split("\\W+");
        return makeSentence(words);
    }

    public String discardConjunctionAndArticles(String text) {
        words=new Separatore().separateBySpace(text);
        for (int i = 0; i < words.length; i++) {
            if(!isMatch(words[i]))
                sentence=sentence+words[i]+" ";
        }
        return sentence.trim();
    }


    private boolean isMatch(String word) {
       // Pattern p=Pattern.compile("Why",Pattern.CASE_INSENSITIVE);
        return word.matches(StopWords.getString("regX"));

    }
    private String makeSentence(String[] words){
        for (int i = 0; i < words.length; i++) {
            sentence =(sentence +words[i]+" ").trim();
        }
        return sentence;

    }
}
