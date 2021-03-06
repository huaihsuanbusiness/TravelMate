package com.huaihsuanhuang.TravelMate;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.huaihsuanhuang.TravelMate.model.MarkerLocation;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MapsActivityWifi extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private ArrayList<ArrayList<String>> wrapall = new ArrayList<>();
    private ArrayList<String> transthree = new ArrayList<>();
    private static final int REQUEST_LOCATION = 2;
    Double currentlongitude;
    Double currentlatitude;
    LocationRequest locationRequest;
    List<MarkerLocation> markerLocations;
    String server_url = "https://quality.data.gov.tw/dq_download_json.php?nid=60139&md5_url=e5ba999fc4eefe3f9ff4a933f898ae8a";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);


        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(server_url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("requesttest", "response = " + response.toString());

                        parserJson(response);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("requesttestsomethingwentwrong", "error : " + error.toString());
            }
        }
        );

        Volley.newRequestQueue(this).add(jsonObjectRequest);
        mapFragment.getMapAsync(this);
    }


    private void parserJson(JSONArray jsonArray) {

        try {
            JSONArray array = jsonArray;
            Log.d("jsonarrayishere", array.toString());

            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);
                String title = object.getString("機關名稱");
                String longitudevalue = object.get("經度").toString();
                String latitudevalue = object.get("緯度").toString();
                if (longitudevalue.isEmpty() || latitudevalue.isEmpty()) {
                    continue;
                }

                Double longitude = Double.valueOf(longitudevalue);
                Double latitude = Double.valueOf(latitudevalue);

                LatLng wifipoint = new LatLng(latitude, longitude);
                addMarker(wifipoint, title);

            }


        } catch (JSONException e) {
            e.printStackTrace();
            Log.d("objectstestwrong", e.getLocalizedMessage());
        }


    }


    private void moveMap(LatLng place) {
        CameraPosition cameraPosition =
                new CameraPosition.Builder()
                        .target(place)
                        .zoom(13)
                        .build();


        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }

    private void addMarker(LatLng place, String title) {
        BitmapDescriptor icon =
                BitmapDescriptorFactory.fromResource(R.drawable.icons_wifi2);

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(place)
                .title(title)
                .icon(icon);

        mMap.addMarker(markerOptions);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_LOCATION);
            return;
        } else {
            setupMyLocation();
            createLocationRequest();
            //     fuseLocationRequest();
        }


        LatLng place = new LatLng(25.051861, 121.544006);
        moveMap(place);


    }


    @SuppressLint("MissingPermission")
    private void setupMyLocation() {
        mMap.setMyLocationEnabled(true);
        mMap.setOnMyLocationButtonClickListener(
                new GoogleMap.OnMyLocationButtonClickListener() {
                    @Override
                    public boolean onMyLocationButtonClick() {


                        fuseLocation();
                        return false;
                    }
                });
    }


    @SuppressLint("MissingPermission")
    private void fuseLocation() {
        FusedLocationProviderClient client =
                LocationServices.getFusedLocationProviderClient(this);
        client.getLastLocation().addOnCompleteListener(
                this, new OnCompleteListener<Location>() {
                    @Override
                    public void onComplete(@NonNull Task<Location> task) {
                        if (task.isSuccessful()) {
                            Location location = task.getResult();
//
                            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
                                    new LatLng(location.getLatitude(),

                                            location.getLongitude())
                                    , 13));
                            currentlatitude = location.getLatitude();
                            currentlongitude = location.getLongitude();
                        }
                    }
                });

    }

    private void createLocationRequest() {
        locationRequest = new LocationRequest();
        locationRequest.setInterval(5000);
        locationRequest.setFastestInterval(2000);
        locationRequest.setPriority(
                LocationRequest.PRIORITY_HIGH_ACCURACY);
    }

    @SuppressLint("MissingPermission")
    private void fuseLocationRequest() {
        FusedLocationProviderClient client =
                LocationServices.getFusedLocationProviderClient(this);
        client.requestLocationUpdates(locationRequest,
                new LocationCallback() {
                    @Override
                    public void onLocationResult(LocationResult locationResult) {
                        Location location = locationResult.getLastLocation();
                        Log.i("UPDATE", location.toString());
                        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
                                new LatLng(location.getLatitude(),
                                        location.getLongitude())
                                , 15));
                    }
                }
                , null);
    }

    @Override
    @SuppressLint("MissingPermission")
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_LOCATION:
                if (grantResults.length > 0
                        && grantResults[0] ==
                        PackageManager.PERMISSION_GRANTED) {

                    setupMyLocation();
                } else {

                }
                break;
        }
    }
}
