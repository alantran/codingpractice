/*
* Suman Shakya
* CodeEval challenge - Sum of Digits
* 12-18-2014
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
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    private static void processLine(String line){
        int num = Integer.parseInt(line);
        int sum = sumOfDigits(num);
        System.out.println(sum);
    }
    
    public static int sumOfDigits(int num){
        if (num / 10 == 0){
            return num;
        }
        return sumOfDigits(num/10) + num % 10;
    }
}