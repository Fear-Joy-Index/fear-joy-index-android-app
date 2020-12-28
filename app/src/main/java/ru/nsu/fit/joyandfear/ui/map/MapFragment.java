package ru.nsu.fit.joyandfear.ui.map;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.Manifest;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Color;
import android.location.Location;
import android.net.Uri;
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
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.tasks.Task;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import ru.nsu.fit.joyandfear.R;
import ru.nsu.fit.joyandfear.data.DataProvider;
import ru.nsu.fit.joyandfear.databinding.FragmentMapBinding;



public class MapFragment extends Fragment{
    private static final int REQUEST_CODE = 101;
    private GoogleMap mMap;

    private Location currentLocation;
    private FusedLocationProviderClient fusedLocationProviderClient;

    private MapViewModel mapViewModel;
    private FragmentMapBinding binding;

    private OnMapReadyCallback callback = googleMap -> {
        mMap = googleMap;
        //initData();


        mapViewModel.getAreas().observe(getViewLifecycleOwner(), new Observer<List<Area>>() {
            @Override
            public void onChanged(@Nullable List<Area> areas) {
                drawAreas(areas);
            }
        });

        LatLng latLng = new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude());
        SharedPreferences settings = getContext().getSharedPreferences("PREFS", 0);
        int emotion = settings.getInt("emotion", -1);

        if (emotion != -1 && latLng != null){
            sendMark(emotion, latLng);
            settings.edit().putInt("emotion", -1).apply();
        }

        MarkerOptions markerOptions = new MarkerOptions().position(latLng).title("You are here!");
        googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 3));
        googleMap.addMarker(markerOptions);
    };

    private void sendMark(int emotion, LatLng latLng){
        ContentValues newValues = new ContentValues();
        newValues.put("mark", emotion);
        newValues.put("lat", latLng.latitude);
        newValues.put("lng", latLng.longitude);
        getContext().getContentResolver().insert(Uri.parse("content://ru.nsu.fit.joyandfear.data.provider/mark"),newValues);
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this.requireActivity());
        fetchLastLocation();
    }
    public void fetchLastLocation(){
        if (ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(requireActivity(), new String[]
                    {Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);
            return;
        }
        Task<Location> task = fusedLocationProviderClient.getLastLocation();
        task.addOnSuccessListener(location -> {
            if (location != null){
                currentLocation = location;
                SupportMapFragment mapFragment =
                        (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
                if (mapFragment != null) {
                    mapFragment.getMapAsync(callback);
                }
            }

        });
    }
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        MapViewModelFactory factory = new MapViewModelFactory(this.getContext());
        mapViewModel = new ViewModelProvider(this, factory).get(MapViewModel.class);


        binding = FragmentMapBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this.requireActivity());
        fetchLastLocation();
        return root;
    }

    private void drawAreas(List<Area> areas){
        for(Area a: areas) {
            PolygonOptions polygonOptions = new PolygonOptions();
            for (LatLng location: a.coords) {
                polygonOptions.add(location);
            }
            Double score = a.score;
            /*int[] polColor = new int[3];
            switch (score.intValue()) {
                case 0:
                    polColor[0] = 255;
                    polColor[1] = 0;
                    break;
                case 1:
                    polColor[0] = 255;
                    polColor[1] = 125;
                    break;
                case 2:
                    polColor[0] = 255;
                    polColor[1] = 255;
                    break;
                case 3:
                    polColor[0] = 160;
                    polColor[1] = 255;
                    break;
                case 4:
                case 5:
                    polColor[0] = 0;
                    polColor[1] = 255;
            }*/

            float[] color = {(float) (a.score*24), 100,100};
            Polygon polygon = mMap.addPolygon(polygonOptions
                    .strokeColor(Color.BLACK)
                    .fillColor(Color.HSVToColor(60, color))
                    .strokeWidth(2));
            polygon.setTag(a.score);
            polygon.setClickable(true);
            mMap.setOnPolygonClickListener(new GoogleMap.OnPolygonClickListener() {
                @Override
                public void onPolygonClick(Polygon polygon) {
                    String tag = String.valueOf(polygon.getTag());
                    Toast.makeText(getContext().getApplicationContext(), tag, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    fetchLastLocation();
                }
                break;
        }
    }
}
