/*
* Suman Shakya
* 12-27-2014
*
* Write a program which implements a stack interface for integers. The interface should have ‘push’ and ‘pop’ functions.
* Your task is to ‘push’ a series of integers and then ‘pop’ and print every alternate integer.
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
        String[] values = line.split(" ");
        Stack st = new Stack(values.length);
        for(int i = 0; i < values.length; i++){
            st.push(Integer.parseInt(values[i]));
        }
        int count = 0;
        while(!st.isEmpty()){
            count++;
            if(count % 2 == 1)
                System.out.print(st.pop() + " ");
            else
                st.pop();
        }
        System.out.println();
    }
}

// Stack interface implementation
class Stack{
    private int size;
    private int top;
    private int[] array;
    
    public Stack(int size){
        this.size = size;
        top = -1;
        array = new int[this.size];
    }
    
    public boolean isEmpty(){
        return top == -1;
    }
    
    public boolean isFull(){
        return top == size - 1;
    }
    
    public void push(int item){
        if(!isFull())
            array[++top] = item;
    }
    
    public int pop(){
        if(!isEmpty())
            return array[top--];
        return -1;
    }
}