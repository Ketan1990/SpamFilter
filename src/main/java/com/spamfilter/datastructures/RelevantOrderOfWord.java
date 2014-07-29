package com.spamfilter.datastructures;

import com.sun.javafx.collections.MappingChange;
import com.sun.org.apache.regexp.internal.RE;

import java.util.*;

/**
 * Created by Ketan on 7/17/2014.
 */
public class RelevantOrderOfWord {
   private Map<String, Double>unSortedMap;
    private LinkedList list;

    public  RelevantOrderOfWord(){
        unSortedMap=new HashMap<String,Double>();
    }

    public void insert(String key, double vale) {
        unSortedMap.put(key,vale);
    }


    public Map<String, Double> sortedByValue(){

        return sortedByValue(unSortedMap);
    }

    public Map<String, Double> sortedByValue(Map<String, Double> unSorted) {
        list=new LinkedList(unSorted.entrySet());
        Collections.sort(list, new CompareMapWithValue());
        Map<String,Double> sortedMap=new HashMap<String, Double>();
        for(Iterator it=list.iterator();it.hasNext();){
            Map.Entry entry=(Map.Entry)it.next();
            sortedMap.put((String)entry.getKey(),(Double)entry.getValue());
        }
        return sortedMap;
    }

    private void sorting(Map<String, Double> normal) {
        list=new LinkedList(normal.entrySet());
        Collections.sort(list, new CompareMapWithValue());
    }
}
