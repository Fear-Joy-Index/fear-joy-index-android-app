package ru.nsu.fit.joyandfear.ui.map;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

import ru.nsu.fit.joyandfear.R;
import ru.nsu.fit.joyandfear.data.DataProvider;

interface RepositoryCallback<T> {
    void onComplete(T result);
}

public class AreaRepository {
    private Context context;
    private final Executor executor;

    public AreaRepository(Context context, Executor executor) {
        this.context = context;
        this.executor = executor;
    }

    public void fetchAreasAsync(final RepositoryCallback<List<Area>> callback){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                List<Area> areas = fetchAreas();
                callback.onComplete(areas);
            }
        });
    }
    private  void initData(){
        try {
            final StringBuilder stringBuilder = new StringBuilder();
            final InputStreamReader streamReader = new InputStreamReader(context.getResources().openRawResource(R.raw.map));   //TODO: убрать метод когда наладится взаимодействие с сервером
            final BufferedReader bufferedReader = new BufferedReader(streamReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append('\n');
            }
            final JSONObject mapJson = new JSONObject(stringBuilder.toString());
            JSONArray map = mapJson.getJSONArray("map");
            for (int i = 0; i < map.length(); i++) {
                ContentValues newValues = new ContentValues();
                newValues.put(DataProvider.Names.Area.polygon, map.getJSONObject(i).getJSONArray("coordinates").toString());
                newValues.put(DataProvider.Names.Area.score, map.getJSONObject(i).getDouble("score"));
                context.getContentResolver().insert(Uri.parse("content://ru.nsu.fit.joyandfear.data.provider/areas"),newValues);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public List<Area> fetchAreas() {
        initData();
        List<Area> areas = new ArrayList<>();
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursor = contentResolver.query(Uri.parse("content://ru.nsu.fit.joyandfear.data.provider/areas"),
                null,
                null,
                null,
                null);
        try {

            if (cursor != null) {
                while (cursor.moveToNext()) {
                    Area area = new Area();
                    JSONArray coords = new JSONArray(cursor.getString(cursor.getColumnIndex("polygon")));
                    for (int j = 0; j < coords.length(); j++) {
                        /*String[] latlong = coords.getString(j).split(",");
                        double latitude = Double.parseDouble(latlong[0]);
                        double longitude = Double.parseDouble(latlong[1]);*/
                        double latitude = coords.getJSONArray(j).getDouble(1);
                        double longitude = coords.getJSONArray(j).getDouble(0);
                        LatLng location = new LatLng(latitude, longitude);
                        area.coords.add(location);
                    }
                    area.score = cursor.getDouble(cursor.getColumnIndex("score"));
                    areas.add(area);
                }
                cursor.close();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return areas;
    }
}
