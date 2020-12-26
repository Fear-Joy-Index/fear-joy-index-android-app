package ru.nsu.fit.joyandfear.ui.tests;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import ru.nsu.fit.joyandfear.EmotionActivity;
import ru.nsu.fit.joyandfear.MainActivity;
import ru.nsu.fit.joyandfear.R;
import ru.nsu.fit.joyandfear.databinding.FragmentTestsBinding;

public class TestsFragment extends Fragment {
    private Button bt1, bt2, bt3, bt4, bt5, bt6, bt7;


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


        bt1.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), StartActivity.class);
            intent.putExtra("name", bt1.getText().toString());
            intent.putExtra("text", "Внимательно прочитайте каждое утверждение и выбирете то утверждение, которое лучше всего описывает как часто вы чувствовали или вели себя соответствующим образом в течение последней недели. Не размышляйтеслишком долго,  в тесте  нет  «правильных» или «неправильных» ответов");
            startActivity(intent);
        });

        bt2.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), StartActivity.class);
            intent.putExtra("name", bt2.getText().toString());
            intent.putExtra("text", "Прочитайте внимательно каждое из приведенных предложений и выбирете соответствующий вариант в зависимости от того как вы себя чувствуете в данный момент");
            startActivity(intent);
        });

        bt3.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), StartActivity.class);
            intent.putExtra("name", bt3.getText().toString());
            intent.putExtra("text", "Методика Шкала депрессии Бека используется для диагностики уровня депрессии. Выберите одно утверждение в каждой группе, которое лучше всего описывает Ваше состояние за прошедшую неделю, включая сегодняшний день.");
            startActivity(intent);
        });

        bt4.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), StartActivity.class);
            intent.putExtra("name", bt4.getText().toString());
            intent.putExtra("text", "Bам будет задан ряд вопросов, на каждый из которых Вы должны выбрать один из трех предлагаемых ответов, - тот, который в наибольшей степени соответствует Вашим взглядам, Вашему мнению о себе. Обязательно отвечайте на все вопросы подряд, ничего не пропуская. Не нужно много времени тратить на обдумывание ответов. Давайте тот ответ, который первым приходит Вам в голову.\n\n Отвечать надо приблизительно на 5-6 вопросов за минуту. Заполнение всего опросника должно занять у Вас около 50 мин. Возможно, некоторые вопросы покажутся вам неясными или сформулированными не так подробно, как Вам хотелось бы. В таких случаях, отвечая, старайтесь представить среднюю, наиболее обычную ситуацию, которая соответствует смыслу вопроса, и на основе этого выбирайте свой ответ. Старайтесь не прибегать слишком часто к промежуточным, неопределенным ответам, типа не знаю, нечто среднее и т.п.\n\n Отвечайте честно и искренне. Не стремитесь произвести хорошее впечатление своими ответами. Здесь не может быть ответов правильных или ошибочных. Люди различны, и каждый может высказать свое мнение. Ваши ответы должны соответствовать действительности - в этом случае Вы сможете лучше узнать себя.");
            startActivity(intent);
        });

        bt5.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), StartActivity.class);
            intent.putExtra("name", bt5.getText().toString());
            intent.putExtra("text", "Опросник для оценки уровня тревожности Тейлора (адаптация Т.А.  Немчинова) состоит из 50 утверждений. Тестирование продолжается  15-30 минут. Вы должны ответить «Да» или  «Нет», в  зависимости от того, согласны или не согласны с утверждениями.");
            startActivity(intent);
        });

        bt6.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), StartActivity.class);
            intent.putExtra("name", bt6.getText().toString());
            intent.putExtra("text", "Внимательно прочтите десять предложений, описывающих реакции на некоторые ситуации. Каждое из них Вы должны оценить как верное или неверное применительно к себе. Если предложение кажется вам верным или преимущественно верным, то выбирете вариант Верно, если неверным или преимущественно неверным - Неверно");
            startActivity(intent);
        });

        bt7.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), StartActivity.class);
            intent.putExtra("name", bt7.getText().toString());
            intent.putExtra("text", "В течение последней недели насколько Вас беспокоили...");
            startActivity(intent);
        });


        return v;
    }

}