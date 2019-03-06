package com.example.j0c03iy.uber_app;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.pubnub.api.PNConfiguration;
import com.pubnub.api.PubNub;

public class HomeActivity extends AppCompatActivity {
    private Button driverButton;
    private Button passengerButton;
    public static PubNub pubNub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        driverButton = findViewById(R.id.driverButton);
        passengerButton = findViewById(R.id.passengerButton);

        driverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, DriverActivity.class));
            }
        });
        passengerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, PassengerActivity.class));
            }
        });


        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.M) {
            checkPermission();
        }

        initPubnub();
    }

    public void checkPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
                ) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                    123);
        }
    }

    private void initPubnub() {
        PNConfiguration pnConfiguration = new PNConfiguration();
        pnConfiguration.setSubscribeKey(Constants.PUBNUB_SUBSCRIBE_KEY);
        pnConfiguration.setPublishKey(Constants.PUBNUB_PUBLISH_KEY);
        pnConfiguration.setSecure(true);
        pubNub = new PubNub(pnConfiguration);
    }
}
