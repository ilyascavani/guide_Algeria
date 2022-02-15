package com.guide.alger.nabilsoft.alger;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.guide.alger.nabilsoft.alger.databinding.ActivityShowmapssBinding;

public class Showmapss extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Double deux;
  String nm ;
    Double un;

   private ActivityShowmapssBinding binding;
   public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showmapss);
        ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMapAsync(this);
        Bundle b = getIntent().getExtras();
        if (b != null) {
            un = Double.valueOf(b.getDouble("un"));
            deux = Double.valueOf(b.getDouble("deux"));
             nm = b.getString("name_place");

        }
    }

    public void onMapReady(GoogleMap googleMap) {
        this.mMap = googleMap;
          LatLng sydney = new LatLng(un.doubleValue(), deux.doubleValue());
       // LatLng sydney = new LatLng(545.45, 45648);
         this.mMap.addMarker(new MarkerOptions().position(sydney).title(this.nm));
     //   this.mMap.addMarker(new MarkerOptions().position(sydney).title("marker"));

        this.mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        this.mMap.setMapType(3);
        this.mMap.animateCamera(CameraUpdateFactory.zoomTo(12.0f));
    }

}