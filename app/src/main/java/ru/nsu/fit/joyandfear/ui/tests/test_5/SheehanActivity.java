package ru.nsu.fit.joyandfear.ui.tests.test_5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import ru.nsu.fit.joyandfear.R;
import ru.nsu.fit.joyandfear.ui.settings.SettingsFragment;
import ru.nsu.fit.joyandfear.ui.tests.EndActivity;
import ru.nsu.fit.joyandfear.ui.tests.question_item.QuestionItem5;

public class SheehanActivity extends AppCompatActivity {

    TextView question, count;
    Button button_A, button_B, button_C, button_D, button_E;


    List<QuestionItem5> questionItem5s;
    int currentQuestion = 0;
    int points = 0;
    String small = "1";

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Intent intent1 = getIntent();
        String name_test = intent1.getStringExtra("name_test");

        setContentView(R.layout.activity_test_5);

        Objects.requireNonNull(getSupportActionBar()).setTitle(name_test);

        question = findViewById(R.id.question_view);
        button_A = findViewById(R.id.button_A);
        button_B = findViewById(R.id.button_B);
        button_C = findViewById(R.id.button_C);
        button_D = findViewById(R.id.button_D);
        button_E = findViewById(R.id.button_E);

        count = findViewById(R.id.count_view);

        loadAllQuestions();
        setQuestionScreen(currentQuestion);

