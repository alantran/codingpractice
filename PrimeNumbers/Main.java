/*
** @author Suman Shakya
** 01-09-2015
** Print out the prime numbers less than a given number N. For bonus points your solution should run in N*(log(N)) time or better. 
** You may assume that N is always a positive integer.
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
    
    public static void processLine(String line){
        List<Integer> primes = generatePrimes(Long.parseLong(line));
        for(int i = 0; i < primes.size() - 1; i++){
            System.out.print(primes.get(i) + ",");
        }
        System.out.println(primes.get(primes.size() - 1));
    }
    
    //Generate primes numbers less than given number using 'Sieve of Eratosthenes' algorithm
    private static List<Integer> generatePrimes(long N){
        List<Integer> primes = new ArrayList<Integer>();
        boolean[] composite = new  boolean[(int) N + 1];
        
        for(int p = 2; p <= (int) Math.sqrt(N); p++){
            if(!composite[p]){
                primes.add(p); //add p to the list of prime numbers
                for(int c = p * p; c <= (int) N; c += p){
                    composite[c] = true; //if p is prime number, mark all the multiples of p as composite
                }
            }
        }
        
        for(int p = (int) Math.sqrt(N) + 1; p <= (int) N; p++){
            if(!composite[p])
                primes.add(p);
        }
        return primes;
    }
}