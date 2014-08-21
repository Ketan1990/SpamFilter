package com.spamfilter.utility;

/**
 * Created by Ketan on 7/19/2014.
 */
public class MailContainExtractor {


    public static String getSenderId(String mailData) {
        String input=StringUtility.matchingWordFind("From:.*", mailData);
        if(input.contains("<")){
            return input.substring(input.indexOf("<")+1,input.indexOf(">"));

        }
        return  input.substring((input.indexOf("From:")+6)).trim();
    }
    public static String getMessageID(String mailData) {
        String input=StringUtility.matchingWordFind("Message-Id:.*", mailData);
        if(input.contains("<")){
            return input.substring(input.indexOf("<")+1,input.indexOf(">"));

        }
        return  input.substring((input.indexOf("Message:")+6)).trim();
    }

    public static String getMessageContent(String mailContain){

        if(mailContain.contains("Content:")){
            String content=HtmlRemover.removeAllHtml(mailContain);
            return getMessageContentOfGeniuneEmail(content);
        }else
        return getMessageContentOfSpam(mailContain);
    }
    private static  String getMessageContentOfSpam(String mailContain) {
        String message=EmailHeaderFilter.removeHeader(mailContain);
        String content=HtmlRemover.removeAllHtml(message);

        return content;
    }


    private static  String getMessageContentOfGeniuneEmail(String mailContain) {
        String subContain=mailContain.substring(mailContain.indexOf("Content:")+8,mailContain.length());
        return subContain.trim();

        //str=str.substring(str.indexOf("Content-Transfer-Encoding: 7bit")+"Content-Transfer-Encoding: 7bit".length(),str.length()-"------000000000000000000000--".length());

    }
}
