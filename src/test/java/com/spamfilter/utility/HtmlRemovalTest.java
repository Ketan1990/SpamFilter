package com.spamfilter.utility;


import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Ketan on 7/22/2014.
 */
public class HtmlRemovalTest {
    @Test
    public void itShulaRemoveHtmlContent()   {
        String maildata="<html><body>hi</body></html>";
        String actual= HtmlRemover.removeAllHtml(maildata);
        String expected="hi";
      //  System.out.println(actual);
        assertEquals(expected, actual);


    }
}