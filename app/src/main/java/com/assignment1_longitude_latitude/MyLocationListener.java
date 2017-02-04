package assignment1_longitude_latitude;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by Noman Ashraf on 1/26/2017.
 */

public class MyLocationListener implements LocationListener {
    Context context;
    MyLocationListener(Context _context)
    {
        context = _context;
    }

    //singleton objects
    private static MyLocationListener instance = null;
    public static MyLocationListener getLocationManager(Context context)     {
        if (instance == null) {
            instance = new MyLocationListener(context);
        }
        return instance;
    }

    @Override
    public void onLocationChanged(Location location) {
        location.getLatitude();

        location.getLongitude();

        String locationtxt = "Current location is: " + "Latitud = " + location.getLatitude() + "Longitud = " + location.getLongitude();

        Toast.makeText(context , locationtxt , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {
        Toast.makeText(context , "GPS enable!" , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProviderDisabled(String provider) {
        Toast.makeText(context , "GPS disable!" , Toast.LENGTH_SHORT).show();
    }
}
