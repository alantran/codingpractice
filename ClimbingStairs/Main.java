
import java.io.*;
import java.math.BigInteger;

public class Main{
    
    public static void main(String[] args){
        String filename = args[0];
        
        try(FileInputStream fis = new FileInputStream(filename);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis))){
                
                String line;
                while((line = br.readLine()) != null){
                    line.trim();
                    if("".equals(line)) continue;
                    processLine(line);
                }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public static void processLine(String line){
        
        System.out.println(numberOfWaysDP(Integer.parseInt(line)));
    }
    
    public static int numberOfWays(int numStairs){
        if(numStairs <= 2 ) return numStairs;
        return numberOfWays(numStairs - 1) + numberOfWays(numStairs - 2);
    }
    
    public static BigInteger numberOfWaysDP(int numStairs){
        BigInteger[] num = new BigInteger[numStairs+1];
        for(int i = 0; i <= numStairs; i++){
            if(i <= 2){
                num[i] = BigInteger.valueOf(i);
            }
            else{
                num[i] = num[i-1].add(num[i-2]);
            }
        }
        return num[numStairs];
    }
}