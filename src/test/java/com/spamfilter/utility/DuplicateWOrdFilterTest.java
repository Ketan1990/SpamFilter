package com.spamfilter.utility;

import com.spamfilter.utility.DuplicateWordFilter;
import org.junit.Test;

/**
 * Created by ketan on 7/26/2014.
 */
public class DuplicateWOrdFilterTest {
    @Test
    public void itShouldInsertWords(){
       String []words={"ketan","ketan","hitesh"};
       String[] s= DuplicateWordFilter.uniqueWords(words);
        for (String s1 : s) {
            System.out.println(s1);
        }
    }
    @Test
    public void itShouldInsert1Words() {
        String[] words = {"rtudm","w","w","er"};
        String[] s = DuplicateWordFilter.uniqueWords(words);
        for (String s1 : s) {
            System.out.println(s1);
        }
    }

    }
