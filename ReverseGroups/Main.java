/*
** @author Suman Shakya
** 01-17-2015

** Given a list of numbers and a positive integer k, reverse the elements of the list, k items at a time.
** If the number of elements is not a multiple of k, then the remaining items in the end should be left as is.
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
         catch(IOException e){
             e.printStackTrace();
         }
    }
    
    public static void processLine(String line){
        //Parse input
        String[] input = line.split(";");
        String[] array = input[0].split(",");
        int k = Integer.parseInt(input[1]);
        //Reverse array, k items at a time
        reverse(array, k, 0);
        //Print the final array
        print(array);
    }
    
    private static void reverse(String[] array, int k, int i){
        //If length of remaining part of the array is less than k, do nothing
        if(array.length - i < k) 
            return;
        //Reverse remaining elements of the array, k at a time
        reverse(array, k, k + i);
        
        //Reverse first k elements of the array
        int l = i; int r = k + i - 1;
        while(l < r){
            swap(array, l++, r--);
        }
    }
    
    private static void swap(String[] array, int i, int j){
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    private static void print(String[] array){
        System.out.print(array[0]);
        for(int i = 1; i < array.length; i++){
            System.out.print("," + array[i]);
        }
        System.out.println();
    }
}