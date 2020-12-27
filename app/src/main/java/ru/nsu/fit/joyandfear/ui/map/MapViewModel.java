package ru.nsu.fit.joyandfear.ui.map;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MapViewModel extends ViewModel {

    private AreaRepository repository;
    private MutableLiveData<List<Area>> areas;
    private ExecutorService esvc = Executors.newFixedThreadPool(3);


    public MapViewModel(Context context) {
        repository = new AreaRepository(context, esvc);
        areas = new MutableLiveData<>();
    }

    public MutableLiveData<List<Area>> getAreas() {
        repository.fetchAreasAsync(new RepositoryCallback<List<Area>>() {
            @Override
            public void onComplete(List<Area> result) {
                areas.postValue(result);
            }
        });
        return areas;
    }
}