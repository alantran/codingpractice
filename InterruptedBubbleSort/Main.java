/*
* Suman Shakya
* 12-30-2014

* Find a state of a given list of positive integer numbers after applying a given count of bubble sort iterations.
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
        String[] input = line.split(" ");
        int[] array = new int[input.length - 2];
        for(int i = 0; i < input.length - 2; i++){
            array[i] = Integer.parseInt(input[i]);
        }
        bubbleSort(array, Integer.parseInt(input[input.length - 1]));
        // print the numbers of array
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    
    // performs bubble sort on given array for given number of iterations/passes
    public static void bubbleSort(int[] array, int pass){
        for(int i = 0; i < array.length; i++){
            if(i == pass) break;
            for(int j = 0; j < array.length - 1 - i; j++){
                if(array[j] > array[j + 1]){
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}