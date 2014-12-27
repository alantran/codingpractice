/*
* Suman Shakya
* 12-26-2014
*/

import java.io.*;

/*
* Given a sorted array of positive integers and a number 'X', print out all pairs of numbers whose sum is equal to X.
* Print out only unique pairs and the pairs should be in ascending order.
*/
public class Main{
    
    public static void main(String[] args){
        String filename = args[0];
        
        try(FileInputStream fis = new FileInputStream(filename);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis))){
                
                String line;
                while((line = br.readLine()) != null){
                    line.trim();
                    if("".equals(line)) continue; // if line is empty, skip it
                    processLine(line);
                }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    /* Input
    * 1,2,3,4,6;5
    * 2,4,5,6,9,11,15;20
    * 1,2,3,4;50
    */
    public static void processLine(String line){
        String[] split1 = line.split(";");
        String[] split2 = split1[0].split(",");
        int[] numArray = new int[split2.length];
        for(int i = 0; i < split2.length; i++){
            numArray[i] = Integer.parseInt(split2[i]);
        }
        printNumberPairs(numArray, Integer.parseInt(split1[1]));
    }
    
    public static void printNumberPairs(int[] array, int x){
        int left = 0;
        int right = array.length - 1;
        String[] result = new String[array.length/2];
        int i = 0;
        while(left < right){
            if (array[left] + array[right] == x){
                result[i++] = array[left] + "," + array[right];
                left++; right--;
            }
            else if(array[left] + array[right] < x){
                left++;
            }
            else{
                right--;
            }
        }
        if(result[0] == null)
            System.out.println("NULL"); // if no such pair exists, print NULL
        else
            printArray(result, i-1); // print pairs of such numbers
    }
    
    /* Output
    * 1,4;2,3
    * 5,15;9,11
    * NULL
    */
    private static void printArray(String[] array, int n){
        for(int i = 0; i < n; i++){
            System.out.print(array[i] + ";");
        }
        System.out.println(array[n]);
    }
}