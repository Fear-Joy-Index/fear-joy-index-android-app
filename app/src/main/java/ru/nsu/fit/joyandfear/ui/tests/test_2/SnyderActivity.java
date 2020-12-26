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

import ru.nsu.fit.joyandfear.R;
import ru.nsu.fit.joyandfear.ui.tests.EndActivity;
import ru.nsu.fit.joyandfear.ui.tests.question_item.QuestionItem2;

public class SnyderActivity extends AppCompatActivity {

    TextView question, count;
    Button button_A, button_B;


    List<QuestionItem2> questionItem2s;
    int currentQuestion = 0;
    int points = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_2);

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

                if ((points >= 0) && (points <= 3))
                    intent.putExtra("result", "У Вас низкий коммуникативный контроль. Ваше поведение устойчиво, и Вы не считаете нужным изменяться в зависимости от ситуаций. Вы способны к искреннему самораскрытию в общении. Некоторые считают Вас неудобным в общении по причине вашей прямолинейности.");
                else
                if ((points >= 4) && (points <= 6))
                    intent.putExtra("result", "У Вас средний коммуникативный контроль, вы искренни, но не сдержанны в своих эмоциональных проявлениях, считаетесь в своем поведении с окружающими людьми.");
                else
                    intent.putExtra("result", "У вас депрессивное расстройство средней степени тяжести.");

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

                if ((points >= 0) && (points <= 3))
                    intent.putExtra("result", "У Вас низкий коммуникативный контроль. Ваше поведение устойчиво, и Вы не считаете нужным изменяться в зависимости от ситуаций. Вы способны к искреннему самораскрытию в общении. Некоторые считают Вас неудобным в общении по причине вашей прямолинейности.");
                else
                if ((points >= 4) && (points <= 6))
                    intent.putExtra("result", "У Вас средний коммуникативный контроль, вы искренни, но не сдержанны в своих эмоциональных проявлениях, считаетесь в своем поведении с окружающими людьми.");
                else
                    intent.putExtra("result", "У вас депрессивное расстройство средней степени тяжести.");

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

        //load all questions into json string
        String jsonStr = loadJSONFromAssert("snyder_test");

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
