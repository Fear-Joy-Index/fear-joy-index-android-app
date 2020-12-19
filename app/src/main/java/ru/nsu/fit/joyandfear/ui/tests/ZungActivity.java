package ru.nsu.fit.joyandfear.ui.tests;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import ru.nsu.fit.joyandfear.R;

public class ZungActivity extends AppCompatActivity {

    TextView question;
    Button button_A, button_B, button_C, button_D;

    List<QuestionItem> questionItems;
    int currentQuestion = 0;
    int points = 0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_test_4);

        question = findViewById(R.id.question_view);
        button_A = findViewById(R.id.button_A);
        button_B = findViewById(R.id.button_B);
        button_C = findViewById(R.id.button_C);
        button_D = findViewById(R.id.button_D);

        setQuestionScreen(currentQuestion);

        button_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                points = questionItems.get(currentQuestion).getScore() + points;

                //load next question if any
                if (currentQuestion < questionItems.size()-1){
                    currentQuestion++;
                    setQuestionScreen(currentQuestion);
                } else {
                    Intent intent = new Intent(getApplicationContext(), EndActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        button_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                points = questionItems.get(currentQuestion).getScore() + points;
                //load next question if any
                if (currentQuestion < questionItems.size()-1){
                    currentQuestion++;
                    setQuestionScreen(currentQuestion);
                } else {
                    Intent intent = new Intent(getApplicationContext(), EndActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        button_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                points = questionItems.get(currentQuestion).getScore() + points;

                //load next question if any
                if (currentQuestion < questionItems.size()-1){
                    currentQuestion++;
                    setQuestionScreen(currentQuestion);
                } else {
                    Intent intent = new Intent(getApplicationContext(), EndActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        button_D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                points = questionItems.get(currentQuestion).getScore() + points;

                //load next question if any
                if (currentQuestion < questionItems.size()-1){
                    currentQuestion++;
                    setQuestionScreen(currentQuestion);
                } else {
                    Intent intent = new Intent(getApplicationContext(), EndActivity.class);
                    //надо передать текст с результатами баллов
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void setQuestionScreen(int number){
        question.setText(questionItems.get(number).getQuestion());
        button_A.setText(questionItems.get(number).getAnswA());
        button_B.setText(questionItems.get(number).getAnswB());
        button_C.setText(questionItems.get(number).getAnswC());
        button_D.setText(questionItems.get(number).getAnswD());
    }

    private void loadAllQuestions(){
        questionItems = new ArrayList<>();

        //load all questions into json string
        String jsonStr = loadJSONFromAssert("zung_test.json");

        //load all data into list
        try{
            JSONObject jsonObj = new JSONObject(jsonStr);
            JSONArray questions = jsonObj.getJSONArray("questions");
            for (int i = 0; i < questions.length(); i++){
                JSONObject question = questions.getJSONObject(i);

                String questionString = question.getString("question");
                //???????????????????????????????????????????????????????????????
                String answerAString = question.getString("answer.A");
                String answerBString = question.getString("answer.B");
                String answerCString = question.getString("answer.C");
                String answerDString = question.getString("answer.D");
                Integer scoreString = question.getInt("answer.score");

                questionItems.add(new QuestionItem(
                        questionString,
                        answerAString,
                        answerBString,
                        answerCString,
                        answerDString,
                        scoreString
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
