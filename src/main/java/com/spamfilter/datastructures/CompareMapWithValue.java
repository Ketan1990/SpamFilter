package com.spamfilter.datastructures;

import java.util.Comparator;
import java.util.Map;

/**
 * Created by Ketan on 7/18/2014.
 */
public class CompareMapWithValue implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            return ((Comparable)((Map.Entry)(o2)).getValue()).
                    compareTo(((Map.Entry) (o1)).getValue());
        }
}
