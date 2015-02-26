/*
** @author Suman Shakya
** 02-26-2015

** Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words
** LeetCode OJ -https://oj.leetcode.com/problems/word-break/
*/

import java.util.Set;
import java.util.HashSet;

public class Solution{
    public static void main(String[] args){
        Set<String> dict = new HashSet<String>();
        dict.add("a");
        dict.add("ac");
        dict.add("d");
        dict.add("bc");
        System.out.println(wordBreak("abcd", dict));
    }
    
    /*
    ** Checks if given word can be separated into one or more dictionary words
    ** Time Complexity ~ O(n^2) ; Space Complexity ~ O(n)
    */
    public static boolean wordBreak(String s, Set<String> dict) {
        if(dict.contains(s)) //word is already in dictionary
            return true;
            
        boolean[] dp = new boolean[s.length()];
        for(int i = 0; i < s.length(); i++){
            if(dict.contains(s.substring(0, i + 1))){ //dictionary contains the substring
                dp[i] = true;
                continue;
            }
            //Check for all substrings ending at position less than i
            for(int j = 0; j < i; j++){
                //Check for substring ending at j using dp table and subtring after j ending at i using dictionary
                if(dp[j] && dict.contains(s.substring(j + 1, i + 1))){ 
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length() - 1];
    }
}