/*
package com.spamfilter.spam.labelemailtraining;

import com.spamfilter.dataaccesslayer.Mongo.MongoQueryEngine;
import com.spamfilter.dataaccesslayer.QueryEngine;
import com.spamfilter.spam.fileopreation.FileListings;
import com.spamfilter.spam.fileopreation.FileRead;

import java.util.Iterator;
import java.util.LinkedList;

*/
/**
 * Created by ketan on 7/24/2014.
 *//*

public class Training {
    private   SpamTraining sTraining;
    private   GenuineTraining gTraining;
    private FileListings mails;
    private  LinkedList<String> list;
    private  Iterator< String> itr;
    public Training() {
        mails=new FileListings();
    }
    public void trainSpam(String emailFile)  {
        list=mails.listOf(emailFile);

        itr=list.iterator();

        while(itr.hasNext())
        {
            sTraining=new SpamTraining(new MongoQueryEngine(),(new FileRead().read(emailFile + "/" + itr.next())));
            sTraining.addEmailId();
            sTraining.addContain();
        }

    }

    public void trainGenuine(String path) {
        list=mails.listOf(path);
        itr=list.iterator();
        while(itr.hasNext())
        {
            gTraining=new GenuineTraining(new MongoQueryEngine(),(new FileRead().read(path + "/" + itr.next())));
            gTraining.addEmailId();
            gTraining.addContain();
        }
    }
}
*/
