/*
* Suman Shakya
* 12-29-2014

* You are given two strings. Determine if the second string is a rotation of the first string.
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
        String[] strArray = line.split(",");
        System.out.println(isRotation(strArray[0], strArray[1]));
    }
    
    private static boolean isRotation(String str1, String str2){
        if (str1.length() != str2.length()) // if two  strings are of different length
            return false;
        String str1str1 = str1 + str1;
        return str1str1.toLowerCase().contains(str2.toLowerCase()); // checks if str2 is substring of str1str1
    }
}