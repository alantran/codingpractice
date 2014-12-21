/*
* Suman Shakya
* Bit Positions - CodeEval Challenge
* 12-20-2014
*/

import java.io.*;

public class Main{
    public static void main(String[] args){
        String filename = args[0];
            
        try(FileInputStream fis = new FileInputStream(filename);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis))){
            
            String line;
            while( (line = br.readLine()) != null){
                line.trim();
                processLine(line);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    private static void processLine(String line){
        String[] values = line.split(",");
        if(values.length < 3){
            System.out.println("Not enough values");
            return;
        }
        checkBits(Integer.parseInt(values[0]), Integer.parseInt(values[1]), Integer.parseInt(values[2]));
    }
    
    public static void checkBits(int n, int p1, int p2){
        if (isKthBitSet(n,p1) == isKthBitSet(n, p2)){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
    }
    
    // checks if the kth bit of the number is on or off
    public static boolean isKthBitSet(int n, int k){
        int maskBit = (1 << (k - 1));
        return ((n & maskBit) == maskBit )? true : false;
    }
}