/*
* Suman Shakya
* Finds the first not-repeated character in a string.
* Reference - http://javarevisited.blogspot.com/2014/03/3-ways-to-find-first-non-repeated-character-String-programming-problem.html
* 12-26-2014
*/

import java.io.*;
import java.util.*;

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
        if("".equals(line)) // if line is empty, skip it
            return; 
        System.out.println(returnFirstNonRepeatedChar(line));
    }
    
    // Method 1 - uses HashMap to store the count of each letter in given string
    // HashMap doesnot maintain insertion order so iterate through string to find out first letter with count 1
    public static char returnFirstNonRepeatedChar(String str){
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(char ch : str.toCharArray()){
            map.put(ch, map.containsKey(ch) ? map.get(ch) + 1 : 1);
        }
        
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(map.get(ch) == 1){
                return ch;
            }
        }
        return ' ';
    }
    
    // Method 2 - uses LinkedHashMap (maintains insertion order) to store the count of each char in given string
    public static char returnFirstNonRepeatedCharac(String str){
        LinkedHashMap<Character, Integer> table = new LinkedHashMap<Character, Integer>();
        for(char ch : str.toCharArray()){
            table.put(ch, table.containsKey(ch) ? table.get(ch) + 1 : 1);
        }
        
        for(Character ch : table.keySet()){
            if(table.get(ch) == 1){
                return ch;
            }
        }
        return ' ';
    }
    
    // Method 3 - uses two storage to find first non-repeating character in one pass
    public static char returnFirstNonRepeatedCharacter(String str){
        HashSet<Character> set = new HashSet<Character>(); // stores letter which is repeated in given string
        List<Character> list = new ArrayList<Character>(); // stores letter which is not repeated
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(set.contains(ch)){ // letter is repeated, skip it
                continue;
            }
            if(list.contains(ch)){ // this is repeated occurence of letter, remove it from list and add to set
                list.remove((Character)ch);
                set.add(ch);
            }
            else{ // if the letter occurred first time add it to list
                list.add(ch);
            }
        }
        return list.get(0); // return first element from the list containing non-repeated letters
    }
}