package ru.nsu.fit.joyandfear.ui.tests;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import ru.nsu.fit.joyandfear.R;

public class EndActivity extends AppCompatActivity {

    TextView result;
    Button bt;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        result = findViewById(R.id.text_end);
        bt = findViewById(R.id.button_to_test);
        Intent intent = getIntent();

        String result_str = intent.getStringExtra("result");
        result.setText(result_str);

        bt.setOnClickListener(view -> {
            Intent intent1 = new Intent(EndActivity.this, TestsFragment.class);
            startActivity(intent1);
        });
    }
}
