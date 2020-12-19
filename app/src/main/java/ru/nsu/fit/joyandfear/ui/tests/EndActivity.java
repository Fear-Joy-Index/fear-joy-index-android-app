package ru.nsu.fit.joyandfear.ui.tests;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import ru.nsu.fit.joyandfear.R;

public class EndActivity extends AppCompatActivity {

    TextView result;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_end);

        result = findViewById(R.id.text_end);
    }
}
