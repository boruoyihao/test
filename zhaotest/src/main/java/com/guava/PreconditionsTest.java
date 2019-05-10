package com.guava;

import com.google.common.base.Preconditions;

/**
 * Created by zhaolizhen on 17-1-4.
 */
public class PreconditionsTest {

    public static void main(String args[]){
        Preconditions.checkArgument(true,"nooo");
        Preconditions.checkArgument(false,"%szhao","ddd");
    }
}
