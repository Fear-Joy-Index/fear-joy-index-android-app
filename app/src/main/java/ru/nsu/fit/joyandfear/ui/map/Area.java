package ru.nsu.fit.joyandfear.ui.map;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class Area {
    public ArrayList<LatLng> coords;
    public Double score;

    public Area() {
        this.coords = new ArrayList<>();
        this.score = 0.;
    }
}
