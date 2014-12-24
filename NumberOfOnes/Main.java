/*
* Suman Shakya
* Calculate number of 1 bits in the internal representation of a given integer.
* 12-23-2014
*/

import java.io.*;

public class Main{
    public static void main(String[] args){
        String filename = args[0];
        
        try(FileInputStream fis = new FileInputStream(filename);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis))){
                
                String line = null;
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
        System.out.println(numberOfOnes(Integer.parseInt(line)));
    }
    
    // returns the number of 1 bits in the internal representation of a given integer.
    public static int numberOfOnes(int num){
        int count = 0;
        while(num > 0){
            if ((num & 1) == 1) // bitwise and operation between num and 1
                count++;
            num = num >> 1; // right shift the number by 1 position
        }
        return count;
    }
}