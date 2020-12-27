package ru.nsu.fit.joyandfear;

import android.app.AppComponentFactory;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.GridView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

import ru.nsu.fit.joyandfear.MainActivity;
import ru.nsu.fit.joyandfear.R;

public class EmotionActivity extends AppCompatActivity {
    private ImageView e1, e2, e3, e4, e5;

    Integer[] emotionNum = {1, 2, 3, 4, 5};
    //int[] fruitImages = {R.drawable.e1,R.drawable.e2,R.drawable.e3,R.drawable.e4,R.drawable.e5};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emotion);

        //to check once a day
        Calendar calendar = Calendar.getInstance();
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        SharedPreferences settings = getSharedPreferences("PREFS", 0);
        int lastDay = settings.getInt("day", 0);

        if (lastDay == currentDay)
            openActivity();

        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("day", currentDay);
        editor.commit();

        e1 = findViewById(R.id.imageView_1);
        e2 = findViewById(R.id.imageView_2);
        e3 = findViewById(R.id.imageView_3);
        e4 = findViewById(R.id.imageView_4);
        e5 = findViewById(R.id.imageView_5);

        e1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //отправить инфу в базу
                    Toast.makeText(getApplicationContext(), "Oh, poor baby!", Toast.LENGTH_SHORT).show();
                    openActivity();
                }
            });

        e2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //отправить инфу в базу
                openActivity();
            }
        });

        e3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //отправить инфу в базу
                openActivity();
            }
        });

        e4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //отправить инфу в базу
                openActivity();
            }
        });

        e5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //отправить инфу в базу
                openActivity();
            }
        });
        }


        public void openActivity(){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
}
