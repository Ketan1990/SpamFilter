package com.spamfilter.utility;

/**
 * Created by Ketan on 7/20/2014.
 */
public class EmailHeaderFilter {

  public static String removeHeader(String mailData) {
            return StringUtility.matchingWordRemove("(^[^\\s].*:.+\n.+\n.+$)+", mailData).trim();

    }

   }