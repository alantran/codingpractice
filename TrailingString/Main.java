/*
* Suman Shakya
* There are two strings: A and B. Print 1 if string B occurs at the end of string A. Otherwise, print 0.
* 12-23-2014
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
        
        if (strArray[0].length() < strArray[1].length()){ // if second string is longer than first string
            System.out.println("0");
        }
        else{
            if (strArray[1].equals(strArray[0].substring(strArray[0].length() - strArray[1].length())))
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}