/*
* Suman Shakya
* 01-02-2015

* There is a game where each player picks a number from 1 to 9, writes it on a paper and gives to a guide.
* A player wins if his number is the lowest unique. Print a winner's position or 0 in case there is no winner.
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
        
        String[] input = line.split(" ");
        int[] array = new int[input.length];
        for(int i = 0; i < input.length; i++){
            array[i] = Integer.parseInt(input[i]);
        }
        System.out.println(lowestUniqueNumber(array));
    }
    
    private static int lowestUniqueNumber(int[] array){
        for(int i = 0; i < array.length; i++){
            if(array[i] == 0) continue; // skip if element is 0 (indication of duplicate)
            boolean duplicate = false;
            for(int j = 0; j < array.length; j++){
                if (j == i) continue;
                if(array[j] == array[i]){
                    duplicate = true;
                    array[j] = 0; // mark as duplicate by replacing with 0
                }
            }
            if(duplicate) array[i] = 0;
        }
        
        int min = 10;
        int idx = -1;
        for(int i = 0; i < array.length; i++){
            if(array[i] == 0) continue;
            if(array[i] < min){
                min = array[i];
                idx = i;
            } 
        }
        return idx + 1;
    }
}