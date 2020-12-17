package ru.nsu.fit.joyandfear.ui.tests;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import ru.nsu.fit.joyandfear.databinding.FragmentTestsBinding;

public class TestsFragment extends Fragment {

    private TestsViewModel testsViewModel;
    private FragmentTestsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        testsViewModel =
                new ViewModelProvider(this).get(TestsViewModel.class);

        binding = FragmentTestsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textTests;
        testsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}