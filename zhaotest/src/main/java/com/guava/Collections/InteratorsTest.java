package com.guava.Collections;

import com.google.common.collect.ForwardingList;
import com.google.common.collect.Iterators;

import java.util.Iterator;
import java.util.List;

/**
 * Created by zhaolizhen on 17-1-8.
 */
public class InteratorsTest{
    public  static void main(String args[]){
        Iterators.peekingIterator(new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Integer next() {
                return null;
            }
        });

    }
    class AddLogging<String> extends ForwardingList<String>{

        @Override
        protected List<String> delegate() {
            return null;
        }
    }
}
