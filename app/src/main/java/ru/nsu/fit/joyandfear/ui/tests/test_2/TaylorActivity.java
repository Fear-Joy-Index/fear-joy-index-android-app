package ru.nsu.fit.joyandfear.ui.tests.test_2;

import android.content.Intent;
import android.os.Bundle;
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
import java.util.Objects;

import ru.nsu.fit.joyandfear.R;
import ru.nsu.fit.joyandfear.ui.tests.EndActivity;
import ru.nsu.fit.joyandfear.ui.tests.question_item.QuestionItem2;

public class TaylorActivity extends AppCompatActivity {

    TextView question, count;
    Button button_A, button_B;


    List<QuestionItem2> questionItem2s;
    int currentQuestion = 0;
    int points = 0;
    String small = "1";

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Intent intent1 = getIntent();
        String name_test = intent1.getStringExtra("name_test");

        setContentView(R.layout.activity_test_2);

        Objects.requireNonNull(getSupportActionBar()).setTitle(name_test);

        question = findViewById(R.id.question_view);
        button_A = findViewById(R.id.button_A);
        button_B = findViewById(R.id.button_B);

        count = findViewById(R.id.count_view);

        loadAllQuestions();
        setQuestionScreen(currentQuestion);

        button_A.setOnClickListener(view -> {
            points = questionItem2s.get(currentQuestion).getScoreA() + points;

            //load next question if any
            if (currentQuestion < questionItem2s.size()-1){
                currentQuestion++;
                setQuestionScreen(currentQuestion);
            } else {
                Intent intent = new Intent(getApplicationContext(), EndActivity.class);

                if ((points >= 0) && (points <= 5)) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                        intent.putExtra("result", "У вас низкий уровень тревоги");
                    else
                        intent.putExtra("result", "Low alarm level");
                }else
                if ((points >= 6) && (points <= 15)) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                        intent.putExtra("result", "У вас средний (с тенденцией к низкому) уровень тревоги");
                    else
                        intent.putExtra("result", "Medium (with a tendency to low) level");
                }else
                if ((points >= 16) && (points <= 25)) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                        intent.putExtra("result", "У вас средний (с тенденцией к высокому) уровень тревоги");
                    else
                        intent.putExtra("result", "Average (with a tendency to high) level");
                }else
                if ((points >= 26) && (points <= 40)) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                        intent.putExtra("result", "У вас высокий уровень тревоги");
                    else
                        intent.putExtra("result", "High levels of anxiety");
                }else {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                        intent.putExtra("result", "У вас очень высокий уровень тревоги");
                    else
                        intent.putExtra("result", "Very high levels of anxiety");
                }

                intent.putExtra("small", small);
                startActivity(intent);
                finish();
            }
        });

        button_B.setOnClickListener(view -> {
            points = questionItem2s.get(currentQuestion).getScoreB() + points;
            //load next question if any
            if (currentQuestion < questionItem2s.size()-1){
                currentQuestion++;
                setQuestionScreen(currentQuestion);
            } else {
                Intent intent = new Intent(getApplicationContext(), EndActivity.class);

                if ((points >= 0) && (points <= 5))
                    intent.putExtra("result", "У вас низкий уровень тревоги");
                else
                if ((points >= 6) && (points <= 15))
                    intent.putExtra("result", "У вас средний (с тенденцией к низкому) уровень тревоги");
                else
                if ((points >= 16) && (points <= 25))
                    intent.putExtra("result", "У вас средний (с тенденцией к высокому) уровень тревоги");
                else
                if ((points >= 26) && (points <= 40))
                    intent.putExtra("result", "У вас высокий уровень тревоги");
                else
                    intent.putExtra("result", "У вас очень высокий уровень тревоги");

                intent.putExtra("small", small);
                startActivity(intent);
                finish();
            }
        });

    }

    private void setQuestionScreen(int number){
        question.setText(questionItem2s.get(number).getQuestion());
        count.setText((number+1) + "/" + questionItem2s.size());
        button_A.setText(questionItem2s.get(number).getAnswA());
        button_B.setText(questionItem2s.get(number).getAnswB());
    }

    private void loadAllQuestions(){
        questionItem2s = new ArrayList<>();

        String jsonStr;
        //load all questions into json string
        if (getResources().getConfiguration().locale.getLanguage().equals("ru")){
            jsonStr = loadJSONFromAssert("ru/taylor_test");
        }
        else {
            jsonStr = loadJSONFromAssert("en/taylor_test_en");
        }

        //load all data into list
        try{
            JSONObject jsonObj = new JSONObject(jsonStr);
            JSONArray questions = jsonObj.getJSONArray("questions");

            for (int i = 0; i < questions.length(); i++){
                String answerAString, answerBString;
                Integer scoreAString, scoreBString;

                JSONObject question = questions.getJSONObject(i);
                JSONObject ansA, ansB, ansC, ansD;
                ansA = question.getJSONObject("A");
                ansB = question.getJSONObject("B");


                String questionString = question.getString("question");
                //???????????????????????????????????????????????????????????????
                answerAString = ansA.getString("answer");
                scoreAString = ansA.getInt("score");

                answerBString = ansB.getString("answer");
                scoreBString = ansB.getInt("score");


                questionItem2s.add(new QuestionItem2(
                        questionString,
                        answerAString,
                        answerBString,
                        scoreAString,
                        scoreBString
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
