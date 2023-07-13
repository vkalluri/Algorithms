package com.venkat.test;

public class Addition {

    public static int addition(int n){
        return n * (n + 1) / 2;
    }

    public static int bruteAddition(int n){
        int result = 0;

        for(int i = 1; i <= n; i++){
            result += i;
        }

        return result   ;
    }

    public static void main(String[] args){
        System.out.println(addition(5));
        System.out.println(bruteAddition(5));
    }
}
