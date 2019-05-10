package com.guava.Collections;

import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;

/**
 * Created by zhaolizhen on 17-1-8.
 */
public class RangeSetTest {
    public static void main(String args[]){
        RangeSet<Integer> rangeSet= TreeRangeSet.create();
        rangeSet.add(Range.closed(1,10));
    }
}
