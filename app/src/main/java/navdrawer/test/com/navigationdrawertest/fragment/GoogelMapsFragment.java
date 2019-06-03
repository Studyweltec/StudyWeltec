package navdrawer.test.com.navigationdrawertest.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import navdrawer.test.com.navigationdrawertest.R;
import navdrawer.test.com.navigationdrawertest.others.GPSTracke;


public class GoogelMapsFragment extends Fragment {
    private SupportMapFragment mapFragment;

    private FloatingActionButton fab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_mapview, container, false);
        if (mapFragment == null) {
            mapFragment = SupportMapFragment.newInstance();
            mapFragment.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(GoogleMap googleMap) {
                    LatLng latLng = new LatLng(-41.221452, 174.882657);
                    googleMap.addMarker(new MarkerOptions().position(latLng));
                    googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
                    googleMap.addMarker(new MarkerOptions().position(new LatLng(-41.221452, 174.882657))
                            .title("WelTec (Wellington Institute of Technology).")
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_map_marker))
                            .snippet("Address:, 21 Kensington Ave, Petone, Wellington 5012."));

                    googleMap.addMarker(new MarkerOptions().position(new LatLng(-41.290737, 174.777110))
                            .title("Weltec School of Hospitality.")
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_map_marker))
                            .snippet("Address:52 Cuba St, Te Aro, Wellington 6011."));

                    googleMap.addMarker(new MarkerOptions().position(new LatLng(-41.287862, 174.773108))
                            .title("Wellington Institute of Technology (WelTec).")
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_map_marker))
                            .snippet("Address:Wellington CBD Campus, 11 Church St, Wellington, 6011"));


                    googleMap.addMarker(new MarkerOptions().position(new LatLng(-41.217815, 174.888124))
                            .title("Te Auaha")
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_map_marker))
                            .snippet("Address:65 Dixon St, Te Aro, Wellington 6011."));


                    googleMap.addMarker(new MarkerOptions().position(new LatLng(-41.217828, 174.888050))
                            .title("WELTEC - Centre for Service Industries.")
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_map_marker))
                            .snippet("Address:Kensington Ave, Petone, Lower Hutt 5012"));
                }
            });
        }

        getChildFragmentManager().beginTransaction().replace(R.id.map, mapFragment).commit();

        return view;
    }
}