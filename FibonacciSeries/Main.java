/*
* Suman Shakya
* Fibonacci number generator
* 12-19-2014
*/

import java.io.*;

public class Main{
    public static void main(String[] args){
        String filename = args[0];
        
        try(FileInputStream fis = new FileInputStream(filename);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis))){
            
            String line = null;
            while ((line = br.readLine()) != null){
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
        System.out.println(generateFibonacciNumber(num));
    }
    
    public static int generateFibonacciNumber(int n){
        int[] arr = new int[n+1];
        for(int i =0; i <=n; i++){
            if(i == 0 || i == 1){
                arr[i] = i;
            }
            else{
                arr[i] = arr[i-1] + arr[i-2];
            }
        }
        return arr[n];
    }
}