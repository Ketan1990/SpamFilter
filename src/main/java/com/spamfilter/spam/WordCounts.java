package com.spamfilter.spam;

import com.spamfilter.utility.StopWordsFilter;
import com.spamfilter.utility.StringUtility;

/**
 * Created by Ketan on 7/18/2014.
 */
public class WordCounts {
    private   WordCounter wc;
    public WordCounts(){
        wc=new WordCounter();
    }

    public WordCounter counts(String sentence) {

       String data= StopWordsFilter.discardConjunctionAndArticles(StringUtility.discardSpecialSymbol(sentence));
        String[]word=StringUtility.separateBySpace(data);
        wc.insertWords(word);
        return  wc ;
    }
}
