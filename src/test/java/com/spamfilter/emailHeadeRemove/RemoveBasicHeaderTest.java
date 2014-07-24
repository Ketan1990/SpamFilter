package com.spamfilter.emailHeadeRemove;

import com.spamfilter.opreation.FileRead;
import org.junit.Test;

/**
 * Created by Ketan on 7/20/2014.
 */
public class RemoveBasicHeaderTest {

    @Test
    public void all(){
        FileRead fr=new FileRead();
        String maildata=fr.read("F:\\spamprojct\\testmails\\TRAIN_00011.eml");
        EmailHeaderRemove mt=new EmailHeaderRemove();
        String actual =mt.all(maildata);
        System.out.println(actual);

    }


    }
