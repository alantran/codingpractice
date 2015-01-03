/*
* Suman Shakya
* 01-02-2015

* You are given a sorted list of numbers with duplicates. Print out the sorted list with duplicates removed.
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
        if("".equals(line)) return; // ignore empty line
        String[] input = line.split(",");
        
        System.out.print(input[0]); // first element is unique by default
        for(int i = 1; i < input.length; i++){
            if(!input[i].equals(input[i-1])) // if current element is not equal to previous, then it is uniuqe
                System.out.print("," + input[i]);
        }
        System.out.println();
    }
}