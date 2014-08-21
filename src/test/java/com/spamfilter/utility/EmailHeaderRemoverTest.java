package com.spamfilter.utility;


import com.spamfilter.fileopreation.FileRead;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Ketan on 7/20/2014.
 */
public class EmailHeaderRemoverTest {

    @Test
    public void itShouldRemoveSomeHeaderTest(){
       //given
        String maildata="To: Scott A Crosby <scrosby@cs.rice.edu>\n" +
                "From: \"Craig R.Hughes\" <craig@deersoft.com>\n" +
                "In-Reply-To: <oydit2248oi.fsf@bert.cs.rice.edu>\n" +
                "Message-Id: <AF40EEDE-B65C-11D6-8F61-00039396ECF2@deersoft.com>\n" +
                "Content-Transfer-Encoding: 7bit\n" +
                "X-Mailer: Apple Mail (2.482)\n" +
                "X-Pyzor: Reported 0 times.\n" +
                "X-Spam-Status: No, hits=-5.6 required=7.0\n" +
                "\ttests=EMAIL_ATTRIBUTION,FORGED_RCVD_TRAIL,IN_REP_TO,\n" +
                "I never claimed it could learn *all* combinatorial possibilities, but it certainly can learn some." ;

        String expected="I never claimed it could learn *all* combinatorial possibilities, but it certainly can learn some.";
      //when
        String actual =(EmailHeaderFilter.removeHeader(maildata));
       //then
      //  assertEquals(expected,actual);
    }


}
