package com.spamfilter.emailtraining;

import com.spamfilter.opreation.FileListing;
import com.spamfilter.opreation.FileRead;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by ketan on 7/24/2014.
 */
public class Training {
    private   SpamTraining sTraining;
    private   GenuineTraining gTraining;
    private  FileListing mails;
    private  LinkedList<String> list;
    private  Iterator< String> itr;
    public Training() {
        mails=new FileListing();
    }
    public void trainSpam(String path)  {
        list=mails.listOf(path);

        itr=list.iterator();

        while(itr.hasNext())
        {
            sTraining=new SpamTraining((new FileRead().read(path + "/" + itr.next())));
            sTraining.addEmailId();
            sTraining.addContain();
        }

    }

    public void trainGenuine(String path) {
        list=mails.listOf(path);

        itr=list.iterator();

        while(itr.hasNext())
        {
            gTraining=new GenuineTraining((new FileRead().read(path + "/" + itr.next())));
            gTraining.addEmailId();
            gTraining.addContain();
        }
    }
}
