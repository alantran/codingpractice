/*
** @author Suman Shakya
** 01-15-2015

** The sentence 'A quick brown fox jumps over the lazy dog' contains every single letter in the alphabet. Such sentences are called pangrams.
** You are to write a program, which takes a sentence, and returns all the letters it is missing (which prevent it from being a pangram).
** You should ignore the case of the letters in sentence, and your return should be all lower case letters, in alphabetical order.
** You should also ignore all non US-ASCII characters. In case the input sentence is already a pangram, print out the string NULL.
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
        boolean[] present = new boolean[26]; //Array to hold true/false values for each of the 26 alphabets
        for(char ch:line.toCharArray()){
            //For each character in the input, set the value of corresponding index to be true
            if(ch >= 'a' && ch <= 'z')
                present[ch - 'a'] = true; 
            else if(ch >= 'A' && ch <= 'Z')
                present[ch - 'A'] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++){ //Traverse the array
            if(!present[i]) //If the value is false, alphabet correspoding to that index is not present, so add to string builder
                sb.append((char)('a' + i));
        }

        String missing = sb.toString();
        if("".equals(missing)) 
            System.out.println("NULL");
        else
            System.out.println(missing);
    }
}