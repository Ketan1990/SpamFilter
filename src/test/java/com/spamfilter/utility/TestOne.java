package com.spamfilter.utility;

import org.junit.*;
import org.junit.Test;

/**
 * Created by Ketan on 7/20/2014.
 */
public class TestOne
{

    @Test
    public void testone(){
       Assert.assertEquals(Test1.getString("2"),"From:.*");
    }
}
