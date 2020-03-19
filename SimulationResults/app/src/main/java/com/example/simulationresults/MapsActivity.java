package com.example.simulationresults;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.auth.FirebaseAuth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {
    private Marker Mali;
    private Marker SouthSudan;
    private Marker CAR;
    private Marker Burundi;
    private GoogleMap mMap;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        mAuth = FirebaseAuth.getInstance();
        Button loggingout = (Button) findViewById(R.id.LOGOUT);
        loggingout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                finish();
                startActivity(new Intent(MapsActivity.this, LoginActivity.class));
                MainActivity timer = new MainActivity();
                System.out.println( "RUNNING TIME " + timer.getRunningTime());
            }
        });
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnMarkerClickListener(this);
        // Add a marker in Sydney and move the camera
        LatLng M = new LatLng(17.737794, -1.280157);
        Mali = mMap.addMarker(new MarkerOptions().position(M).title("Mali").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        LatLng S = new LatLng(7.664594, 29.961614);
        SouthSudan = mMap.addMarker(new MarkerOptions().position(S).title("South Sudan").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        LatLng C = new LatLng(6.425652, 20.456225);
        CAR = mMap.addMarker(new MarkerOptions().position(C).title("Central African Republic").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        LatLng B = new LatLng(-3.306623, 29.979213);
        Burundi = mMap.addMarker(new MarkerOptions().position(B).title("Burundi").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(M));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(S));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(C));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(B));
        LatLng(googleMap,"LocationSudan.csv");
    }

    @Override
        public boolean onMarkerClick(final Marker marker) {
        if (marker.equals(Mali))
        {
            Intent go = new Intent(MapsActivity.this, NavMali.class);
            startActivity(go);
            finish();
        }
        if(marker.equals(SouthSudan))
        {
            Intent go = new Intent(MapsActivity.this, Navigate.class);
            startActivity(go);
            finish();
        }

        if(marker.equals(CAR))
        {
            Intent go = new Intent(MapsActivity.this, NavCAR.class);
            startActivity(go);
            finish();
        }

        if(marker.equals(Burundi))
        {
            Intent go = new Intent(MapsActivity.this, NavBurundi.class);
            startActivity(go);
            finish();
        }

        return false;
    }

    public void LatLng(GoogleMap googleMap, String file) {
        List<String[]> csvLine = new ArrayList<>();
        String[] content = null;
        try {
            InputStream is = getAssets().open(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line = "";
            while ((line = reader.readLine()) != null) {
                content = line.split(",");
                csvLine.add(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        BitmapDescriptor marker = BitmapDescriptorFactory.defaultMarker();

        mMap.setInfoWindowAdapter(new CustomInfoAdapter(MapsActivity.this));

        double mlat;
        double mlng;
        String title;
        for (int i = 0; i < csvLine.size(); i++) {
            mlat = Double.parseDouble(csvLine.get(i)[3]);
            mlng = Double.parseDouble(csvLine.get(i)[4]);
            title = "Camp: " + csvLine.get(i)[0] + "\n" + "Refugee Population " + csvLine.get(i)[7];
            mMap.addMarker(new MarkerOptions().position(new LatLng(mlat, mlng)).icon(marker).title(title));
        }
    }

    @Override
    public void onBackPressed(){

    }
}
