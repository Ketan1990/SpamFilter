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
    private String maildata;

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

    public  String getBodyContantOfSpamEmail(String mailContain) {
        EmailHeaderRemove r=new EmailHeaderRemove();
        String contain=r.all(mailContain);
        return RemoveHtml.removeAllHtml(contain);

    }


    public String getBodyContantOfEmail(String mail) {
        maildata= RemoveHtml.removeAllHtml(mail);
        String subcontain=maildata.substring(maildata.indexOf("Content:")+8,maildata.length());
        return subcontain;

        //str=str.substring(str.indexOf("Content-Transfer-Encoding: 7bit")+"Content-Transfer-Encoding: 7bit".length(),str.length()-"------000000000000000000000--".length());

    }
}
