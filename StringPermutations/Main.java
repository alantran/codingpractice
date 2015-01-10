/*
** @author Suman Shakya
** 01-09-2015
** Write a program which prints all the permutations of a string in alphabetical order. We consider that digits < upper case letters < lower case letters.
** The sorting should be performed in ascending order.
*/

import java.io.*;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

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
    
    private static void processLine(String line){
        List<String> perms = getPermutations(line);
        Collections.sort(perms);
        
        System.out.print(perms.get(0));
        for(int i = 1; i < perms.size(); i++)
            System.out.print("," + perms.get(i));
        System.out.println();
    }
    
    public static List<String> getPermutations(String s){
        if(s == null) return null;
        
        List<String> permutations = new ArrayList<String>();
        if(s.length() == 0){
            permutations.add("");
            return permutations;
        }
        
        char ch = s.charAt(0);
        String sub = s.substring(1);
        List<String> subPerms = getPermutations(sub);
        for(String str: subPerms){
            for(int i = 0; i <= str.length(); i++){
                permutations.add(str.substring(0, i) + ch + str.substring(i));
            }
        }
        return permutations;
    }
}