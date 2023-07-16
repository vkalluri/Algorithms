package com.venkat.leetcode;

public class ReverseWord {

    public static String reverseWrod(String s){
        String[] splitWord = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();

        for(int i = splitWord.length - 1; i >= 0; i--){
            sb.append(splitWord[i]);
            if(i > 0){
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args){
        System.out.println(reverseWrod("the sky is blue"));
        System.out.println(reverseWrod("  hello world  "));
        System.out.println(reverseWrod("a good   example"));

    }
}
