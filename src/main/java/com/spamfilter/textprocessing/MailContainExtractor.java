package com.spamfilter.textprocessing;

import com.spamfilter.emailHeadeRemove.EmailHeaderRemove;
import com.spamfilter.htmlparser.RemoveHtml;
import com.spamfilter.opreation.Finding;

/**
 * Created by Ketan on 7/19/2014.
 */
public class MailContainExtractor {
    private Finding finding;
    private String emailID;
    public MailContainExtractor(){
        finding=new Finding();
    }
    public String getEmailId(String mailData) {
        String input=finding.find("From:.*",mailData);
        if(input.contains("<")){
            return input.substring(input.indexOf("<")+1,input.indexOf(">"));

        }
        return  input.substring((input.indexOf("From:")+6)).trim();
    }
    public String getMessageID(String mailData) {
        String input=finding.find("Message-Id:.*",mailData);
        if(input.contains("<")){
            return input.substring(input.indexOf("<")+1,input.indexOf(">"));

        }
        return  input.substring((input.indexOf("Message:")+6)).trim();
    }

    public static String getBodyContant(String mailContain) {
        EmailHeaderRemove r=new EmailHeaderRemove();
        String contain=r.all(mailContain);
        return RemoveHtml.removeAllHtml(contain);

    }




}
