/*
* Suman Shakya
* 12-29-2014

* Write a program which determines the Mth to the last element in a list.
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
        if("".equals(line)) return; // if line is emptry, skip.
        
        String[] input = line.split(" ");
        int len = input.length;
        int k = Integer.parseInt(input[len - 1]);
        if (k > len - 1) // if value of k is greater than the length of array, ignore
            return;
        System.out.println(input[len - 1 - k]);
    }
}