package com.spamfilter.spam.spamclassification;

import com.spamfilter.fileopreation.FileRead;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by ketan on 7/26/2014.
 */
public class SpamClassificationTest {

    @Test
    public void shouldCheckWhetherMailIsSpam() {
    SpamClassification spamClassification=new SpamClassification();
      assertTrue(spamClassification.isSpam("E:\\git\\SpamFilter\\testmails\\TRAIN_00012.eml"));
      assertFalse(spamClassification.isSpam("E:\\git\\SpamFilter\\gmailstest\\508102099.RPBLNBTE.36445.635320417278915000@GEN2.center.com.eml"));
    }
    @Test
    public void shouldCheckWhetherMailContent() {
        String path="E:\\git\\SpamFilter\\testmails\\TRAIN_00012.eml";
        String path2="E:\\git\\SpamFilter\\gmailstest\\508102099.RPBLNBTE.36445.635320417278915000@GEN2.center.com.eml";
        SpamClassification scf=new SpamClassification();
        FileRead f=new FileRead();
        String content=f.read(path2);
        String body=scf.Content(content);
        System.out.println(body);
    }
}
