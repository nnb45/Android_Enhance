package com.example.lab4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.net.NetworkInterface;

public class MainActivity extends AppCompatActivity {
    FusedLocationProviderClient mFusedLocationClient;
    Location mLastLocation;
    TextView txtLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLocate = findViewById(R.id.btnLocate);
        Button btnNetWork = findViewById(R.id.btnNetwork);
        txtLocation = findViewById(R.id.txtLcation);

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        btnLocate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getLocation();
            }
        });

        btnNetWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkNetwordStatus();
            }
        });
    }
    public void getLocation(){
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED){
            // yeu cau nguoi dung cap quyen khi chua duoc phep
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 7979);
        } else {
            // thuc hien getLocation khi da co quyen
            mFusedLocationClient.getLastLocation().addOnSuccessListener(
                    new OnSuccessListener<Location>(){
                        @Override
                        public void onSuccess(Location location) {
                            if(location != null){
                                mLastLocation = location;
                                String thongtin = "  Kinh độ: " +  mLastLocation.getLatitude() +"   Vĩ độ: " + mLastLocation.getLongitude();
                                txtLocation.setText(thongtin);

                            } else {
                                txtLocation.setText("Can't get location!");
                            }
                        }
                    });
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 7979){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                getLocation();
            } else {
                Toast.makeText(this, "Deny!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    // bai 2
    private void checkNetwordStatus(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        // use Wifi
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        boolean isWificonn = networkInfo.isConnected();
        // use Data
        networkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        boolean isMobileconn = networkInfo.isConnected();

        if (isWificonn){
            Toast.makeText(getApplicationContext(), "You're using Wifi!", Toast.LENGTH_SHORT).show();
        }
        if (isMobileconn){
            Toast.makeText(getApplicationContext(), "You're using Data!", Toast.LENGTH_SHORT).show();
        }
    }
}