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
        String[] words = line.split(" "); //split the line using space as delimiter
        int left = 0;
        int right = words.length - 1;
        while(left <= right){
            swap(words, left++, right--);
        }
        printArray(words);
    }
    
    // swaps the ith and jth elements of an array
    public static void swap(String[] array, int i, int j){
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    // prints the content of an array as a single line
    private static void printArray(String[] array){
        for(int i=0; i < array.length; i++){
            System.out.print(array[i]);
            if(i < array.length - 1){
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}