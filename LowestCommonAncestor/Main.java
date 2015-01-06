/*
** @author Suman Shakya
** 01-05-2015

** Hardcodes a BST to find the lowest common ancestor of two nodes
*/

import java.io.*;

public class Main{
    public static void main(String[] args){
        
        BST bst = new BST();
        int[] input = {30, 52, 8, 20, 10, 29, 3};
        for(int i:input)
            bst.insert(i);
            
        String filename = args[0];
        try(FileInputStream fis = new FileInputStream(filename);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis))){
            
                String line;
                while((line = br.readLine()) != null){
                    line.trim();
                    processLine(bst,line);
                }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public static void processLine(BST bst, String line){
        if("".equals(line)) return;
        
        String[] input = line.split(" ");
        System.out.println(bst.lowestCommonAncestor(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
    }
}