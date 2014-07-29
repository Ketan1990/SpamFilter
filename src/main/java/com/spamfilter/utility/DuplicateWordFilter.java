package com.spamfilter.utility;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by ketan on 7/26/2014.
 */
public class DuplicateWordFilter {
    public static  String[] uniqueWords(String[] s) {
        Set<String>unique=new TreeSet<String>();
        for (String s1 : s) {
        unique.add(s1);
        }
        return toArray(unique);
     }

    private static String[] toArray(Set<String> unique) {
       String[]words=new String[unique.size()];
        int i=0;
        for (String word : unique) {
            words[i]=word;
            i++;
        }
        return words;
    }
}
