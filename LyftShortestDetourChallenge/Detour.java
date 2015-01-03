/*
** @author Suman Shakya
** 01-03-2015
**
** Calculate the detour distance between two different rides. Given four latitude / longitude pairs, 
** where driver one is traveling from point A to point B and driver two is traveling from point C to point D, 
** write a function (in your language of choice) to calculate the shorter of the detour distances the drivers 
** would need to take to pick-up and drop-off the other driver.
*/

import java.util.List;
import java.util.ArrayList;

public class Detour{
    
    private static final int R = 6371; //average radius of earth in km
    private static final double KM_TO_MILES = 0.621371; // conversion factor between km and mile
    
    public static void main(String[] args){
        Point A = new Point(34.712341, 86.596296); // Huntsville
        Point B = new Point(34.580992, 86.983392); // Decatur
        Point C = new Point(34.789602, 86.969424); // Athens
        Point D = new Point(34.823444, 87.285693); // Rogersville
        
        List<Point> detour1 = new ArrayList<Point>(); // A->C->D->B
        List<Point> detour2 = new ArrayList<Point>(); // C->A->B->D
        
        detour1.add(A);
        detour1.add(C);
        detour1.add(D);
        detour1.add(B);
        
        detour2.add(C);
        detour2.add(A);
        detour2.add(B);
        detour2.add(D);
        
        double detour1Dist = totalDetourDistance(detour1);
        double detour2Dist = totalDetourDistance(detour2);
        
        if(detour1Dist < detour2Dist){
            print(detour1);
            System.out.println(String.format("%.2f", detour1Dist) + " miles");
        }
        else{
            print(detour2);
            System.out.println(String.format("%.2f", detour2Dist) + " miles");
        }
    }
    
    /*
    ** Returns the distance of a detour
    */
    public static double totalDetourDistance(List<Point> detour){
        double dist = 0.0;
        for(int i = 1; i < detour.size(); i++){
            Point p1 = detour.get(i - 1);
            Point p2 = detour.get(i);
            dist += distance(p2.getLatitude(), p2.getLongitude(), p1.getLatitude(), p1.getLongitude());
        }
        return dist;
    }
    
    /*
    ** Calculates the distance between two points given the latitude and longitude of each point using Haversine formula
    ** Haversine formula:
            a = sin²(Δφ/2) + cos φ1 ⋅ cos φ2 ⋅ sin²(Δλ/2)
            c = 2 ⋅ atan2( √a, √(1−a) )
            d = R ⋅ c
            where	φ is latitude, λ is longitude, R is earth’s radius (mean radius = 6,371km);
            note that angles need to be in radians to pass to trig functions!
            
    ** Reference: http://www.movable-type.co.uk/scripts/latlong.html
    */
    public static double distance(double lat1, double lon1, double lat2, double lon2){
        double deltaLat = Math.toRadians(lat2 - lat1);
        double deltaLon = Math.toRadians(lon2 - lon1);
        
        double a = (1 - Math.cos(deltaLat)) / 2 + Math.cos(lat1) * Math.cos(lat2) * (1 - Math.cos(deltaLon)) / 2 ;
        double c = 2 * Math.atan2(Math.sqrt(a) , Math.sqrt(1 - a));
        
        return R * c * KM_TO_MILES;
    }
    
    /*
    ** Prints the points in a detour
    */
    private static void print(List<Point> detour){
        for(Point p: detour){
            System.out.print(p + " -> ");
        }
    }
}

/*
** Class representing a point in latitude and longitude
*/
class Point{
    private double latitude;
    private double longitude;
    
    public Point(double latitude, double longitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    public double getLatitude(){
        return this.latitude;
    }
    
    public void setLatitude(double latitude){
        this.latitude = latitude;
    }
    
    public double getLongitude(){
        return this.longitude;
    }
    
    public void setLongitude(double longitude){
        this.longitude = longitude;
    }
    
    @Override
    public String toString(){
        return "( " + this.latitude + " , " + this.longitude +" )";
    }
}