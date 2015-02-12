/*
** @author Suman Shakya
** 02-11-2015

** Given an integer n, return the number of trailing zeroes in n!.
** Note: Your solution should be in logarithmic time complexity.
** LeetCode OJ - https://oj.leetcode.com/problems/factorial-trailing-zeroes/
*/

public class Solution{

    public static void main(String[] args){
        int input = Integer.parseInt(args[0]);
        System.out.println(trailingZeroes(input));
        System.out.println(trailingZeroesRecrusive(input));
    }
    
    /*
    ** Returns the number of trailing zeroes in factorial of a number
    ** @param n positive integer
    ** @return number of trailing zeroes in n!
    */
    public static int trailingZeroes(int n){
        if(n < 0) //Negative number
            return -1;
            
        int count = 0; //Stores number of trailing zeroes
        
        while(n >= 5){
            n = n / 5;
            count += n;
        }
        
        return count;
    }
    
    /*
    ** Recursive implementation
    ** T(n) = T(n/5) + 1 ~ O(logn)
    */
    public static int trailingZeroesRecrusive(int n){
        if(n < 0) return -1;
        
        if(n < 5) 
            return 0;
        else
            return trailingZeroes(n / 5) + (n / 5);
    }
}