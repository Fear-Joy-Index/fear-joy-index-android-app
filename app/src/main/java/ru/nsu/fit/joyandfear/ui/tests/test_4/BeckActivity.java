package ru.nsu.fit.joyandfear.ui.tests.test_4;

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
import java.util.Objects;

import ru.nsu.fit.joyandfear.R;
import ru.nsu.fit.joyandfear.ui.tests.EndActivity;
import ru.nsu.fit.joyandfear.ui.tests.question_item.QuestionItem4;

public class BeckActivity extends AppCompatActivity {

    TextView question, count;
    Button button_A, button_B, button_C, button_D;


    List<QuestionItem4> questionItem4s;
    int currentQuestion = 0;
    int points = 0;
    String small = "1";

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Intent intent1 = getIntent();
        String name_test = intent1.getStringExtra("name_test");

        setContentView(R.layout.activity_test_4);

        Objects.requireNonNull(getSupportActionBar()).setTitle(name_test);

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
                points = questionItem4s.get(currentQuestion).getScoreA() + points;

                //load next question if any
                if (currentQuestion < questionItem4s.size()-1){
                    currentQuestion++;
                    setQuestionScreen(currentQuestion);
                } else {
                    Intent intent = new Intent(getApplicationContext(), EndActivity.class);

                    if ((points >= 0) && (points <= 9)) {
                        if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                            intent.putExtra("result", "У вас отсутствуют депрессивные симптомы.");
                        else
                            intent.putExtra("result", "The absence of depressive symptoms.");
                    }else
                    if ((points >= 10) && (points <= 18)) {
                        if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                            intent.putExtra("result", "У вас легкая депрессия, астено-субдепрессивная симптоматика, может быть у соматических больных или невротический уровень.");
                        else
                            intent.putExtra("result", "Mild depression, asthenic-subdepressive symptoms, M. B. in somatic patients or neurotic level.");
                    }else
                    if ((points >= 19) && (points <= 29)) {
                        if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                            intent.putExtra("result", "У вас умеренная депрессия, критический уровень.");
                        else
                            intent.putExtra("result", "Moderate depression, critical level.");
                    }else {
                        if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                            intent.putExtra("result", "У вас явно выраженная депрессивная симптоматика, не исключена эндогенность.");
                        else
                            intent.putExtra("result", "Clearly expressed depressive symptoms, endogeneity is not excluded.");
                    }
                    intent.putExtra("small", small);
                    startActivity(intent);
                    finish();
                }
            }
        });

        button_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                points = questionItem4s.get(currentQuestion).getScoreB() + points;
                //load next question if any
                if (currentQuestion < questionItem4s.size()-1){
                    currentQuestion++;
                    setQuestionScreen(currentQuestion);
                } else {
                    Intent intent = new Intent(getApplicationContext(), EndActivity.class);

                    if ((points >= 0) && (points <= 9)) {
                        if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                            intent.putExtra("result", "У вас отсутствуют депрессивные симптомы.");
                        else
                            intent.putExtra("result", "The absence of depressive symptoms.");
                    }else
                    if ((points >= 10) && (points <= 18)) {
                        if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                            intent.putExtra("result", "У вас легкая депрессия, астено-субдепрессивная симптоматика, может быть у соматических больных или невротический уровень.");
                        else
                            intent.putExtra("result", "Mild depression, asthenic-subdepressive symptoms, M. B. in somatic patients or neurotic level.");
                    }else
                    if ((points >= 19) && (points <= 29)) {
                        if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                            intent.putExtra("result", "У вас умеренная депрессия, критический уровень.");
                        else
                            intent.putExtra("result", "Moderate depression, critical level.");
                    }else {
                        if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                            intent.putExtra("result", "У вас явно выраженная депрессивная симптоматика, не исключена эндогенность.");
                        else
                            intent.putExtra("result", "Clearly expressed depressive symptoms, endogeneity is not excluded.");
                    }
                    intent.putExtra("small", small);
                    startActivity(intent);
                    finish();
                }
            }
        });

        button_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                points = questionItem4s.get(currentQuestion).getScoreC() + points;

                //load next question if any
                if (currentQuestion < questionItem4s.size()-1){
                    currentQuestion++;
                    setQuestionScreen(currentQuestion);
                } else {
                    Intent intent = new Intent(getApplicationContext(), EndActivity.class);

                    if ((points >= 0) && (points <= 9)) {
                        if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                            intent.putExtra("result", "У вас отсутствуют депрессивные симптомы.");
                        else
                            intent.putExtra("result", "The absence of depressive symptoms.");
                    }else
                    if ((points >= 10) && (points <= 18)) {
                        if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                            intent.putExtra("result", "У вас легкая депрессия, астено-субдепрессивная симптоматика, может быть у соматических больных или невротический уровень.");
                        else
                            intent.putExtra("result", "Mild depression, asthenic-subdepressive symptoms, M. B. in somatic patients or neurotic level.");
                    }else
                    if ((points >= 19) && (points <= 29)) {
                        if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                            intent.putExtra("result", "У вас умеренная депрессия, критический уровень.");
                        else
                            intent.putExtra("result", "Moderate depression, critical level.");
                    }else {
                        if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                            intent.putExtra("result", "У вас явно выраженная депрессивная симптоматика, не исключена эндогенность.");
                        else
                            intent.putExtra("result", "Clearly expressed depressive symptoms, endogeneity is not excluded.");
                    }
                    intent.putExtra("small", small);
                    startActivity(intent);
                    finish();
                }
            }
        });

        button_D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                points = questionItem4s.get(currentQuestion).getScoreD() + points;

                //load next question if any
                if (currentQuestion < questionItem4s.size()-1){
                    currentQuestion++;
                    setQuestionScreen(currentQuestion);
                } else {
                    Intent intent = new Intent(getApplicationContext(), EndActivity.class);

                    if ((points >= 0) && (points <= 9)) {
                        if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                            intent.putExtra("result", "У вас отсутствуют депрессивные симптомы.");
                        else
                            intent.putExtra("result", "The absence of depressive symptoms.");
                    }else
                    if ((points >= 10) && (points <= 18)) {
                        if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                            intent.putExtra("result", "У вас легкая депрессия, астено-субдепрессивная симптоматика, может быть у соматических больных или невротический уровень.");
                        else
                            intent.putExtra("result", "Mild depression, asthenic-subdepressive symptoms, M. B. in somatic patients or neurotic level.");
                    }else
                    if ((points >= 19) && (points <= 29)) {
                        if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                            intent.putExtra("result", "У вас умеренная депрессия, критический уровень.");
                        else
                            intent.putExtra("result", "Moderate depression, critical level.");
                    }else {
                        if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                            intent.putExtra("result", "У вас явно выраженная депрессивная симптоматика, не исключена эндогенность.");
                        else
                            intent.putExtra("result", "Clearly expressed depressive symptoms, endogeneity is not excluded.");
                    }
                    intent.putExtra("small", small);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void setQuestionScreen(int number){
        question.setText(questionItem4s.get(number).getQuestion());
        count.setText((number+1) + "/" + questionItem4s.size());
        button_A.setText(questionItem4s.get(number).getAnswA());
        button_B.setText(questionItem4s.get(number).getAnswB());
        button_C.setText(questionItem4s.get(number).getAnswC());
        button_D.setText(questionItem4s.get(number).getAnswD());
    }

    private void loadAllQuestions(){
        questionItem4s = new ArrayList<>();
        String jsonStr;
        //load all questions into json string
        if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
            jsonStr = loadJSONFromAssert("ru/beck_test");
        else
            jsonStr = loadJSONFromAssert("en/beck_test_en");

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

                questionItem4s.add(new QuestionItem4(
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
