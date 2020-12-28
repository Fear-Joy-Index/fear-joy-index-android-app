package ru.nsu.fit.joyandfear.ui.tests;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ru.nsu.fit.joyandfear.R;

public class TestsFragment extends Fragment {
    private Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_tests, container, false);

        bt1 = v.findViewById(R.id.button_1);
        bt2 = v.findViewById(R.id.button_2);
        bt3 = v.findViewById(R.id.button_3);
        bt4 = v.findViewById(R.id.button_4);
        bt5 = v.findViewById(R.id.button_5);
        bt6 = v.findViewById(R.id.button_6);
        bt7 = v.findViewById(R.id.button_7);
        bt8 = v.findViewById(R.id.button_8);


        bt1.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), StartActivity.class);
            intent.putExtra("name", bt1.getText().toString());
            if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                intent.putExtra("text", "Тест показывает ваш уровень депрессии. Внимательно прочитайте каждое утверждение и выбирете то утверждение, которое лучше всего описывает как часто вы чувствовали или вели себя соответствующим образом в течение последней недели. Не размышляйтеслишком долго,  в тесте  нет  «правильных» или «неправильных» ответов.");
            if (getResources().getConfiguration().locale.getLanguage().equals("en"))
                intent.putExtra("text", "The Zung Self-Rating Depression Scale was designed by Duke University psychiatrist William W.K. Zung MD (1929–1992) to assess the level of depression for patients diagnosed with depressive disorder. For each item below, please check the column which best describes how often you felt or behaved this way during the past several days.");
            startActivity(intent);
        });

        bt2.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), StartActivity.class);
            intent.putExtra("name", bt2.getText().toString());
            if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                intent.putExtra("text", "Данный тест является информативным способом самооценки уровня тревожности в данный момент (реактивная тревожность, как состояние) и личностной тревожности (как устойчивая характеристика человека)." +
                    "\n\nПрочитайте внимательно каждое из приведенных предложений и выбирете соответствующий вариант в зависимости от того как вы себя чувствуете в данный момент");
            if (getResources().getConfiguration().locale.getLanguage().equals("en"))
                intent.putExtra("text", "Read each statement and select the appropriate response to indicate how you feel right now, that is, at this very moment. There are no right or wrong answers. Do not spend too much time on any one statement but give the answer which seems to describe your present feelings best.");

            startActivity(intent);
        });

        bt3.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), StartActivity.class);
            intent.putExtra("name", bt3.getText().toString());
            if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
            intent.putExtra("text", "Методика Шкала депрессии Бека используется для диагностики уровня депрессии. Выберите одно утверждение в каждой группе, которое лучше всего описывает Ваше состояние за прошедшую неделю, включая сегодняшний день.");
            if (getResources().getConfiguration().locale.getLanguage().equals("en"))
                intent.putExtra("text", "The Beck Depression Inventory (BDI) is a 21-item, self-report rating inventory that measures characteristic attitudes and symptoms of depression). Please read the following carefully and select the one that best describes your health during the past two weeks, including today.");
            startActivity(intent);
        });

        bt4.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), StartActivity.class);
            intent.putExtra("name", bt4.getText().toString());
            if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                intent.putExtra("text", "Тест  дает  возможность определить  уровень  коммуникабельности  человека. \n\nВнимательно прочитайте каждое утверждение и поставьте отметку в графе, которая лучше всего описывает то,  как часто вы чувствовали или вели себя соответствующим образом в течение последней недели. Не размышляйте слишком долго,  в тесте  нет  «правильных» или «неправильных» ответов.");
            if (getResources().getConfiguration().locale.getLanguage().equals("en"))
                intent.putExtra("text", "Test for identifying communicative abilities Test for determining the level of sociability.\n\n Sociability— necessary quality in communication. Check how developed it is with you and what you need to improve your own communication technique. Answer the questions 'yes', 'sometimes' or 'no'.");

            startActivity(intent);
        });

        bt5.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), StartActivity.class);
            intent.putExtra("name", bt5.getText().toString());
            if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                intent.putExtra("text", "Опросник для оценки уровня тревожности Тейлора (адаптация Т.А.  Немчинова) состоит из 50 утверждений. Тестирование продолжается  15-30 минут. Вы должны ответить «Да» или  «Нет», в  зависимости от того, согласны или не согласны с утверждениями.");
            if (getResources().getConfiguration().locale.getLanguage().equals("en"))
                intent.putExtra("text", "The questionnaire for assessing the level of Taylor's anxiety (adapted by T. A. Nemchinov) consists of 50 statements. Mark the statements you agree with.");
            startActivity(intent);
        });

        bt6.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), StartActivity.class);
            intent.putExtra("name", bt6.getText().toString());
            if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                intent.putExtra("text", "Тест разработан американским психологом М. Снайдером. Внимательно прочтите десять предложений, описывающих реакции на некоторые ситуации. Каждое из них Вы должны оценить как верное или неверное применительно к себе. Если предложение кажется вам верным или преимущественно верным, то выбирете вариант Верно, если неверным или преимущественно неверным - Неверно");
            if (getResources().getConfiguration().locale.getLanguage().equals("en"))
                intent.putExtra("text", "The test, developed by the American psychologist M. Snyder, is aimed at assessing self-control in communication. \n\nRead carefully the ten sentences describing the reactions to some situations. Each of these you must evaluate as true or incorrect in relation to yourself.");
            startActivity(intent);
        });

        bt7.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), StartActivity.class);
            intent.putExtra("name", bt7.getText().toString());
            if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                intent.putExtra("text", "В течение последней недели насколько Вас беспокоили...");
            if (getResources().getConfiguration().locale.getLanguage().equals("en"))
                intent.putExtra("text", "During the past week, how much did you suffer from ... (Check only one answer for each question)");
            startActivity(intent);
        });

        bt8.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), StartActivity.class);
            intent.putExtra("name", bt8.getText().toString());
            if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                intent.putExtra("text", "Исследование уровня эмпатийных тенденций. Оцените предлагаемые утверждения по пятибальной шкале.");
            if (getResources().getConfiguration().locale.getLanguage().equals("en"))
                intent.putExtra("text", "Study of the level of empathic tendencies. Rate the proposed statements on a five-point scale.");
            startActivity(intent);
        });


        return v;
    }

}