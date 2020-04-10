package com.example.maps;

import android.graphics.Color;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;

public class MapController implements OnMapReadyCallback {

    private GoogleMap mMap;
    private MapActivity view;
    private Marker me;
    private Polygon icesiPolygon;

    public MapController(MapActivity view){
        this.view=view;

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) view.getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng icesi = new LatLng(3.341,-76.530);
        me = mMap.addMarker(new MarkerOptions().position(icesi).title("Universidad Icesi").snippet("Lat: 3.341 Lng:-76.530"));
        icesiPolygon = mMap.addPolygon(new PolygonOptions()
                .add(new LatLng(3.343095,-76.530961))
                .add(new LatLng(3.343395,-76.527251))
                .add(new LatLng(3.338661,-76.527133))
                .add(new LatLng(3.338522,-76.531369))
                .fillColor(Color.argb(50,255,0,0)));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(icesi,18));
    }
}
