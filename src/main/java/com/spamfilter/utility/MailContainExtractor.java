package com.spamfilter.utility;

/**
 * Created by Ketan on 7/19/2014.
 */
public class MailContainExtractor {

    public   MailContainExtractor(){

    }
    public static String getSenderId(String mailData) {
        String input=StringUtility.matchingWordFind("From:.*", mailData);
        if(input.contains("<")){
            return input.substring(input.indexOf("<")+1,input.indexOf(">"));

        }
        return  input.substring((input.indexOf("From:")+6)).trim();
    }
    public String getMessageID(String mailData) {
        String input=StringUtility.matchingWordFind("Message-Id:.*", mailData);
        if(input.contains("<")){
            return input.substring(input.indexOf("<")+1,input.indexOf(">"));

        }
        return  input.substring((input.indexOf("Message:")+6)).trim();
    }

    public static  String getBodyContantOfSpamEmail(String mailContain) {
        String contain= EmailHeaderFilter.removeHeader(mailContain);
        return HtmlRemover.removeAllHtml(contain);

    }


    public static  String getBodyContantOfEmail(String mail) {
        String  maildata= HtmlRemover.removeAllHtml(mail);
        String subcontain=maildata.substring(maildata.indexOf("Content:")+8,maildata.length());
        return subcontain;

        //str=str.substring(str.indexOf("Content-Transfer-Encoding: 7bit")+"Content-Transfer-Encoding: 7bit".length(),str.length()-"------000000000000000000000--".length());

    }
}
