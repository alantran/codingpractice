/*
* Suman Shakya
* 12-29-2014

* Given a number, reverse its digits and add it to the original. If the sum is not a palindrome, repeat this procedure.
    195 (initial number) + 591 (reverse of initial number) = 786
    786 + 687 = 1473
    1473 + 3741 = 5214
    5214 + 4125 = 9339 (palindrome)

* For each line of input, generate a line of output which is the number of iterations (additions) to compute the palindrome and the resulting palindrome.
    4 9339
*/

import java.io.*;

public class Main{
    public static void main(String[] args){
        String filename = args[0];
        
        try(FileInputStream fis = new FileInputStream(filename);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis))){
                
                String line;
                while((line = br.readLine()) != null){
                    line.trim();
                    processLine(line);
                }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public static void processLine(String line){
        if("".equals(line)) return;
        long num = Integer.parseInt(line);
        int count = 0;
        while(!isPalindrome(num)){
            num += reverse(num);
            count++;
        }
        System.out.println(count + " " + num);
    }
    
    public static boolean isPalindrome(long num){
        return isPalindrome(numberToArray(num));
    }
    
    private static boolean isPalindrome(int[] array){
        int left = 0;
        int right = array.length - 1;
        while(left < right){
            if(array[left++] != array[right--]){
                return false;
            }
        }
        return true;
    }
    
    public static long reverse(long num){
        int len = (int) Math.log10(num) + 1; // number of digits in given number
        int[] array = new int[len];
        int i = 0;
        while(num > 0 && i < len){
            array[i++] = (int) num % 10; // split the digits of number and stored in an array in reverse fashion
            num /= 10;
        }
        return arrayToNumber(array);
    }
    
    // given a number, converts it to an array of digits that constitutes the number
    private static int[] numberToArray(long num){
        int len = (int) Math.log10(num) + 1;
        int[] array = new int[len];
        int i = len - 1;
        while(num > 0 && i >= 0){
            array[i--] = (int) num % 10;
            num /= 10;
        }
        return array;
    }
    
    // given an array of digits constituting a number, computes that number
    private static long arrayToNumber(int[] array){
        long num = 0;
        for(int i = 0; i < array.length; i++){
            num += array[array.length - 1 - i] * Math.pow(10, i);
        }
        return num;
    }
}