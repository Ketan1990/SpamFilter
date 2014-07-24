package com.spamfilter.opreation;

import java.io.*;

/**
 * Created by Ketan on 7/18/2014.
 */
public class FileRead {
    private File f ;
    private String str;
    private String contain="";

    public String read(String path) {

            f = new File(path);
            BufferedReader r = getBufferedReader(f);
            return getString(r);
    }

    private BufferedReader getBufferedReader(File f)  {
        try {
            return new BufferedReader(new FileReader(f));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getString(BufferedReader r)  {
      try {
          while ((str = r.readLine()) != null)
              contain = contain +"\n"+str;
          return contain.trim();
      }catch(IOException e){
          throw new FileReadException("Check file not Reading Proprly"+f.getName());
      }
    }

    public class FileReadException extends RuntimeException {

        public FileReadException(String msg) {
            super(msg);

        }
    }
}
