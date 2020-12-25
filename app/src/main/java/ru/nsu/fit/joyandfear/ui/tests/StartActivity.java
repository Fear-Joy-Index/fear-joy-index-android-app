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

public class StartActivity extends AppCompatActivity {

    TextView test_name, test_text;
    Button bt;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        test_name = findViewById(R.id.text_start_name);
        test_text = findViewById(R.id.text_start);
        bt = findViewById(R.id.button);
        Intent intent = getIntent();

        String name_str = intent.getStringExtra("name");
        String text_str = intent.getStringExtra("text");
        test_name.setText(name_str);
        test_text.setText(text_str);

        bt.setOnClickListener(view -> {
            if (name_str.equals("Шкала Зунга")){
                Intent intent1 = new Intent(getApplicationContext(), ZungActivity.class);
                startActivity(intent1);
            }
            else
            if (name_str.equals("Шкала самооценки тревоги Спилбера-Ханина")){
                Intent intent1 = new Intent(getApplicationContext(), SpilbergActivity.class);
                startActivity(intent1);
            }
            else
            if (name_str.equals("Шкала депрессии Бека")){
                Intent intent1 = new Intent(getApplicationContext(), BeckActivity.class);
                startActivity(intent1);
            }

            finish();
        });
    }
}