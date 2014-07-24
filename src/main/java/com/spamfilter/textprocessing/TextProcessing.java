package com.spamfilter.textprocessing;

import com.spamfilter.datastructures.WordCounter;

/**
 * Created by Ketan on 7/18/2014.
 */
public class TextProcessing {
    private  Separatore separate;
    private  Discard discard;
    private   WordCounter wc;

    public TextProcessing(){
        separate =new Separatore();
        discard=new Discard();
        wc=new WordCounter();

    }

    public WordCounter process(String text) {
        String sentence=discard.discardSpecialSymbol(text);
        System.out.println(sentence);
        String data=discard.discardConjunctionAndArticles(sentence);
       // System.out.println(discard.discardConjunctionAndArticles(sentence));
        String[]word=separate.separateBySpace(data);
        wc.insertWords(word);
        return  wc ;
    }
}
