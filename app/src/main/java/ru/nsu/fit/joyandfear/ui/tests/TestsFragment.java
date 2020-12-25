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
    private Button bt1, bt2, bt3;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tests, container, false);
        bt1 = v.findViewById(R.id.button_1);
        bt2 = v.findViewById(R.id.button_2);
        bt3 = v.findViewById(R.id.button_3);


        bt1.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), StartActivity.class);
            intent.putExtra("name", "Шкала Зунга");
            intent.putExtra("text", "Внимательно прочитайте каждое утверждение и выбирете то утверждение, которое лучше всего описывает как часто вы чувствовали или вели себя соответствующим образом в течение последней недели. Не размышляйтеслишком долго,  в тесте  нет  «правильных» или «неправильных» ответов");
            startActivity(intent);
        });

        bt2.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), StartActivity.class);
            intent.putExtra("name", "Шкала самооценки тревоги Спилбера-Ханина");
            intent.putExtra("text", "Прочитайте внимательно каждое из приведенных предложений и выбирете соответствующий вариант в зависимости от того как вы себя чувствуете в данный момент");
            startActivity(intent);
        });

        bt3.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), StartActivity.class);
            intent.putExtra("name", "Шкала депрессии Бека");
            intent.putExtra("text", "Методика Шкала депрессии Бека используется для диагностики уровня депрессии. Выберите одно утверждение в каждой группе, которое лучше всего описывает Ваше состояние за прошедшую неделю, включая сегодняшний день.");
            startActivity(intent);
        });


        return v;
    }

}