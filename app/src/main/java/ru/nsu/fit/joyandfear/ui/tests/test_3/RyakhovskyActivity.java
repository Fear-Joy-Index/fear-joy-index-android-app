package ru.nsu.fit.joyandfear.ui.tests.test_3;

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
import ru.nsu.fit.joyandfear.ui.tests.EndActivity;
import ru.nsu.fit.joyandfear.ui.tests.question_item.QuestionItem3;

public class RyakhovskyActivity extends AppCompatActivity {

    TextView question, count;
    Button button_A, button_B, button_C;


    List<QuestionItem3> questionItem3s;
    int currentQuestion = 0;
    int points = 0;
    String small = "0";

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Intent intent1 = getIntent();
        String name_test = intent1.getStringExtra("name_test");

        setContentView(R.layout.activity_test_3);

        Objects.requireNonNull(getSupportActionBar()).setTitle(name_test);

        question = findViewById(R.id.question_view);
        button_A = findViewById(R.id.button_A);
        button_B = findViewById(R.id.button_B);
        button_C = findViewById(R.id.button_C);

        count = findViewById(R.id.count_view);

        loadAllQuestions();
        setQuestionScreen(currentQuestion);

        button_A.setOnClickListener(view -> {
            points = questionItem3s.get(currentQuestion).getScoreA() + points;

            //load next question if any
            if (currentQuestion < questionItem3s.size()-1){
                currentQuestion++;
                setQuestionScreen(currentQuestion);
            } else {
                Intent intent = new Intent(getApplicationContext(), EndActivity.class);

                if ((points >= 30) && (points <= 31)) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                        intent.putExtra("result", "Вы явно некоммуникабельны, и эта ваша беда, так как больше всего страдаете от этого вы сами. Но и близким вам людям нелегко. На вас трудно положиться в деле, которое требует групповых усилий. Старайтесь быть общительнее, контролируйте себя.");
                    else
                        intent.putExtra("result", "You are clearly uncommunicative, and this is your problem, since you yourself suffer the most from this. But it is not easy for people close to you. You are difficult to rely on in a group effort. Try to be more sociable, control yourself.");
                }else
                if ((points >= 25) && (points <= 29)) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                        intent.putExtra("result", "Вы замкнуты, неразговорчивы, предпочитаете одиночество, поэтому у вас мало друзей. Новая работа и необходимость новых контактов если не ввергают вас в панику, то надолго выводят из равновесия. Вы знаете эту особенность своего характера и бываете  не  довольны  собой.  Но  не  ограничивайтесь  только  таким  недовольством –в вашей власти переломит эти особенности характера. Разве не бывает, что при какой-либо сильной увлеченности вы приобретаете вдруг полную коммуникабельность? Стоит только встряхнуться.");
                    else
                        intent.putExtra("result", "You are closed, taciturn, prefer lonely honor, so you have few friends. New job and the need for new contacts, if they do not plunge you into a panic, then for a long time unbalance. You know this feature of your character and are not are free with themselves. But do not limit yourself to just such discontent - inyour power to reverse these character traits. Doesn't it happen that with any strong passion you suddenly acquire sexgood communication skills? One has only to shake things up.");
                }else
                if ((points >= 19) && (points <= 24)) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                        intent.putExtra("result", "Вы  в  известной  степени  общительны  и  внезнакомой  обстановке чувствуете  себя  вполне  уверенно.  Новые  проблемы  вас  не  пугают.  И  все  же  с  новыми людьми  сходитесь  с  оглядкой,  в  спорах  и  диспутах  участвуют  неохотно.  В  ваших высказываниях  порой слишком  много  сарказма,  без  всякого  на  то  основания.  Эти недостатки исправимы.");
                    else
                        intent.putExtra("result", "You are somewhat sociable and unfamiliar the situation you feel quite confident. New problems don't scare you. And yet you converge with new people with a glance, in disputes and disputes you are reluctant to participate. In your statements, sometimes there are too many sarcasm, without any reason. These flaws are fixable.");
                }else
                if ((points >= 14) && (points <= 28)) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                        intent.putExtra("result", "У вас нормальная коммуникабельность. Вы любознательны, охотно слушаете интересного собеседника, достаточно терпеливы в общении, отстаиваете свою точку зрения без вспыльчивости. Без неприятных переживаний идете на встречу с новыми людьми.  В  то  же  время  не  любите  шумных  компаний;  экстравагантные  выходки  и многословие вызывают у вас раздражение.");
                    else
                        intent.putExtra("result", "You have normal communication skills. You are curious are willing to listen to an interesting interlocutor, rather patient livable in communication, defend your point of view without irascibility.Without unpleasant experiences go to meet new people. At that time do not like noisy companies; extravagant antics and a lot the word annoys you.");
                }else
                if ((points >= 9) && (points <= 13)) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                        intent.putExtra("result", "Вы  весьма  общительны  (порой,  быть  может,  даже  сверх  меры). Любопытны,  разговорчивы,  любите  высказываться  по  разным  вопросам,  что,  бывает, вызывает  раздражение  окружающих.  Охотно  знакомитесь  с  новыми  людьми.  Любите бывать в центре внимания, никому не отказываете в просьбах, хотя не всегда можете их выполнить.  Бывает,  вспылите,  но  быстро  отходите.  Чего  вам  недостает,  так  это усидчивости,  терпения  и  отваги  при  столкновении  с  серьезными  проблемами.  При желании, однако, вы можете себя заставить не отступать.");
                    else
                        intent.putExtra("result", "You are very sociable (sometimes, perhaps even over measures). Curious, talkative, like to speak up on different issues dew, which sometimes irritates others. Willingly familiar hang out with new people. Love to be in the spotlight, no one refuse requests, although you cannot always fulfill them. It happens,flare up, but back away quickly. What you lack is perseverance,patience and courage when faced with serious problems.When desire, however, you can force yourself not to back down.");
                }else
                if ((points >= 4) && (points <= 8)) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                        intent.putExtra("result", "Вы, должно быть, «рубаха-парень». Общительность бьет из вас ключом. Вы  всегда  в  курсе  всех  дел.  Вы  любите  принимать  участие  во  всех  дискуссиях,  хотя серьезные темы могут вызывать у вас мигрень или даже хандру. Охотно берете слово по любому  вопросу,  даже  если  имеете  о  нем  поверхностное  представление.  Всюду чувствуетесебя в свой тарелке. Беретесь за любое дело, хотя не всегда можете успешно довести его до конца. По этой самой причине руководители и коллеги относятся к вам с некоторой опаской и сомнениями. Задумайтесь над этими фактами.");
                    else
                        intent.putExtra("result", "You must be a shirt-guy. Sociability beats outwith the key. You are always aware of all matters. You love to take part in all discussions, although serious topics may give you migraines or even blues. You are willing to take the floor on any issue, even if you have a superficial understanding of it. You feel at ease everywhere. Take on any business, although you cannot always successfully bring it to end. For this very reason, leaders and colleagues treat you with some apprehension and doubt. Consider these facts.");
                }else {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                        intent.putExtra("result", "Ваша  коммуникабельность  носит  болезненный  характер.  Вы говорливы,  многословны,  вмешиваетесь  в  дела,  которые  не  имеют  к  вам никакогоотношения.  Беретесь  судить  о  проблемах,  в  к  которых  совершенно  не  компетентны. Вольно  или  невольно  вы  часто  бываете  причиной  разного  рода  конфликтов  в  вашем окружении. Вспыльчивы, обидчивы, нередко бываете необъективны. Серьезная работа не для вас. Людям –и на работе, и дома, и вообще повсюду –трудно с вами. Да, вам надо поработать  над  собой  и  своим  характером!  Прежде  всего  воспитывайте  в  себе терпеливость  и  сдержанность,  уважительно  относитесь  к  людям,  наконец,  подумайте  о своем здоровье –такой стиль жизни не проходит бесследно.");
                    else
                        intent.putExtra("result", "Your communication skills are painful.ter. You are talkative, verbose, intervene in matters that you do not have they have nothing to do with you. You take to judge the problems in which completely incompetent. Whether you want to or not, you often come across the rank of all sorts of conflicts in your environment. Hot-tempered, resent mentare often biased. Serious work is not for you. Liudyam - and at work, and at home, and in general everywhere - it is difficult with you. Yes, you need to work on yourself and your character! First of all, raised have patience and restraint, respect people, finally, think about your health - this lifestyle is not passes without a trace.");
                }
                intent.putExtra("small", small);
                startActivity(intent);
                finish();
            }
        });

        button_B.setOnClickListener(view -> {
            points = questionItem3s.get(currentQuestion).getScoreB() + points;
            //load next question if any
            if (currentQuestion < questionItem3s.size()-1){
                currentQuestion++;
                setQuestionScreen(currentQuestion);
            } else {
                Intent intent = new Intent(getApplicationContext(), EndActivity.class);

                if ((points >= 30) && (points <= 31)) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                        intent.putExtra("result", "Вы явно некоммуникабельны, и эта ваша беда, так как больше всего страдаете от этого вы сами. Но и близким вам людям нелегко. На вас трудно положиться в деле, которое требует групповых усилий. Старайтесь быть общительнее, контролируйте себя.");
                    else
                        intent.putExtra("result", "You are clearly uncommunicative, and this is your problem, since you yourself suffer the most from this. But it is not easy for people close to you. You are difficult to rely on in a group effort. Try to be more sociable, control yourself.");
                }else
                if ((points >= 25) && (points <= 29)) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                        intent.putExtra("result", "Вы замкнуты, неразговорчивы, предпочитаете одиночество, поэтому у вас мало друзей. Новая работа и необходимость новых контактов если не ввергают вас в панику, то надолго выводят из равновесия. Вы знаете эту особенность своего характера и бываете  не  довольны  собой.  Но  не  ограничивайтесь  только  таким  недовольством –в вашей власти переломит эти особенности характера. Разве не бывает, что при какой-либо сильной увлеченности вы приобретаете вдруг полную коммуникабельность? Стоит только встряхнуться.");
                    else
                        intent.putExtra("result", "You are closed, taciturn, prefer lonely honor, so you have few friends. New job and the need for new contacts, if they do not plunge you into a panic, then for a long time unbalance. You know this feature of your character and are not are free with themselves. But do not limit yourself to just such discontent - inyour power to reverse these character traits. Doesn't it happen that with any strong passion you suddenly acquire sexgood communication skills? One has only to shake things up.");
                }else
                if ((points >= 19) && (points <= 24)) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                        intent.putExtra("result", "Вы  в  известной  степени  общительны  и  внезнакомой  обстановке чувствуете  себя  вполне  уверенно.  Новые  проблемы  вас  не  пугают.  И  все  же  с  новыми людьми  сходитесь  с  оглядкой,  в  спорах  и  диспутах  участвуют  неохотно.  В  ваших высказываниях  порой слишком  много  сарказма,  без  всякого  на  то  основания.  Эти недостатки исправимы.");
                    else
                        intent.putExtra("result", "You are somewhat sociable and unfamiliar the situation you feel quite confident. New problems don't scare you. And yet you converge with new people with a glance, in disputes and disputes you are reluctant to participate. In your statements, sometimes there are too many sarcasm, without any reason. These flaws are fixable.");
                }else
                if ((points >= 14) && (points <= 28)) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                        intent.putExtra("result", "У вас нормальная коммуникабельность. Вы любознательны, охотно слушаете интересного собеседника, достаточно терпеливы в общении, отстаиваете свою точку зрения без вспыльчивости. Без неприятных переживаний идете на встречу с новыми людьми.  В  то  же  время  не  любите  шумных  компаний;  экстравагантные  выходки  и многословие вызывают у вас раздражение.");
                    else
                        intent.putExtra("result", "You have normal communication skills. You are curious are willing to listen to an interesting interlocutor, rather patient livable in communication, defend your point of view without irascibility.Without unpleasant experiences go to meet new people. At that time do not like noisy companies; extravagant antics and a lot the word annoys you.");
                }else
                if ((points >= 9) && (points <= 13)) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                        intent.putExtra("result", "Вы  весьма  общительны  (порой,  быть  может,  даже  сверх  меры). Любопытны,  разговорчивы,  любите  высказываться  по  разным  вопросам,  что,  бывает, вызывает  раздражение  окружающих.  Охотно  знакомитесь  с  новыми  людьми.  Любите бывать в центре внимания, никому не отказываете в просьбах, хотя не всегда можете их выполнить.  Бывает,  вспылите,  но  быстро  отходите.  Чего  вам  недостает,  так  это усидчивости,  терпения  и  отваги  при  столкновении  с  серьезными  проблемами.  При желании, однако, вы можете себя заставить не отступать.");
                    else
                        intent.putExtra("result", "You are very sociable (sometimes, perhaps even over measures). Curious, talkative, like to speak up on different issues dew, which sometimes irritates others. Willingly familiar hang out with new people. Love to be in the spotlight, no one refuse requests, although you cannot always fulfill them. It happens,flare up, but back away quickly. What you lack is perseverance,patience and courage when faced with serious problems.When desire, however, you can force yourself not to back down.");
                }else
                if ((points >= 4) && (points <= 8)) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                        intent.putExtra("result", "Вы, должно быть, «рубаха-парень». Общительность бьет из вас ключом. Вы  всегда  в  курсе  всех  дел.  Вы  любите  принимать  участие  во  всех  дискуссиях,  хотя серьезные темы могут вызывать у вас мигрень или даже хандру. Охотно берете слово по любому  вопросу,  даже  если  имеете  о  нем  поверхностное  представление.  Всюду чувствуетесебя в свой тарелке. Беретесь за любое дело, хотя не всегда можете успешно довести его до конца. По этой самой причине руководители и коллеги относятся к вам с некоторой опаской и сомнениями. Задумайтесь над этими фактами.");
                    else
                        intent.putExtra("result", "You must be a shirt-guy. Sociability beats outwith the key. You are always aware of all matters. You love to take part in all discussions, although serious topics may give you migraines or even blues. You are willing to take the floor on any issue, even if you have a superficial understanding of it. You feel at ease everywhere. Take on any business, although you cannot always successfully bring it to end. For this very reason, leaders and colleagues treat you with some apprehension and doubt. Consider these facts.");
                }else {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                        intent.putExtra("result", "Ваша  коммуникабельность  носит  болезненный  характер.  Вы говорливы,  многословны,  вмешиваетесь  в  дела,  которые  не  имеют  к  вам никакогоотношения.  Беретесь  судить  о  проблемах,  в  к  которых  совершенно  не  компетентны. Вольно  или  невольно  вы  часто  бываете  причиной  разного  рода  конфликтов  в  вашем окружении. Вспыльчивы, обидчивы, нередко бываете необъективны. Серьезная работа не для вас. Людям –и на работе, и дома, и вообще повсюду –трудно с вами. Да, вам надо поработать  над  собой  и  своим  характером!  Прежде  всего  воспитывайте  в  себе терпеливость  и  сдержанность,  уважительно  относитесь  к  людям,  наконец,  подумайте  о своем здоровье –такой стиль жизни не проходит бесследно.");
                    else
                        intent.putExtra("result", "Your communication skills are painful.ter. You are talkative, verbose, intervene in matters that you do not have they have nothing to do with you. You take to judge the problems in which completely incompetent. Whether you want to or not, you often come across the rank of all sorts of conflicts in your environment. Hot-tempered, resent mentare often biased. Serious work is not for you. Liudyam - and at work, and at home, and in general everywhere - it is difficult with you. Yes, you need to work on yourself and your character! First of all, raised have patience and restraint, respect people, finally, think about your health - this lifestyle is not passes without a trace.");
                }
                intent.putExtra("small", small);
                startActivity(intent);
                finish();
            }
        });

        button_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                points = questionItem3s.get(currentQuestion).getScoreC() + points;

                //load next question if any
                if (currentQuestion < questionItem3s.size()-1){
                    currentQuestion++;
                    setQuestionScreen(currentQuestion);
                } else {
                    Intent intent = new Intent(getApplicationContext(), EndActivity.class);

                    if ((points >= 30) && (points <= 31)) {
                        if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                            intent.putExtra("result", "Вы явно некоммуникабельны, и эта ваша беда, так как больше всего страдаете от этого вы сами. Но и близким вам людям нелегко. На вас трудно положиться в деле, которое требует групповых усилий. Старайтесь быть общительнее, контролируйте себя.");
                        else
                            intent.putExtra("result", "You are clearly uncommunicative, and this is your problem, since you yourself suffer the most from this. But it is not easy for people close to you. You are difficult to rely on in a group effort. Try to be more sociable, control yourself.");
                    }else
                    if ((points >= 25) && (points <= 29)) {
                        if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                            intent.putExtra("result", "Вы замкнуты, неразговорчивы, предпочитаете одиночество, поэтому у вас мало друзей. Новая работа и необходимость новых контактов если не ввергают вас в панику, то надолго выводят из равновесия. Вы знаете эту особенность своего характера и бываете  не  довольны  собой.  Но  не  ограничивайтесь  только  таким  недовольством –в вашей власти переломит эти особенности характера. Разве не бывает, что при какой-либо сильной увлеченности вы приобретаете вдруг полную коммуникабельность? Стоит только встряхнуться.");
                        else
                            intent.putExtra("result", "You are closed, taciturn, prefer lonely honor, so you have few friends. New job and the need for new contacts, if they do not plunge you into a panic, then for a long time unbalance. You know this feature of your character and are not are free with themselves. But do not limit yourself to just such discontent - inyour power to reverse these character traits. Doesn't it happen that with any strong passion you suddenly acquire sexgood communication skills? One has only to shake things up.");
                    }else
                    if ((points >= 19) && (points <= 24)) {
                        if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                            intent.putExtra("result", "Вы  в  известной  степени  общительны  и  внезнакомой  обстановке чувствуете  себя  вполне  уверенно.  Новые  проблемы  вас  не  пугают.  И  все  же  с  новыми людьми  сходитесь  с  оглядкой,  в  спорах  и  диспутах  участвуют  неохотно.  В  ваших высказываниях  порой слишком  много  сарказма,  без  всякого  на  то  основания.  Эти недостатки исправимы.");
                        else
                            intent.putExtra("result", "You are somewhat sociable and unfamiliar the situation you feel quite confident. New problems don't scare you. And yet you converge with new people with a glance, in disputes and disputes you are reluctant to participate. In your statements, sometimes there are too many sarcasm, without any reason. These flaws are fixable.");
                    }else
                    if ((points >= 14) && (points <= 28)) {
                        if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                            intent.putExtra("result", "У вас нормальная коммуникабельность. Вы любознательны, охотно слушаете интересного собеседника, достаточно терпеливы в общении, отстаиваете свою точку зрения без вспыльчивости. Без неприятных переживаний идете на встречу с новыми людьми.  В  то  же  время  не  любите  шумных  компаний;  экстравагантные  выходки  и многословие вызывают у вас раздражение.");
                        else
                            intent.putExtra("result", "You have normal communication skills. You are curious are willing to listen to an interesting interlocutor, rather patient livable in communication, defend your point of view without irascibility.Without unpleasant experiences go to meet new people. At that time do not like noisy companies; extravagant antics and a lot the word annoys you.");
                    }else
                    if ((points >= 9) && (points <= 13)) {
                        if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                            intent.putExtra("result", "Вы  весьма  общительны  (порой,  быть  может,  даже  сверх  меры). Любопытны,  разговорчивы,  любите  высказываться  по  разным  вопросам,  что,  бывает, вызывает  раздражение  окружающих.  Охотно  знакомитесь  с  новыми  людьми.  Любите бывать в центре внимания, никому не отказываете в просьбах, хотя не всегда можете их выполнить.  Бывает,  вспылите,  но  быстро  отходите.  Чего  вам  недостает,  так  это усидчивости,  терпения  и  отваги  при  столкновении  с  серьезными  проблемами.  При желании, однако, вы можете себя заставить не отступать.");
                        else
                            intent.putExtra("result", "You are very sociable (sometimes, perhaps even over measures). Curious, talkative, like to speak up on different issues dew, which sometimes irritates others. Willingly familiar hang out with new people. Love to be in the spotlight, no one refuse requests, although you cannot always fulfill them. It happens,flare up, but back away quickly. What you lack is perseverance,patience and courage when faced with serious problems.When desire, however, you can force yourself not to back down.");
                    }else
                    if ((points >= 4) && (points <= 8)) {
                        if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                            intent.putExtra("result", "Вы, должно быть, «рубаха-парень». Общительность бьет из вас ключом. Вы  всегда  в  курсе  всех  дел.  Вы  любите  принимать  участие  во  всех  дискуссиях,  хотя серьезные темы могут вызывать у вас мигрень или даже хандру. Охотно берете слово по любому  вопросу,  даже  если  имеете  о  нем  поверхностное  представление.  Всюду чувствуетесебя в свой тарелке. Беретесь за любое дело, хотя не всегда можете успешно довести его до конца. По этой самой причине руководители и коллеги относятся к вам с некоторой опаской и сомнениями. Задумайтесь над этими фактами.");
                        else
                            intent.putExtra("result", "You must be a shirt-guy. Sociability beats outwith the key. You are always aware of all matters. You love to take part in all discussions, although serious topics may give you migraines or even blues. You are willing to take the floor on any issue, even if you have a superficial understanding of it. You feel at ease everywhere. Take on any business, although you cannot always successfully bring it to end. For this very reason, leaders and colleagues treat you with some apprehension and doubt. Consider these facts.");
                    }else {
                        if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                            intent.putExtra("result", "Ваша  коммуникабельность  носит  болезненный  характер.  Вы говорливы,  многословны,  вмешиваетесь  в  дела,  которые  не  имеют  к  вам никакогоотношения.  Беретесь  судить  о  проблемах,  в  к  которых  совершенно  не  компетентны. Вольно  или  невольно  вы  часто  бываете  причиной  разного  рода  конфликтов  в  вашем окружении. Вспыльчивы, обидчивы, нередко бываете необъективны. Серьезная работа не для вас. Людям –и на работе, и дома, и вообще повсюду –трудно с вами. Да, вам надо поработать  над  собой  и  своим  характером!  Прежде  всего  воспитывайте  в  себе терпеливость  и  сдержанность,  уважительно  относитесь  к  людям,  наконец,  подумайте  о своем здоровье –такой стиль жизни не проходит бесследно.");
                        else
                            intent.putExtra("result", "Your communication skills are painful.ter. You are talkative, verbose, intervene in matters that you do not have they have nothing to do with you. You take to judge the problems in which completely incompetent. Whether you want to or not, you often come across the rank of all sorts of conflicts in your environment. Hot-tempered, resent mentare often biased. Serious work is not for you. Liudyam - and at work, and at home, and in general everywhere - it is difficult with you. Yes, you need to work on yourself and your character! First of all, raised have patience and restraint, respect people, finally, think about your health - this lifestyle is not passes without a trace.");
                    }
                    intent.putExtra("small", small);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void setQuestionScreen(int number){
        question.setText(questionItem3s.get(number).getQuestion());
        count.setText((number+1) + "/" + questionItem3s.size());
        button_A.setText(questionItem3s.get(number).getAnswA());
        button_B.setText(questionItem3s.get(number).getAnswB());
        button_C.setText(questionItem3s.get(number).getAnswC());
    }

    private void loadAllQuestions(){
        questionItem3s = new ArrayList<>();
        String jsonStr;
        //load all questions into json string
        if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
            jsonStr = loadJSONFromAssert("ru/ryakhovsky_test");
        else
            jsonStr = loadJSONFromAssert("en/ryakhovsky_test_en");

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


                String questionString = question.getString("question");
                //???????????????????????????????????????????????????????????????
                answerAString = ansA.getString("answer");
                scoreAString = ansA.getInt("score");

                answerBString = ansB.getString("answer");
                scoreBString = ansB.getInt("score");

                answerCString = ansC.getString("answer");
                scoreCString = ansC.getInt("score");


                questionItem3s.add(new QuestionItem3(
                        questionString,
                        answerAString,
                        answerBString,
                        answerCString,
                        scoreAString,
                        scoreBString,
                        scoreCString
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
