/*
* Suman Shakya
* Convert uppercase letters to lowercase
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
        char[] arr = line.toCharArray();
        for(int i=0; i < arr.length; i++){
            if (arr[i] >= 'A' && arr[i] <= 'Z'){
                arr[i] = (char)(arr[i] - 'A' + 'a');
            }
        }
        System.out.println(String.valueOf(arr));
    }
    
    // Alternative method
    /*private static void processLine(String line){
        String result = "";
        for(int i = 0; i < line.length(); i++){
            char ch = line.charAt(i);
            if(ch >= 'A' && ch <= 'Z'){
                result += (char)(ch - 'A' + 'a');
            }
            else{
                result += ch;
            }
        }
        System.out.println(result);
    }*/
}