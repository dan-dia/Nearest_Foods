package com.dandiahmadin.nearest_food.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dandiahmadin.nearest_food.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
// NIM   : 10119033
// Nama  : Dandi Ahmadin
// Kelas : IF-1
public class MapsFragment extends Fragment {

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {

            LatLng dapurFaSha = new LatLng(-6.988140, 107.606281);
            LatLng rmGucci = new LatLng(-6.983656,107.604177);
            LatLng ayamGorengBahenol = new LatLng(-6.983364,107.604336);
            LatLng mieAyamBaksoLaura = new LatLng(-6.983010,107.602821);
            LatLng kawanLamaMasakanPadang = new LatLng(-6.983212,107.607091);

            googleMap.addMarker(new MarkerOptions().position(dapurFaSha).title("Dapur FaSha"));
            googleMap.addMarker(new MarkerOptions().position(rmGucci).title("RM Gucci"));
            googleMap.addMarker(new MarkerOptions().position(ayamGorengBahenol).title("Ayam Goreng Bahenol"));
            googleMap.addMarker(new MarkerOptions().position(mieAyamBaksoLaura).title("Mie Ayam Bakso Laura"));
            googleMap.addMarker(new MarkerOptions().position(kawanLamaMasakanPadang).title("Kawan Lama Masakan Padang"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(rmGucci, 16));

        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}