package ru.nsu.fit.joyandfear.ui.map;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
import ru.nsu.fit.joyandfear.R;
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
        try {
            final StringBuilder stringBuilder = new StringBuilder();
            final InputStreamReader streamReader = new InputStreamReader(getResources().openRawResource(R.raw.map));  //временное чтение из файла TODO: вынести получение в async task
            final BufferedReader bufferedReader = new BufferedReader(streamReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append('\n');
            }
            final JSONObject mapJson = new JSONObject(stringBuilder.toString());
            JSONArray map = mapJson.getJSONArray("map");
            for (int i = 0; i < map.length(); i++) {
                PolygonOptions polygonOptions = new PolygonOptions();
                JSONArray coords = map.getJSONObject(i).getJSONArray("coordinates");
                for (int j = 0; j < coords.length(); j++) {
                    String[] latlong =  coords.getString(j).split(",");
                    double latitude = Double.parseDouble(latlong[0]);
                    double longitude = Double.parseDouble(latlong[1]);
                    LatLng location = new LatLng(latitude, longitude);
                    polygonOptions.add(location);
                }
                Double score = map.getJSONObject(i).getDouble("score");
                int[] polColor = new int[3];
                switch (score.intValue()){
                    case 0:
                        polColor[0]=255;
                        polColor[1]=0;
                        break;
                    case 1:
                        polColor[0]=255;
                        polColor[1]=125;
                        break;
                    case 2:
                        polColor[0]=255;
                        polColor[1]=255;
                        break;
                    case 3:
                        polColor[0]=160;
                        polColor[1]=255;
                        break;
                    case 4:
                    case 5:
                        polColor[0]=0;
                        polColor[1]=255;
                }
                Polygon polygon = mMap.addPolygon(polygonOptions
                        .strokeColor(Color.BLACK)
                        .fillColor(Color.argb(100, polColor[0], polColor[1], 0))
                        .strokeWidth(5));

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        LatLng latLng = new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions().position(latLng).title("You are here!");
        googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 3));
        googleMap.addMarker(markerOptions);
    };
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
            }
            SupportMapFragment mapFragment =
                    (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
            if (mapFragment != null) {
                mapFragment.getMapAsync(callback);
            }
        });
    }
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        mapViewModel =
                new ViewModelProvider(this).get(MapViewModel.class);

        binding = FragmentMapBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this.requireActivity());
        fetchLastLocation();
        return root;
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
