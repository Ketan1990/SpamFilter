package com.spamfilter.fileopreation;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Ketan on 7/18/2014.
 */
public class FileReadTest {
    @Test
    public void ItShouldReadFile(){
        String path="";
        FileRead fr=new FileRead();
        String actual=  fr.read("E:\\git\\SpamFilter\\src\\testfile.txt");//must check path of file
        String expected="its should Read this\n" +
                "it again dude\n" +
                "of fine";
        assertEquals(actual,expected);
    }

}
