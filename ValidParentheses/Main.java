/*
* Suman Shakya
* 01-01-2015

* Given a string comprising just of the characters (,),{,},[,] determine if it is well-formed or not.
*/

import java.io.*;
import java.util.Stack;

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
        if("".equals(line)) return; // if line is empty, ignore
        String result = isValid(line) ? "True" : "False";
        System.out.println(result);
    }
    
    private static boolean isValid(String str){
        Stack<Character> s = new Stack<Character>();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{'){
                s.push(ch);
            }
            else{
                if(s.isEmpty())
                    return false;
                    
                if(!isCompatible(s.pop(), ch)) 
                    return false;
            }
        }
        if(!s.isEmpty()) return false;
        return true;
    }
    
    // check if opening and closing parentheses are matching
    private static boolean isCompatible(char ch1, char ch2){
        if(ch1 == '(' && ch2 == ')') return true;
        if(ch1 == '{' && ch2 == '}') return true;
        if(ch1 == '[' && ch2 == ']') return true;
        return false;
    }
}