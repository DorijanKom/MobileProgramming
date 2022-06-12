package com.example.lively;

import android.app.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class MapScreen extends Fragment implements OnMapReadyCallback {

    private FusedLocationProviderClient mFusedLocationProviderClient;
    private GoogleMap mMap;
    private SupportMapFragment supportMapFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_maps, container, false);

        supportMapFragment = (SupportMapFragment) getParentFragmentManager().findFragmentById(R.id.main_map);
        supportMapFragment.getMapAsync(this);
        mFusedLocationProviderClient= LocationServices.getFusedLocationProviderClient(requireContext());


        LatLng kalesija=new LatLng(44.4417, 18.8776);
        mMap.clear();
        mMap.animateCamera(CameraUpdateFactory.newLatLng(kalesija));

        return view;
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        LatLng kalesija = new LatLng(44.4417, 18.8776);
        mMap.addMarker(new MarkerOptions().position(kalesija).title("Marker in kalesija"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(kalesija,15.0f));
    }

    public boolean checkPermission(){
        if(ActivityCompat.checkSelfPermission(requireContext(),Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(requireContext(),Manifest.permission.ACCESS_COARSE_LOCATION)==PackageManager.PERMISSION_GRANTED){
            return true;
        }
        return false;
    }

    @SuppressLint("MissingPermission")
    private void getLocation(){
        if(checkPermission()){
            if(isLocationEnabled()){
                mFusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
                    @Override
                    public void onComplete(@NonNull Task<Location> task) {
                        Location location= task.getResult();
                        if(location!=null){
                            LatLng currentLocation=new LatLng(location.getLatitude(),location.getLongitude());
                            mMap.addMarker(new MarkerOptions().position(currentLocation).title("Marker on current location"));
                            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLocation,15.0f));
                        }
                        else{
                            Toast.makeText(requireContext(),"Unable to get location",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
            else{
                Toast.makeText(requireContext(),"Location is diabled",Toast.LENGTH_SHORT).show();
            }
        }
        else{
            getPermissions();
        }
    }

    private boolean isLocationEnabled(){
        LocationManager locationManager=(LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        return locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER) || locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }

    private void getPermissions(){
        ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION},69);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==69){
            if(grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){

            }
            else{
                Toast.makeText(requireContext(),"Permission is not granted. Some features might not work!",Toast.LENGTH_SHORT).show();
            }
        }
    }
}