        button_A.setOnClickListener(view -> {
            points = questionItem5s.get(currentQuestion).getScoreA() + points;

            //load next question if any
            if (currentQuestion < questionItem5s.size()-1){
                currentQuestion++;
                setQuestionScreen(currentQuestion);
            } else {
                Intent intent = new Intent(getApplicationContext(), EndActivity.class);

                if ((points >= 0) && (points <= 20)) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                        intent.putExtra("result", "У вас нормальный уровень тревожности");
                    else
                        intent.putExtra("result", "Normal level of anxiety");
                }else
                if ((points >= 30) && (points <= 80)) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                        intent.putExtra("result", "У вас аномальный уровень тревожности");
                    else
                        intent.putExtra("result", "Abnormal level of anxiety");
                }else {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                        intent.putExtra("result", "У вас высокий уровень тревожности");
                    else
                        intent.putExtra("result", "High level of anxiety");
                }
                intent.putExtra("small", small);
                startActivity(intent);
                finish();
            }
        });

        button_B.setOnClickListener(view -> {
            points = questionItem5s.get(currentQuestion).getScoreB() + points;
            //load next question if any
            if (currentQuestion < questionItem5s.size()-1){
                currentQuestion++;
                setQuestionScreen(currentQuestion);
            } else {
                Intent intent = new Intent(getApplicationContext(), EndActivity.class);

                if ((points >= 0) && (points <= 20)) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                        intent.putExtra("result", "У вас нормальный уровень тревожности");
                    else
                        intent.putExtra("result", "Normal level of anxiety");
                }else
                if ((points >= 30) && (points <= 80)) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                        intent.putExtra("result", "У вас аномальный уровень тревожности");
                    else
                        intent.putExtra("result", "Abnormal level of anxiety");
                }else {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                        intent.putExtra("result", "У вас высокий уровень тревожности");
                    else
                        intent.putExtra("result", "High level of anxiety");
                }
                intent.putExtra("small", small);
                startActivity(intent);
                finish();
            }
        });

        button_C.setOnClickListener(view -> {
            points = questionItem5s.get(currentQuestion).getScoreC() + points;

            //load next question if any
            if (currentQuestion < questionItem5s.size()-1){
                currentQuestion++;
                setQuestionScreen(currentQuestion);
            } else {
                Intent intent = new Intent(getApplicationContext(), EndActivity.class);

                if ((points >= 0) && (points <= 20)) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                        intent.putExtra("result", "У вас нормальный уровень тревожности");
                    else
                        intent.putExtra("result", "Normal level of anxiety");
                }else
                if ((points >= 30) && (points <= 80)) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                        intent.putExtra("result", "У вас аномальный уровень тревожности");
                    else
                        intent.putExtra("result", "Abnormal level of anxiety");
                }else {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                        intent.putExtra("result", "У вас высокий уровень тревожности");
                    else
                        intent.putExtra("result", "High level of anxiety");
                }
                intent.putExtra("small", small);
                startActivity(intent);
                finish();
            }
        });

        button_D.setOnClickListener(view -> {
            points = questionItem5s.get(currentQuestion).getScoreD() + points;

            //load next question if any
            if (currentQuestion < questionItem5s.size()-1){
                currentQuestion++;
                setQuestionScreen(currentQuestion);
            } else {
                Intent intent = new Intent(getApplicationContext(), EndActivity.class);
                if ((points >= 0) && (points <= 20)) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                        intent.putExtra("result", "У вас нормальный уровень тревожности");
                    else
                        intent.putExtra("result", "Normal level of anxiety");
                }else
                if ((points >= 30) && (points <= 80)) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                        intent.putExtra("result", "У вас аномальный уровень тревожности");
                    else
                        intent.putExtra("result", "Abnormal level of anxiety");
                }else {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                        intent.putExtra("result", "У вас высокий уровень тревожности");
                    else
                        intent.putExtra("result", "High level of anxiety");
                }
                intent.putExtra("small", small);
                startActivity(intent);
                finish();
            }
        });

        button_E.setOnClickListener(view -> {
            points = questionItem5s.get(currentQuestion).getScoreE() + points;

            //load next question if any
            if (currentQuestion < questionItem5s.size()-1){
                currentQuestion++;
                setQuestionScreen(currentQuestion);
            } else {
                Intent intent = new Intent(getApplicationContext(), EndActivity.class);
                if ((points >= 0) && (points <= 20)) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                        intent.putExtra("result", "У вас нормальный уровень тревожности");
                    else
                        intent.putExtra("result", "Normal level of anxiety");
                }else
                if ((points >= 30) && (points <= 80)) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                        intent.putExtra("result", "У вас аномальный уровень тревожности");
                    else
                        intent.putExtra("result", "Abnormal level of anxiety");
                }else {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                        intent.putExtra("result", "У вас высокий уровень тревожности");
                    else
                        intent.putExtra("result", "High level of anxiety");
                }
                intent.putExtra("small", small);
                startActivity(intent);
                finish();
            }
        });

    }

    private void setQuestionScreen(int number){
        question.setText(questionItem5s.get(number).getQuestion());
        count.setText((number+1) + "/" + questionItem5s.size());
        button_A.setText(questionItem5s.get(number).getAnswA());
        button_B.setText(questionItem5s.get(number).getAnswB());
        button_C.setText(questionItem5s.get(number).getAnswC());
        button_D.setText(questionItem5s.get(number).getAnswD());
        button_E.setText(questionItem5s.get(number).getAnswE());
    }

    private void loadAllQuestions(){
        questionItem5s = new ArrayList<>();
        String jsonStr;

        //load all questions into json string
        if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
            jsonStr = loadJSONFromAssert("ru/sheehan_test");
        else
            jsonStr = loadJSONFromAssert("en/sheehan_test_en");

        //load all data into list
        try{
            JSONObject jsonObj = new JSONObject(jsonStr);
            JSONArray questions = jsonObj.getJSONArray("questions");

            for (int i = 0; i < questions.length(); i++){
                String answerAString, answerBString, answerCString, answerDString, answerEString;
                Integer scoreAString, scoreBString, scoreCString, scoreDString, scoreEString;

                JSONObject question = questions.getJSONObject(i);
                JSONObject ansA, ansB, ansC, ansD, ansE;
                ansA = question.getJSONObject("A");
                ansB = question.getJSONObject("B");
                ansC = question.getJSONObject("C");
                ansD = question.getJSONObject("D");
                ansE = question.getJSONObject("E");


                String questionString = question.getString("question");
                //???????????????????????????????????????????????????????????????
                answerAString = ansA.getString("answer");
                scoreAString = ansA.getInt("score");

                answerBString = ansB.getString("answer");
                scoreBString = ansB.getInt("score");

                answerCString = ansC.getString("answer");
                scoreCString = ansC.getInt("score");

                answerDString = ansD.getString("answer");
                scoreDString = ansD.getInt("score");

                answerEString = ansE.getString("answer");
                scoreEString = ansE.getInt("score");

                questionItem5s.add(new QuestionItem5(
                        questionString,
                        answerAString,
                        answerBString,
                        answerCString,
                        answerDString,
                        answerEString,
                        scoreAString,
                        scoreBString,
                        scoreCString,
                        scoreDString,
                        scoreEString
                ));
            }
        } catch (JSONException e){
            e.printStackTrace();
        }
    }

    private String loadJSONFromAssert(String file){
        String json = "";
        try{
            InputStream is = getAssets().open(file);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e){
            e.printStackTrace();
        }
        return json;
    }
}
