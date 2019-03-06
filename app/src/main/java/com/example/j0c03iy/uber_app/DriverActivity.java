package com.example.j0c03iy.uber_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

public class DriverActivity extends AppCompatActivity {

    private FusedLocationProviderClient mFusedLocationClient; // Object used to receive location updates
    private LocationRequest locationRequest; // Object that defines important parameters regarding location request.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver);

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        locationRequest = LocationRequest.create();
        locationRequest.setInterval(5000); // 5 second delay between each request
        locationRequest.setFastestInterval(5000); // 5 seconds fastest time in between each request
        locationRequest.setSmallestDisplacement(10); // 10 meters minimum displacement for new location request
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY); // enables GPS high accuracy location requests
    }

}
