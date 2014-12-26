/*
* Suman Shakya
* Determine the largest sum of contiguous integers in a list.
* 12-25-2014
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
        String[] strArray = line.split(",");
        int[] intArray = new int[strArray.length];
        for(int i = 0; i < strArray.length; i++){
            intArray[i] = Integer.parseInt(strArray[i]);
        }
        //System.out.println(maxContiguousSumOfIntegers(intArray));
        System.out.println(maxSumOfIntegers(intArray));
    }
    
    // O(n)-time iterative solution
    public static int maxContiguousSumOfIntegers(int[] array){
        int maxSum = array[0];
        int sum = 0;
        for(int i = 0; i < array.length; i++){
            sum += array[i];
            if (sum <= 0)
                sum = array[i];
            if (sum > maxSum)
                maxSum = sum;
        }
        return maxSum;
    }
    
    // O(n)-time dynamic programming solution
    public static int maxSumOfIntegers(int[] array){
        int[] sum = new int[array.length];
        sum[0] = array[0];
        for(int i = 1; i < array.length; i++){
            if(sum[i-1] < 0)
                sum[i] = array[i];
            else
                sum[i] = sum[i - 1] + array[i];
        }
        return max(sum);
    }
    
    // returns the largest element in a given array
    public static int max(int[] array){
        int max = array[0];
        for(int i = 1; i < array.length; i++){
            if (array[i] > max)
                max = array[i];
        }
        return max;
    }
}