package com;

public class Factorial {

    public static long factorial(int n) {
        long ans = 1;
        while (n > 1) {
            ans = ans * n;
            n = n - 1;

        }
        return ans;

    }

    public static void main(String[] args) {
        int n = 0;
        while (n <= 13) {
            System.out.print(n + "! = ");
            System.out.println(factorial(n));
            n = n + 1;

        }

    }

}