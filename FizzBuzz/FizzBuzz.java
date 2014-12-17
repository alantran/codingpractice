import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FizzBuzz{
    public static void main(String[] args){
        String file = "input.txt";
        try(FileInputStream fis = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis))){
                String line = null;
                while((line = br.readLine()) != null){
                    line.trim();
                    processLine(line);
                }
            }
        catch(FileNotFoundException ex){
            ex.printStackTrace();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
    private static void processLine(String line){
        String[] data = line.split(" ");
        if (data.length < 3){
            System.out.println("Not enough inputs");
            return;
        }
        
        int div1 = Integer.parseInt(data[0]);
        int div2 = Integer.parseInt(data[1]);
        int range = Integer.parseInt(data[2]);
        
        String result = "";
        for(int i=1; i <= range; i++){
            if(i % div1 == 0 && i % div2 == 0){
                result += "FB";
            }
            else if(i % div1 == 0){
                result += "F";
            }
            else if(i % div2 == 0){
                result += "B";
            }
            else{
                result += i;
            }
            
            if(i < range){
                result += " ";
            }
        }
        System.out.println(result);
    }
}