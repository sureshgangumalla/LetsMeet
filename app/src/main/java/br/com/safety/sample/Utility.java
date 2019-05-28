package br.com.safety.sample;

/**
 * Created by viswanathms on 2018-02-10.
 * Consists of methods that can be used in different places.
 */

public class Utility {
    /**
     * Method to compute the distance between two latitude points.
     * Formula user Reference :https://andrew.hedges.name/experiments/haversine/
     * */
    public static final int RADIUS_OF_EARTH = 6373;
    public static double distanceBetweenLatitudePoints(double lat1, double long1,Double lat2,Double long2){
        double diffLon = Math.toRadians(long2-long1);
        double diffLat = Math.toRadians((lat2-lat1));
        double a = ((Math.pow(Math.sin(diffLat/2),2)) + (Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * (Math.pow(Math.sin(diffLon/2),2))));
        double c = 2* Math.atan2(Math.sqrt(a),Math.sqrt(1-a));
        return c*RADIUS_OF_EARTH;
    }
}
