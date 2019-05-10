package com.guava;

import com.google.common.base.Charsets;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;

/**
 * Created by zhaolizhen on 17-1-6.
 */
public class HashingTest {
    public static void main(String args[]){
        HashCode hc= Hashing.md5().newHasher().putBoolean(true).putString("zhao", Charsets.UTF_8).hash();
        System.out.print(hc);
    }
}
