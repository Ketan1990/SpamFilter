package com.spamfilter.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ketan on 7/19/2014.
 */
public class StringUtility {

    public static String  matchingWordFind(String regX,String input){
       String word = null;
        Matcher m= Pattern.compile(regX).matcher(input);
        while (m.find()){
            word= m.group();
        }
        return  word;

    }
    public static String matchingWordRemove(String exp,String input){
        String word = null;
        Matcher m= Pattern.compile(exp,Pattern.MULTILINE).matcher(input);
        while (m.find()){
            word= m.replaceAll("");
        }
        return word;

    }
    public static String[] separateBySpace(String a) {

        return a.split(" ");
    }
    public static String discardSpecialSymbol(String text) {
        String str=dicardNumbers(text);
        String[] words = str.split("\\W+");
        return makeSentence(words);
    }
    public static String dicardNumbers(String text) {

        String[] words = text.split("\\d+");
        return makeSentence(words);
    }
    private static String makeSentence(String[] words){
        String sentence=" ";
        for (int i = 0; i < words.length; i++) {
            sentence =sentence +words[i]+" ";
        }
        return sentence.trim();

    }

}
