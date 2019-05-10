package com.tryt;

/**
 * Created by zhaolizhen on 17-2-24.
 */
public class TryTest {
    public static void main(String args[]){
        int result=test();
        System.out.println(result);
    }

    public static int test(){
        try{
            int a=0;
            int b=3/a;
        }catch (Exception e){
            System.out.println("ERROR");
            return 2;
        }
        return 3;
    }
}
