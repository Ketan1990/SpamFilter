package com.spamfilter.htmlparser;

import org.jsoup.Jsoup;

/**
 * Created by Ketan on 7/22/2014.
 */
public class RemoveHtml {
    public static String removeAllHtml(String htmlContent) {

        return Jsoup.parse(htmlContent).text();
    }
}
