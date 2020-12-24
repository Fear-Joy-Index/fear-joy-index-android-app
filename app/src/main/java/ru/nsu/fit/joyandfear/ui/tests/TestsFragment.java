package ru.nsu.fit.joyandfear.ui.tests;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import ru.nsu.fit.joyandfear.MainActivity;
import ru.nsu.fit.joyandfear.R;
import ru.nsu.fit.joyandfear.databinding.FragmentTestsBinding;

public class TestsFragment extends Fragment {
    private Button bt1;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tests, container, false);
        bt1 = v.findViewById(R.id.button_1);

        bt1.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), ZungActivity.class);
            startActivity(intent);
        });
        return v;
    }

}