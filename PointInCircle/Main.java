/*
** @author Suman Shakya
** 01-07-2015

** Having coordinates of the center of a circle, it's radius and coordinates of a point you need to define 
** whether this point is located inside of this circle.
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
        String[] input = line.split(";");
        String center = input[0].split(": ")[1];
        String radius = input[1].split(": ")[1];
        String point = input[2].split(": ")[1];
        
        Circle c = new Circle();
        c.center = toPoint(center);
        c.radius = Double.parseDouble(radius);
        
        Point p = toPoint(point);
        System.out.println(isInsideCircle(c, p));
    }
    
    //parses given string to a point object
    private static Point toPoint(String s){
        s = s.substring(1, s.length() - 1);
        String[] p = s.split(",");
        return new Point(Double.parseDouble(p[0]), Double.parseDouble(p[1]));
    }
    
    //checks if given point is inside the cirlce
    private static boolean isInsideCircle(Circle c, Point p){
        return (c.radius >= Math.sqrt(Math.pow(p.x - c.center.x, 2.0) + Math.pow(p.y - c.center.y, 2.0)));
    }
    
    private static class Point{
        private double x;
        private double y;
        
        public Point(double x, double y){
            this.x = x;
            this.y = y;
        }
    }
    
    private static class Circle{
        private Point center;
        private double radius;
    }
}