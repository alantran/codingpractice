/*
** @author Suman Shakya
** 01-08-2015

** Imagine we have an immutable array of size N which we know to be filled with integers ranging from 0 to N-2, inclusive. 
** Suppose we know that the array contains exactly one duplicated entry and that duplicate appears exactly twice. Find the duplicated entry.
** (For bonus points, ensure your solution has constant space and time proportional to N)
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
        int actualSum = 0;
        int factor = 1;
        int count = 0; //keep track of number of ','s
        for(int i = line.length() - 1; i >= 0; i--){
            char ch = line.charAt(i);
            if(ch == ';') break;
            if(ch == ','){
                factor = 1;
                count++;
                continue;
            }
            
            actualSum += (ch - '0') * factor; //find the sum of all the numbers in the list
            factor *= 10;
        }
        int n = count + 1;
        int expectedSum = (n - 2) * (n - 1) / 2; //0 + 1 + 2 + ...... + (n - 2) - sum without duplicate entry
        int duplicate = (actualSum - expectedSum);
        System.out.println(duplicate);
    }
}