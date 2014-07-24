package com.spamfilter.opreation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ketan on 7/19/2014.
 */
public class Finding {
    private String  a;

    public String  find(String regX,String input){
        Matcher m= Pattern.compile(regX).matcher(input);
        while (m.find()){
            a= m.group();
        }
        return  a;

    }

}
