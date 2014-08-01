package com.spamfilter.utility;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by ketan on 7/26/2014.
 */
public class DuplicateWOrdFilterTest {
    @Test
    public void itShouldInsertWords(){
       String []words={"ketan","ketan","hitesh"};
        String expected[]={"hitesh","ketan"};
       String[] actual= DuplicateWordFilter.uniqueWords(words);

        assertArrayEquals(expected,actual);
    }


    }
