package ru.nsu.fit.joyandfear.ui.map;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MapViewModelFactory implements ViewModelProvider.Factory {

    private Context context;

    public MapViewModelFactory(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MapViewModel.class)) {
            return (T) new MapViewModel(context);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}