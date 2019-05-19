package navdrawer.test.com.navigationdrawertest.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import navdrawer.test.com.navigationdrawertest.R;
import navdrawer.test.com.navigationdrawertest.others.GPSTracke;


/**
 * A simple {@link Fragment} subclass.
 */
public class GoogelMapsFragment extends Fragment {

    MapView mapView;
    GoogleMap map;
    GPSTracke gps;
    private double latitude;
    private double longitude;

    @SuppressLint("MissingPermission")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_mapview, container, false);

        // Gets the MapView from the XML layout and creates it
        mapView = (MapView) v.findViewById(R.id.mapview);
        mapView.onCreate(savedInstanceState);

        getlocation();

        // Gets to GoogleMap from the MapView and does initialization stuff
        map = mapView.getMap();
        map.getUiSettings().setMyLocationButtonEnabled(true);
        map.setMyLocationEnabled(true);


        // Needs to call MapsInitializer before doing any CameraUpdateFactory calls
        try {
            MapsInitializer.initialize(this.getActivity());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Updates the location and zoom of the MapView
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(latitude, longitude), 13);

        map.animateCamera(cameraUpdate);


        //WOMEN WELFARE marker's

        map.addMarker(new MarkerOptions().position(new LatLng(-41.221452, 174.882657))
                .title("WelTec (Wellington Institute of Technology).")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_map_marker))
                .snippet("Address:, 21 Kensington Ave, Petone, Wellington 5012."));

        map.addMarker(new MarkerOptions().position(new LatLng(-41.290737, 174.777110))
                .title("Weltec School of Hospitality.")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_map_marker))
                .snippet("Address:Weltec School of Hospitality."));

        map.addMarker(new MarkerOptions().position(new LatLng(-41.287862, 174.773108))
                .title("Wellington Institute of Technology (WelTec).")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_map_marker))
                .snippet("Address:Wellington CBD Campus, 11 Church St, Wellington, 6011"));

        return v;
    }

    private void getlocation() {
        gps = new GPSTracke(getActivity());
        // check if GPS enabled
        if (gps.canGetLocation()) {
            latitude = -41.221452;
            longitude = 174.882657;
            // \n is for new line
            Toast.makeText(getActivity(), "Welcome to WelTec", Toast.LENGTH_LONG).show();
        } else {
            // can't get location
            // GPS or Network is not enabled
            // Ask user to enable GPS/network in settings
            gps.showSettingsAlert();
        }
    }

    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }


}