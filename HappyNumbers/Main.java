/*
** @author Suman Shakya
** 01-17-2015

** A happy number is defined by the following process. Starting with any positive integer, replace the number by the sum of the squares of its digits,
** and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. 
** Those numbers for which this process ends in 1 are happy numbers, while those that do not end in 1 are unhappy numbers.
*/

import java.io.*;
import java.util.List;
import java.util.ArrayList;

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
    
    private static void processLine(String line){
        if(happyNumber(Integer.parseInt(line)))
            System.out.println(1);
        else
            System.out.println(0);
    }
    
    private static boolean happyNumber(int n){
        //Initialize a list to keep track of all the transformations of the given number
        List<Integer> list = new ArrayList<Integer>();
        //Continue until the number converges to 1 or enters a loop
        while(n != 1){
            n = transform(n);
            //If the list contains the number, then its a loop
            if(list.contains(n))
                return false;
            list.add(n);
        }
        return true;
    }
    
    //Returns the sum of squares of the digits of a given number
    private static int transform(int n){
        int sum = 0;
        while(n > 0){
            sum += Math.pow(n % 10, 2);
            n = n/10;
        }
        return sum;
    }
}