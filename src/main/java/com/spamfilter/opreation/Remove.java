package com.spamfilter.opreation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ketan on 7/20/2014.
 */
public class Remove {
    String a;
    public String remove(String exp,String input){
       Matcher m= Pattern.compile(exp,Pattern.MULTILINE).matcher(input);
       while (m.find()){
           a= m.replaceAll("");
       }
      return a;
   }
}
