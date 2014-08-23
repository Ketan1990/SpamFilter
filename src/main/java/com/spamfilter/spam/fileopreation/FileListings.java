package com.spamfilter.spam.fileopreation;

import java.io.File;
import java.util.LinkedList;

/**
 * Created by ketan on 7/24/2014.
 */
public class FileListings {
    private LinkedList<String> fileList;
    File dir;
    private File[] list;
    public FileListings() {
        fileList=new LinkedList<String>();
    }

    public LinkedList<String> listOf(String path) {
        dir = new File(path);
        list=dir.listFiles();
        for (int i = 0; i < list.length; i++) {
            if (list[i].isFile())
                fileList.add(list[i].getName());
        }
        return fileList;
    }
}
