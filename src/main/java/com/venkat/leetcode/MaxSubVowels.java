package com.venkat.leetcode;

public class MaxSubVowels {

    private static boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    /**
     * To find the maximum number of vowel letters in any substring of length k in a given string s,
     * we can use a sliding window approach. We'll initialize the window with the first k
     * characters and count the number of vowels in the window. Then, we'll iterate through the
     * remaining characters, adding the next character and removing the previous character from the window.
     * We'll keep track of the maximum vowel count encountered during this process.
     *
     * In the example above, the output is 2, which represents the maximum number of vowel letters
     * in any substring of length 3 in the string "leetcode". The algorithm uses a sliding window to
     * calculate the vowel count of each window and update the maximum vowel count in linear time complexity.
     *
     *
     * @param s
     * @param k
     * @return
     */
    public static int maxVowels(String s, int k){
        int temp = 0, result = 0;

        for(int i = 0; i < k; i++){
            if(isVowel(s.charAt(i))){
                temp++;
            }
        }
        result = temp;

        for(int i = k; i < s.length(); i++){
            char currentChar = s.charAt(i);
            char prevChar = s.charAt(i - k);

            if(isVowel(currentChar)){
                temp++;
            }

            if(isVowel(prevChar)){
                temp--;
            }

            result = Math.max(result, temp);
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        int k = 3;
        int maxVowelCount = maxVowels(s, k);
        System.out.println(maxVowelCount);  // Output: 2
    }
}
