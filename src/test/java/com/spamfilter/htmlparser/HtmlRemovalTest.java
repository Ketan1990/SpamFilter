package com.spamfilter.htmlparser;

import com.spamfilter.emailHeadeRemove.EmailHeaderRemove;
import com.spamfilter.opreation.FileRead;
import org.junit.Test;

/**
 * Created by Ketan on 7/22/2014.
 */
public class HtmlRemovalTest {
    @Test
    public void itShulaRemoveHtmlContent()   {
        FileRead fr=new FileRead();
        String maildata=fr.read("E:\\spamprojct\\testmails\\TRAIN_00011.eml");
        String testdata=new EmailHeaderRemove().all(maildata);
        String actual= RemoveHtml.removeAllHtml(testdata);
        System.out.println(actual);


    }
}