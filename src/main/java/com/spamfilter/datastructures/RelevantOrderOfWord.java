package com.spamfilter.datastructures;

import com.sun.javafx.collections.MappingChange;
import com.sun.org.apache.regexp.internal.RE;

import java.util.*;

/**
 * Created by Ketan on 7/17/2014.
 */
public class RelevantOrderOfWord {
   private Map<String, Double> sortedMap,unSortedMap;
    private LinkedList list;

    public  RelevantOrderOfWord(){
        sortedMap=new HashMap<String, Double>();
        unSortedMap=new HashMap<String,Double>();
    }

    public void insert(String key, double vale) {
        unSortedMap.put(key,vale);
    }

    public void insertOnly10(String key, double vale) {
       if(unSortedMap.size()!=10)
        unSortedMap.put(key,vale);
    }
    public Map<String, Double> sortedByValue( ){

        return sortedByValue(unSortedMap);
    }
/*private function below
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
* */
    public Map<String, Double> sortedByValue(Map<String, Double> unSorted) {
       //  list=new LinkedList(normal.entrySet());

        sorting(unSorted);
        for(Iterator it=list.iterator();it.hasNext();){
            Map.Entry entry=(Map.Entry)it.next();
            sortedMap.put((String)entry.getKey(),(Double)entry.getValue());
        }
        return sortedMap;
    }

    private void sorting(Map<String, Double> normal) {

        Collections.sort(new LinkedList(normal.entrySet()), new CompareMapWithValue());
    }
}
