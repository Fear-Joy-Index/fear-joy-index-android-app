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

public class SpilbergActivity extends AppCompatActivity {

    TextView question, count;
    Button button_A, button_B, button_C, button_D;


    List<QuestionItem> questionItems;
    int currentQuestion = 0;
    int points = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_4);

        question = findViewById(R.id.question_view);
        button_A = findViewById(R.id.button_A);
        button_B = findViewById(R.id.button_B);
        button_C = findViewById(R.id.button_C);
        button_D = findViewById(R.id.button_D);

        count = findViewById(R.id.count_view);

        loadAllQuestions();
        setQuestionScreen(currentQuestion);

        button_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                points = questionItems.get(currentQuestion).getScoreA() + points;

                //load next question if any
                if (currentQuestion < questionItems.size()-1){
                    currentQuestion++;
                    setQuestionScreen(currentQuestion);
                } else {
                    Intent intent = new Intent(getApplicationContext(), EndActivity.class);

                    if ((points >= 0) && (points <= 30))
                        intent.putExtra("result", "Низкая тревожность");
                    else
                    if ((points > 30) && (points <= 45))
                        intent.putExtra("result", "Умеренная тревожность");
                    else
                        intent.putExtra("result", "Высокая тревожность");

                    startActivity(intent);
                    finish();
                }
            }
        });

        button_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                points = questionItems.get(currentQuestion).getScoreB() + points;
                //load next question if any
                if (currentQuestion < questionItems.size()-1){
                    currentQuestion++;
                    setQuestionScreen(currentQuestion);
                } else {
                    Intent intent = new Intent(getApplicationContext(), EndActivity.class);

                    if ((points >= 0) && (points <= 30))
                        intent.putExtra("result", "Низкая тревожность");
                    else
                    if ((points > 30) && (points <= 45))
                        intent.putExtra("result", "Умеренная тревожность");
                    else
                        intent.putExtra("result", "Высокая тревожность");

                    startActivity(intent);
                    finish();
                }
            }
        });

        button_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                points = questionItems.get(currentQuestion).getScoreC() + points;

                //load next question if any
                if (currentQuestion < questionItems.size()-1){
                    currentQuestion++;
                    setQuestionScreen(currentQuestion);
                } else {
                    Intent intent = new Intent(getApplicationContext(), EndActivity.class);

                    if ((points >= 0) && (points <= 30))
                        intent.putExtra("result", "Низкая тревожность");
                    else
                    if ((points > 30) && (points <= 45))
                        intent.putExtra("result", "Умеренная тревожность");
                    else
                        intent.putExtra("result", "Высокая тревожность");

                    startActivity(intent);
                    finish();
                }
            }
        });

        button_D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                points = questionItems.get(currentQuestion).getScoreD() + points;

                //load next question if any
                if (currentQuestion < questionItems.size()-1){
                    currentQuestion++;
                    setQuestionScreen(currentQuestion);
                } else {
                    Intent intent = new Intent(getApplicationContext(), EndActivity.class);

                    if ((points >= 0) && (points <= 30))
                        intent.putExtra("result", "Низкая тревожность");
                    else
                    if ((points > 30) && (points <= 45))
                        intent.putExtra("result", "Умеренная тревожность");
                    else
                        intent.putExtra("result", "Высокая тревожность");

                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void setQuestionScreen(int number){
        question.setText(questionItems.get(number).getQuestion());
        count.setText((number+1) + "/" + questionItems.size());
        button_A.setText(questionItems.get(number).getAnswA());
        button_B.setText(questionItems.get(number).getAnswB());
        button_C.setText(questionItems.get(number).getAnswC());
        button_D.setText(questionItems.get(number).getAnswD());
    }

    private void loadAllQuestions(){
        questionItems = new ArrayList<>();

        //load all questions into json string
        String jsonStr = loadJSONFromAssert("spilberg_test");

        //load all data into list
        try{
            JSONObject jsonObj = new JSONObject(jsonStr);
            JSONArray questions = jsonObj.getJSONArray("questions");

            for (int i = 0; i < questions.length(); i++){
                String answerAString, answerBString, answerCString, answerDString;
                Integer scoreAString, scoreBString, scoreCString, scoreDString;

                JSONObject question = questions.getJSONObject(i);
                JSONObject ansA, ansB, ansC, ansD;
                ansA = question.getJSONObject("A");
                ansB = question.getJSONObject("B");
                ansC = question.getJSONObject("C");
                ansD = question.getJSONObject("D");


                String questionString = question.getString("question");

                answerAString = ansA.getString("answer");
                scoreAString = ansA.getInt("score");

                answerBString = ansB.getString("answer");
                scoreBString = ansB.getInt("score");

                answerCString = ansC.getString("answer");
                scoreCString = ansC.getInt("score");

                answerDString = ansD.getString("answer");
                scoreDString = ansD.getInt("score");

                questionItems.add(new QuestionItem(
                        questionString,
                        answerAString,
                        answerBString,
                        answerCString,
                        answerDString,
                        scoreAString,
                        scoreBString,
                        scoreCString,
                        scoreDString
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
