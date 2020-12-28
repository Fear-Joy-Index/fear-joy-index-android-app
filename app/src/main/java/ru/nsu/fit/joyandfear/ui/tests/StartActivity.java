package ru.nsu.fit.joyandfear.ui.tests;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ru.nsu.fit.joyandfear.R;
import ru.nsu.fit.joyandfear.ui.tests.test_2.SnyderActivity;
import ru.nsu.fit.joyandfear.ui.tests.test_2.TaylorActivity;
import ru.nsu.fit.joyandfear.ui.tests.test_3.RyakhovskyActivity;
import ru.nsu.fit.joyandfear.ui.tests.test_4.BeckActivity;
import ru.nsu.fit.joyandfear.ui.tests.test_4.SpilbergActivity;
import ru.nsu.fit.joyandfear.ui.tests.test_4.ZungActivity;
import ru.nsu.fit.joyandfear.ui.tests.test_5.SheehanActivity;
import ru.nsu.fit.joyandfear.ui.tests.test_6.YusupovActivity;
import ru.nsu.fit.joyandfear.ui.settings.SettingsFragment;

public class StartActivity extends AppCompatActivity {

    TextView test_name, test_text;
    Button bt;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String name_str = intent.getStringExtra("name");
        String text_str = intent.getStringExtra("text");

        if (name_str.equals("Методика измерения уровня тревожности Тейлора") || name_str.equals("Taylor's anxiety measurement technique") || (name_str.equals("Шкала самооценки тревоги Шихана") || name_str.equals("Sheehan Patient-Rated Anxiety Scale, SPRAS")) || (name_str.equals("Тест на уровень эмпатийности Юсупова") || name_str.equals("Empathy test")))
            setContentView(R.layout.activity_start_small);
        else
            setContentView(R.layout.activity_start);

        test_name = findViewById(R.id.text_start_name);
        test_text = findViewById(R.id.text_start);
        bt = findViewById(R.id.button);



        test_name.setText(name_str);
        test_text.setText(text_str);

        bt.setOnClickListener(view -> {
            if (name_str.equals("Шкала Зунга") || name_str.equals("Zung Self-Rating Depression Scale (SDS)")){
                Intent intent1 = new Intent(getApplicationContext(), ZungActivity.class);
                startActivity(intent1);
            }
            else
            if (name_str.equals("Шкала самооценки тревоги Спилбера-Ханина") || name_str.equals("The Spielberger State-Trait Anxiety Inventory (STAI)")){
                Intent intent1 = new Intent(getApplicationContext(), SpilbergActivity.class);
                startActivity(intent1);
            }
            else
            if (name_str.equals("Шкала депрессии Бека") || name_str.equals("Beck Depression Inventory")){
                Intent intent1 = new Intent(getApplicationContext(), BeckActivity.class);
                startActivity(intent1);
            }
            else
            if (name_str.equals("Тест на уровень общительности Ряховского") || name_str.equals("Ryakhovsky test")){
                Intent intent1 = new Intent(getApplicationContext(), RyakhovskyActivity.class);
                startActivity(intent1);
            }else
            if (name_str.equals("Методика измерения уровня тревожности Тейлора") || name_str.equals("Taylor's anxiety measurement technique")){
                Intent intent1 = new Intent(getApplicationContext(), TaylorActivity.class);
                startActivity(intent1);
            }
            else
            if (name_str.equals("Тест на оценку самоконтроля в общении (М. Снайдер)") || name_str.equals("Assessment of self-control in communication (M. Snyder)")){
                Intent intent1 = new Intent(getApplicationContext(), SnyderActivity.class);
                startActivity(intent1);
            }
            else
            if (name_str.equals("Шкала самооценки тревоги Шихана") || name_str.equals("Sheehan Patient-Rated Anxiety Scale, SPRAS")){
                Intent intent1 = new Intent(getApplicationContext(), SheehanActivity.class);
                startActivity(intent1);
            }
            else
            if (name_str.equals("Тест на уровень эмпатийности Юсупова") || name_str.equals("Empathy test")){
                Intent intent1 = new Intent(getApplicationContext(), YusupovActivity.class);
                startActivity(intent1);
            }

            finish();
        });
    }
}