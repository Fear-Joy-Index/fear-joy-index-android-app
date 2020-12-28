package ru.nsu.fit.joyandfear.ui.tests;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import ru.nsu.fit.joyandfear.MainActivity;
import ru.nsu.fit.joyandfear.R;
import ru.nsu.fit.joyandfear.ui.settings.SettingsFragment;

public class EndActivity extends AppCompatActivity {

    TextView result;
    Button bt;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String result_str = intent.getStringExtra("result");
        String small = intent.getStringExtra("small");

        assert small != null;
        if (small.equals("1"))
            setContentView(R.layout.activity_end_small);
        else
            setContentView(R.layout.activity_end);

        result = findViewById(R.id.text_end);
        bt = findViewById(R.id.button_to_test);

        result.setText(result_str);

        bt.setOnClickListener(view -> {
            Intent intent2 = new Intent(EndActivity.this, MainActivity.class);
            startActivity(intent2);
            //FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            //fragmentTransaction.replace(R.id.testsContainer, new TestsFragment());
        });
    }
}
