package br.com.safety.sample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import br.com.safety.locationlistenerhelper.core.SettingsLocationTracker;

/**
 * @author josevieira
 */
public class LocationReceiver extends BroadcastReceiver {
    //public static Boolean markerCreated = false;
    private static Marker marker = null;
    @Override
    public void onReceive(Context context, Intent intent) {
        if (null != intent && intent.getAction().equals("my.action")) {
            Location locationData = (Location) intent.getParcelableExtra(SettingsLocationTracker.LOCATION_MESSAGE);
            locationData.getLatitude();
            LatLng sydney = new LatLng(locationData.getLatitude(), locationData.getLongitude());
            if(marker == null) {
                LocationShow.mMap.setBuildingsEnabled(true);
                marker = LocationShow.mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_map_navigate)));
                LocationShow.mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(locationData.getLatitude(), locationData.getLongitude()), 17.0f));
            }
            else{
                marker.setPosition(new LatLng(locationData.getLatitude(),locationData.getLongitude()));
            }
            //LocationShow.mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
            double distance=Utility.distanceBetweenLatitudePoints(44.635497458,-63.58833098,locationData.getLatitude(),locationData.getLongitude());
            Log.d("Distance from Dal:","Dal Distance:"+String.valueOf(distance));
            Log.d("Location: ", "Latitude: " + locationData.getLatitude() + "Longitude:" + locationData.getLongitude());
            //send your call to api or do any things with the of location data
        }
    }

}