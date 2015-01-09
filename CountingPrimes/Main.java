/*
** @author Suman Shakya
** 01-09-2015
** Given two integers N and M, count the number of prime numbers between N and M (both inclusive)
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
        String[] input = line.split(",");
        int count = 0;
         
        int N = Integer.parseInt(input[0]);
        if(isPrime(N)) count++;
        if(N % 2 == 0) 
            N = N + 1;
        else 
            N = N + 2;
            
        for(; N <= Integer.parseInt(input[1]); N = N + 2){ //even numbers greater than 2 are all composite, skip them
            if(isPrime(N))
                count++;
        }
        System.out.println(count);
    }
    
    //Checks if given number is prime or not
    private static boolean isPrime(int N){
        if(N <= 1)
            return false;
        for(int i = 2; i <= Math.sqrt(N); i++){
            if(N % i == 0)
                return false;
        }
        return true;
    }
}