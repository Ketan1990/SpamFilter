package com.spamfilter.spam.labelemailtraining;


import com.spamfilter.dataaccesslayer.Mongo.MongoQueryEngine;
import com.spamfilter.dataaccesslayer.QueryEngine;
import com.spamfilter.spam.fileopreation.FileListings;
import com.spamfilter.spam.fileopreation.FileRead;

import java.util.Iterator;

/**
 *  Created by ketan on 8/22/2014.
 */
public class SpamFilterTraining {
    FileListings mails;
    private QueryEngine queryEngine;
    private EmailTraining emailTraining;
    FileRead emailfile;

    public  SpamFilterTraining(EmailType type){
         mails =new FileListings();
        queryEngine=new MongoQueryEngine();
        emailTraining=new EmailTraining(queryEngine,type);
        emailfile=new FileRead();
    }
    public void doSpamTraining(String spamEmailFolderpath) {
        Iterator<String> itr = mails.listOf(spamEmailFolderpath).iterator();
        while(itr.hasNext())
        {
          String maildata= getmaildata(spamEmailFolderpath, itr);
            emailTraining.saveEmailId(maildata);
            emailTraining.filterSaveMessage(maildata);
        }


    }

    private String getmaildata(String spamEmailFolderpath, Iterator<String> itr) {
        return emailfile.read(spamEmailFolderpath + "/" + itr.next());
    }
}
