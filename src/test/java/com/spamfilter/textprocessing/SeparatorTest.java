package com.spamfilter.textprocessing;


import javafx.scene.control.Separator;
import com.spamfilter.textprocessing.Separatore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Ketan on 7/16/2014.
 */
public class SeparatorTest {
        @Test
        public void itShouldSeparateBySpace() {
          //given
            Separatore n=new Separatore();
            String a="it ok dude";
            //when
            String[] str = n.separateBySpace(a);
            //then
            assertEquals(3,str.length);
        }

}
