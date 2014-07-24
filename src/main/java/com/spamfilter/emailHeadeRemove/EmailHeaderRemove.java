package com.spamfilter.emailHeadeRemove;

import com.spamfilter.opreation.Remove;

/**
 * Created by Ketan on 7/20/2014.
 */
public class EmailHeaderRemove {
    private final Remove remove;

    public EmailHeaderRemove(){
        remove=new Remove();
    }

    public String delivered(String maildata) {
        if(maildata.contains("Delivered-To:")){
            return remove.remove("Delivered-To:.*",maildata);
        }
        return maildata;

    }
    public String fromHeader(String maildata) {
       String data=delivered(maildata);
        if(maildata.contains("From:")){
            return remove.remove("From.*",data);
        }
        return data;

    }
    public String toHeader(String maildata) {
        String data= fromHeader(maildata);
        if(maildata.contains("To:")){
            return remove.remove("To:.*",data);
        }
        return data;

    }
    public String messageIdHeader(String maildata) {
        String data= toHeader(maildata);
        if(maildata.contains("Message-Id:")){
            return remove.remove("Message-Id:.*",data);
        }
        return data;

    }
    public String  date(String maildata) {
        String data= messageIdHeader(maildata);
        if(maildata.contains("Date:")){
            return remove.remove("Date: .*",data);
        }
        return data;

    }

    public String ReturnPath(String maildata) {
        String data=date(maildata);
        if(maildata.contains("Return-Path:")){
            return remove.remove("Return-Path:.*",data);
        }
        return data;
    }

    public String ContentType(String maildata) {
        String data=ReturnPath(maildata);
        if(maildata.contains("Content-Type:")){
            return remove.remove("Content-Type:.*",data);
        }
        return data;
    }
    public String subjectHeader(String maildata) {
        String data=ContentType(maildata);
        if(maildata.contains("Subject:")){
            return remove.remove("Subject:.*",data);
        }
        return data;
    }

    public String ccHeader(String maildata) {
        String data= maildata;
        if(maildata.contains("Cc:")){
            return remove.remove("Cc:.*",data);
        }
        return data;
    }


    public String inReplyTo(String maildata) {
       String data=ccHeader(maildata);
        if(maildata.contains("In-Reply-To:")){
            return remove.remove("In-Reply-To:.*",data);
        }
        return data;
    }

    public String MIMEVersion(String maildata) {
        String data=inReplyTo(maildata);
        if(maildata.contains("MIME-Version:")){
            return remove.remove("MIME-Version:.*",data).trim();
        }
        return data;
    }
    public String Receivedfrom(String maildata) {
       // String data=MIMEVersion(maildata);
        if(maildata.contains("Received: from")){
            return remove.remove("Received: from.*+\n.+\n.+",maildata);
        }
        return maildata;
    }
    public String ContentTransferEncoding(String maildata) {
        String data=Receivedfrom(maildata);
        if(maildata.contains("ContentTransferEncoding:")){
            return remove.remove("ContentTransferEncoding:.*\n",data).trim();
        }
        return data;
    }
    public String all(String maildata) {
        String data=inReplyTo(maildata);
            return remove.remove("(^[^\\s].*:.+\n.+\n.+$)+",data);

    }

   }