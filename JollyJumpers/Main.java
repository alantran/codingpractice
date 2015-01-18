/*
** @author Suman Shakya
** 01-17-2015

** A sequence of n > 0 integers is called a jolly jumper if the absolute values of the differences between successive elements 
** take on all possible values 1 through n - 1. eg. 1 4 2 3 is a jolly jumper, because the absolute differences are 3, 2, and 1, respectively.
** The definition implies that any sequence of a single integer is a jolly jumper. 

** Write a program to determine whether each of a number of sequences is a jolly jumper. 
*/

import java.io.*;

public class Main{
    
    private static final String JOLLY = "Jolly";
    private static final String NOT_JOLLY = "Not jolly";
    
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
    
    private static void processLine(String line){
        String[] input = line.split("\\s");
        long[] nums = new long[Integer.parseInt(input[0])];
        for(int i = 0; i < nums.length; i++){
            nums[i] = Long.parseLong(input[i + 1]);
        }
        
        if(checkJollyJumpers(nums))
            System.out.println(JOLLY);
        else
            System.out.println(NOT_JOLLY);
    }
    
    private static boolean checkJollyJumpers(long[] array){
        if(array.length == 1) return true;
        //Initialize boolean array to keep track of which difference from 1 to N - 1 exists
        boolean[] flag = new boolean[array.length];
        for(int i = 1; i < array.length; i++){
            int diff = Math.abs((int) array[i] - (int) array[i - 1]);
            //If any of the difference is 0 or greater than or equal to length of array, then it cannot be jolly jumper
            if(diff == 0 || diff >= array.length)
                return false;
            flag[diff] = true;
        }
        //Traverse the flag to see if all values are true, meaning all difference from 1 to N - 1 exists
        for(int i = 1; i < flag.length; i++){
            if(!flag[i])
                return false;
        }
        return true;
    }
}