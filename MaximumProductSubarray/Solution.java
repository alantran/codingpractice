/*
** @author Suman Shakya
** 02-26-2015

** Find the contiguous subarray within an array (containing at least one number) which has the largest product.
** For example, given the array [2,3,-2,4],the contiguous subarray [2,3] has the largest product = 6.
** LeetCode OJ - https://oj.leetcode.com/problems/maximum-product-subarray/
*/

public class Solution{
    public static void main(String[] args){
        int[] numbers1 = {1, -2, -3, 0, 7, -8, -2};
        int[] numbers2 = {-2, 0, -1};
        int[] numbers3 = {3, -1, 4};
        
        System.out.println(maximumProductSubarray(numbers1));
        System.out.println(maximumProductSubarrayDP(numbers2));
        System.out.println(maximumProductSubarrayDPOptimized(numbers3));
    }
    
    /*
    ** Time Complexity ~ O(n) ; Space Complexity ~ O(1); Iterative
    */
    public static int maximumProductSubarray(int[] numbers){
        if(numbers.length == 1)
            return numbers[0];
            
        int maxProduct = 1;
        int minProduct = 1;
        int maxSoFar = Integer.MIN_VALUE;
        
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] == 0){ //start from next number
                if(maxSoFar < 0)
                    maxSoFar = 0;
                maxProduct = 1;
                minProduct = 1;
                continue;
            }
            else if(numbers[i] > 0){ //positive number
                maxProduct = maxProduct * numbers[i]; 
                minProduct = Math.min(minProduct * numbers[i], numbers[i]);
            }
            else{ //negative number
                int tmp = maxProduct;
                maxProduct = Math.max(minProduct * numbers[i], numbers[i]);
                minProduct = tmp * numbers[i];
            }
            
            if(maxSoFar < maxProduct)
                maxSoFar = maxProduct; //update maxSoFar
            if(maxProduct < 0)
                maxProduct = 1;
        }
        return maxSoFar;
    }
    
    /*
    ** Time Complexity ~ O(n) ; Space Complexity ~ O(n); Dynamic Programming
    **  f(k) = Largest product subarray, from index 0 up to k.
        g(k) = Smallest product subarray, from index 0 up to k.
        Then,
            f(k) = max( f(k-1) * A[k], A[k], g(k-1) * A[k] )
            g(k) = min( g(k-1) * A[k], A[k], f(k-1) * A[k] )
        There we have a dynamic programming formula. Using two arrays of size n, we could deduce the final answer as f(n-1).
    */
    public static int maximumProductSubarrayDP(int[] numbers){
        int[] maxProduct = new int[numbers.length];
        int[] minProduct = new int[numbers.length];
        
        maxProduct[0] = numbers[0];
        minProduct[0] = numbers[0];
        for(int i = 1; i < numbers.length; i++){
            maxProduct[i] = Math.max(maxProduct[i - 1] * numbers[i], Math.max(numbers[i], minProduct[i - 1] * numbers[i]));
            minProduct[i] = Math.min(minProduct[i - 1] * numbers[i], Math.min(numbers[i], maxProduct[i - 1] * numbers[i]));
        }
        return maxProduct[numbers.length - 1];
    }
    
    /*
    ** Time Complexity ~ O(n) ; Space Complexity ~ O(1); Dynamic Programming
    ** Since we only need to access its previous elements at each step, two variables are sufficient.
    */
    public static int maximumProductSubarrayDPOptimized(int[] numbers){
        int[] maxProduct = new int[2];
        int[] minProduct = new int[2];
        
        maxProduct[0] = numbers[0];
        minProduct[0] = numbers[0];
        for(int i = 1; i < numbers.length; i++){
            maxProduct[i & 1] = Math.max(maxProduct[(i - 1) & 1] * numbers[i], Math.max(numbers[i], minProduct[(i - 1) & 1] * numbers[i]));
            minProduct[i & 1] = Math.min(minProduct[(i - 1) & 1] * numbers[i], Math.min(numbers[i], maxProduct[(i - 1) & 1] * numbers[i]));
        }
        return maxProduct[(numbers.length - 1) & 1];
    }
}