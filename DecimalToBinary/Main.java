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
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    private static void processLine(String line){
        int num = Integer.parseInt(line);
        System.out.println(convertToBinary(num));
    }

    // recursive function that converts decimal number to its binary representation
    private static String convertToBinary(int dec){
        if (dec == 0 || dec == 1){ // base case
            return dec + "";
        }
        return convertToBinary(dec/2) + dec % 2;
    }
}