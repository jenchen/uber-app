package com.example.j0c03iy.uber_app;

import android.os.Bundle;
import android.app.Activity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Marker;

public class PassengerActivity extends Activity {

    private SupportMapFragment mMapFragment; // MapView UI element

    private GoogleMap mGoogleMap; // object that represents googleMap and allows us to use Google Maps API features

    private Marker driverMarker; // Marker to display driver's location

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger);
    }

}
