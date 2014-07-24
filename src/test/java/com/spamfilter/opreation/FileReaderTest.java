package com.spamfilter.opreation;

import com.spamfilter.opreation.FileRead;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.FileReader;

/**
 * Created by Ketan on 7/18/2014.
 */
public class FileReaderTest {
    @Test
    public void ItShouldReadFile(){
        String path="";
        FileRead fr=new FileRead();
        String actual=  fr.read("F:\\spamprojct\\src\\testfile.txt");//must check path of file
        //   System.out.println(actual.length());
        assertEquals(42,actual.length());
    }

}
