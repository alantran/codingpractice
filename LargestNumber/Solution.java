/*
** @author Suman Shakya
** 02-13-2015

** Given a list of non negative integers, arrange them such that they form the largest number.
** For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
** LeetCode OJ - https://oj.leetcode.com/problems/largest-number/
*/

import java.util.Arrays;
import java.util.Comparator;

public class Solution{
    public static void main(String[] args){
        int[] input = {3, 30, 34, 5, 9};
        System.out.println(largestNumber(input));
    }
    
    public static String largestNumber(int[] num){
        String[] arr = new String[num.length];
        for(int i = 0; i < num.length; i++){
            arr[i] = String.valueOf(num[i]);
        }
        
        Arrays.sort(arr, new MyComparator());
        
        //Create a string from array with elements taken in reverse order
        StringBuilder sb = new StringBuilder();
        for(int i = arr.length - 1; i >= 0; i--){
            sb.append(arr[i]);
        }
        
        //Remove any leading zeroes
        int i = 0;
        while(i < arr.length && sb.charAt(i) == '0')
            i++;
        if(i == arr.length)
            return "0";
        return sb.toString().substring(i);
    }
}

class MyComparator implements Comparator<String>{
    @Override
    public int compare(String a, String b){
        String ab = a + b;
        String ba = b + a;
        return Integer.parseInt(ab) - Integer.parseInt(ba);
    }
}