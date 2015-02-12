/*
** @author Suman Shakya
** 02-11-2015

** Suppose a sorted array is rotated at some pivot unknown to you beforehand. (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
** Find the minimum element. You may assume no duplicate exists in the array.
** LeetCode OJ - https://oj.leetcode.com/problems/find-minimum-in-rotated-sorted-array/
*/

public class Solution{

    public static void main(String[] args){
        int[] input = new int[args.length];
        for(int i = 0; i < args.length; i++){
            input[i] = Integer.parseInt(args[i]);
        }
        System.out.println(findMinLinear(input));
        System.out.println(findMin(input));
    }
    
    /*
    ** Finds the minimum element in a sorted array that is rotated at some pivot
    ** @param num sorted array that is rotated at some pivot
    ** @return minimum element in given array
    */
    public static int findMinLinear(int[] num){
        if(num.length == 0) return 0;
        for(int i = 0; i < num.length - 1; i++){
            if(num[i] > num[i + 1]){
                return num[i + 1];
            }
        }
        return num[0]; //If no rotation has been done, return first element
    }
    
    public static int findMin(int[] num){
        return findMin(num, 0, num.length - 1);
    }
    /*
    ** O(log n)- time solution
    */
    private static int findMin(int[] num, int l, int r){
        if(l == r) return num[l];
        
        int m = (l + r) / 2;
        if(num[m] < num[r])
            return findMin(num, l, m);
        else
            return findMin(num, m + 1, r);
    }
}