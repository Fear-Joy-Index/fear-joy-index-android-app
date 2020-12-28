package ru.nsu.fit.joyandfear.data;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Room;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.model.LatLng;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.UUID;

public class DataProvider extends ContentProvider {

    public class Names{
        public class Area{
            public final static String polygon = "polygon";
            public final static String score = "score";
        }
    }

    private RequestQueue requestQueue;
    private DB db;
    private AreaDao areaDao;
    private  QueryDateDao queryDateDao;
    private static final String DBNAME = "db";



    @Override
    public boolean onCreate() {
        db = Room.databaseBuilder(getContext(), DB.class, DBNAME).build();
        areaDao = db.areaDao();
        queryDateDao = db.queryDateDao();

        Cache cache = new DiskBasedCache(getContext().getCacheDir(), 1024 * 1024);
        Network network = new BasicNetwork(new HurlStack());
        requestQueue = new RequestQueue(cache, network);
        requestQueue.start();

        return true;
    }
    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {

        uriMatcher.addURI("ru.nsu.fit.joyandfear.data.provider", "areas", 1);

        uriMatcher.addURI("ru.nsu.fit.joyandfear.data.provider", "areas/*", 2);

        uriMatcher.addURI("ru.nsu.fit.joyandfear.data.provider", "mark", 3);


    }

    private void requestAreas(){
        String url = "http://server/getMarks";

        JsonArrayRequest areasRequest = new JsonArrayRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {

                            for (int i = 0; i < response.length(); i++) {
                                ContentValues newValues = new ContentValues();
                                newValues.put(DataProvider.Names.Area.polygon, response.getJSONObject(i).getJSONArray("coordinates").toString());
                                newValues.put(DataProvider.Names.Area.score, response.getJSONObject(i).getDouble("score"));
                                insert(Uri.parse("content://ru.nsu.fit.joyandfear.data.provider/areas"),newValues);

                                //LatLng location = new LatLng(response.getJSONArray(i).getDouble(0), response.getJSONArray(i).getDouble(1)); TODO: добавить этот парс туда где он нужен
                            }
                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }
                });
        requestQueue.add(areasRequest);
    }

    private void sendMark(int mark, LatLng location, Timestamp timestamp){
        String url = "http://server/saveMark";

        try {
            JSONObject body = new JSONObject().put("mark", mark).put("timestamp", timestamp.toString()).put("coords", new JSONArray().put(location.longitude).put(location.latitude));

        JsonObjectRequest markRequest = new JsonObjectRequest
                (Request.Method.POST, url, body, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }
                });

        requestQueue.add(markRequest);
        Log.i("data provider", "request to server:"+ url + "\n  body looks like:" + body.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        Cursor cursor;
        switch (uriMatcher.match(uri)) {
            case 1:
                cursor = areaDao.getAll();
                if (getContext() != null) {
                    cursor.setNotificationUri(getContext().getContentResolver(), uri);
                    requestAreas();
                    return cursor;
                }
                break;
            default:
                throw new IllegalArgumentException("Unknown uri:" + uri);
        }
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        switch (uriMatcher.match(uri)) {
            case 1:
                if (getContext() != null) {
                    String uid = insertArea(values);
                    queryDateDao.insertAll(new QueryDate(uri.toString(), System.currentTimeMillis()/1000));
                    if (uid != null) {
                        getContext().getContentResolver().notifyChange(uri, null);
                        return uri;
                    }
                }
                break;
            case 3:
                sendMark(values.getAsInteger("mark"), new LatLng(values.getAsDouble("lat"), values.getAsDouble("lng")), new java.sql.Timestamp(System.currentTimeMillis()/1000));
                return uri;
            default:
                throw new IllegalArgumentException
                        ("Unknown URI: " + uri);
        }
        return null;
    }

    private String md5(String s) {
        try {
            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            digest.update(s.getBytes());
            byte[] messageDigest = digest.digest();

            // Create Hex String
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) hexString.append(Integer.toHexString(0xFF & b));
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
    private String insertArea(ContentValues values){
        Area area = new Area();
        if(values.containsKey(Names.Area.polygon)){
            area.polygon = values.getAsString(Names.Area.polygon);
            String hash = md5(area.polygon);
            area.hash = hash;
            area.uid = areaDao.uidByHash(hash);
            area.score = values.getAsDouble(Names.Area.score);
            if (area.uid  == null){
                area.uid = UUID.randomUUID().toString();
                areaDao.insert(area);
            }
            else {
                areaDao.update(area);
            }
            return area.uid;
        }
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        if (uriMatcher.match(uri) == 1) {
            throw new IllegalArgumentException
                    ("Invalid uri: cannot delete");
        }
        throw new IllegalArgumentException
                ("Unknown URI:" + uri);
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
