/*
** @author Suman Shakya
** 01-17-2015

** Flavius Josephus was a famous Jewish historian of the first century, at the time of the destruction of the Second Temple. 
** According to legend, during the Jewish-Roman war he was trapped in a cave with a group of soldiers surrounded by Romans. 
** Preferring death to capture, the Jews decided to form a circle and, proceeding around it, to kill every j'th person remaining until no one was left. 
** Josephus found the safe spot in the circle and thus stayed alive. 

** Write a program that returns a list of n people, numbered from 0 to n-1, in the order in which they are executed.
*/

import java.io.*;
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
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    private static void processLine(String line){
        String[] input = line.split(",");
        List<Integer> nums = new ArrayList<Integer>();
        for(int i = 0; i < Integer.parseInt(input[0]); i++){
            nums.add(i);
        }
    
        List<Integer> deleted = getDeletionOrderedList(nums, Integer.parseInt(input[1]));
        print(deleted);
    }
    
    private static List<Integer> getDeletionOrderedList(List<Integer> list, int k){
        List<Integer> deleted = new ArrayList<Integer>();
        //Start at the beginning of the list
        int idx = 0;
        //Continue till nothing is left in the list
        while(!list.isEmpty()){
            idx += k - 1;
            while(idx >= list.size())
                idx = idx % list.size();
                
            deleted.add(list.get(idx));
            list.remove(idx);
        }
        return deleted;
    }
    
    private static void print(List<Integer> list){
        StringBuilder sb = new StringBuilder();
        sb.append(list.get(0));
        for(int i = 1; i < list.size(); i++){
            sb.append(" " + list.get(i));
        }
        System.out.println(sb.toString());
    }
}