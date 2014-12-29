/*
* Suman Shakya
* 12-28-2014
* Removes specific characters from a string.
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
        String[] strArray = line.split(", ");
        for(int i = 0; i < strArray[0].length(); i++){
            char ch = strArray[0].charAt(i);
            if(!contains(strArray[1], ch)){
                System.out.print(ch);
            }
        }
        System.out.println();
    }
    
    // returns true if string 'str' contains letter 'ch'
    private static boolean contains(String str, char ch){
        for(int i = 0; i < str.length(); i++){
            if(ch == str.charAt(i))
                return true;
        }
        return false;
    }
}