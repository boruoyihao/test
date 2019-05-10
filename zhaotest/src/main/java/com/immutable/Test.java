package com.immutable;

import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import java.util.List;

/**
 * Created by zhaolizhen on 17-5-14.
 */
public class Test {
    private static HashFunction MD5 = Hashing.md5();

    public static void main(String args[]){

        List<Integer> list=ImmutableList.of(1,2);

    }
}
