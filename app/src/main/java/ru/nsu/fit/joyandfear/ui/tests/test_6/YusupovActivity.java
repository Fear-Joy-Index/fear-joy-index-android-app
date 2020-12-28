package ru.nsu.fit.joyandfear.ui.tests.test_6;

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
import ru.nsu.fit.joyandfear.ui.tests.question_item.QuestionItem6;

public class YusupovActivity extends AppCompatActivity {

    TextView question, count;
    Button button_A, button_B, button_C, button_D, button_E, button_F;


    List<QuestionItem6> questionItem6s;
    int currentQuestion = 0;
    int points = 0;
    String small = "0";

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Intent intent1 = getIntent();
        String name_test = intent1.getStringExtra("name_test");

        setContentView(R.layout.activity_test_6);

        Objects.requireNonNull(getSupportActionBar()).setTitle(name_test);

        question = findViewById(R.id.question_view);
        button_A = findViewById(R.id.button_A);
        button_B = findViewById(R.id.button_B);
        button_C = findViewById(R.id.button_C);
        button_D = findViewById(R.id.button_D);
        button_E = findViewById(R.id.button_E);
        button_F = findViewById(R.id.button_F);

        count = findViewById(R.id.count_view);

        loadAllQuestions();
        setQuestionScreen(currentQuestion);

        button_A.setOnClickListener(view -> {
            points = questionItem6s.get(currentQuestion).getScoreA() + points;

            //load next question if any
            if (currentQuestion < questionItem6s.size()-1){
                currentQuestion++;
                setQuestionScreen(currentQuestion);
            } else {
                Intent intent = new Intent(getApplicationContext(), EndActivity.class);

                if ((points >= 82) && (points <= 90)) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                        intent.putExtra("result", "Очень высокий уровень эмпатийности. У вас болезненно развито сопереживание. В общении, как барометр, тонко реагируете на настроение собеседника, еще неуспевшего сказать ни слова. Вам трудно от того, что окружающие используют вас в качестве громоотвода, обрушивая на вас эмоциональное состояние. Плохо чувствуете себя в присутствии «тяжелых» людей. Взрослые и дети охотно доверяют вам свои тайны и идут за советом. Нередко испытываете комплекс вины, опасаясь причинить людям хлопоты; не только словом, но даже взглядом боитесь задеть их. В тоже время сами очень ранимы. Можете страдать при виде покалеченного животного или ненаходить себе места от случайного холодного приветствия вашего шефа. Ваша впечатлительность порой долго не дает заснуть. Будучи в расстроенных чувствах, нуждаетесь в эмоциональной поддержке со стороны. При таком отношении к жизни вы близки к невротическим срывам. Побеспокойтесь о психическом здоровье.");
                    else
                        intent.putExtra("result", "Very high level of empathy. You have a morbidly developed empathy. In communication, as a barometer, you subtly react to the mood of the interlocutor, who has not yet managed to say a word. It is difficult for you because others use you as a lightning rod, bringing down an emotional state on you. You feel bad in the presence of 'heavy' people. Adults and children are willing to trust you with their secrets and go for advice. Often you experience a guilt complex, fearing to cause trouble to people; not only with a word, but even with a look, you are afraid to hurt them. At the same time, they are very vulnerable. You can suffer at the sight of a crippled animal or not find a place for yourself from the occasional cold greeting of your boss. Your impressionability sometimes does not allow you to fall asleep for a long time. Being upset, you need emotional support from the outside. With this attitude to life, you are close to neurotic breakdowns. Worry about your mental health.");
                }else
                if ((points >= 63) && (points <= 81)) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                        intent.putExtra("result", "Высокая эмпатийность. Вы чувствительны к нуждам и проблемам окружающих, великодушны, склонны многое им прощать. С неподдельным интересом относитесь к людям. Вам нравится «читать» их лицаи «заглядывать» в их будущее, вы эмоционально отзывчивы, общительны, быстро устанавливаете контакты с окружающими и находите общий язык. Должно быть, и дети тянутся к вам. Окружающие ценят вашу душевность. Вы стараетесь недопускать конфликты и находить компромиссные решения. Хорошо переносите критику в свой адрес. В оценке событий больше доверяете своим чувствам иинтуиции, чем аналитическим выводам. Предпочитаете работать с людьми, нежели в одиночку. Постоянно нуждаетесь в социальном одобрении своих действий. При всех перечисленных качествах вы не всегда аккуратны в точной и кропотливой работе. Не стоит особого труда вы вести вас из равновесия.");
                    else
                        intent.putExtra("result", "High empathy. You are sensitive to the needs and problems of others, generous, and tend to forgive them a lot. Treat people with genuine interest. You like to 'read' their faces and 'look' into their future, you are emotionally responsive, sociable, quickly establish contacts with others and find a common language. The children must be drawn to you, too. Others appreciate your sincerity. You try to avoid conflicts and find compromise solutions. Take criticism well. In the assessment of events and more in touch with their feelings and intuition than analytical conclusions. You prefer to work with people rather than alone. You constantly need social approval for your actions. With all these qualities, you are not always accurate in accurate and painstaking work. It is not worth much effort you lead you out of balance.");
                }else
                if ((points >= 47) && (points <= 62)) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                        intent.putExtra("result", "Нормальный уровень эмпатийности, присущий подавляющему большинству людей. Окружающие не могут назвать вас «толстокожим», но в тоже время вы не относитесь к числу особо чувствительных лиц. В межличностных отношениях судить о других более склонны по их поступкам, чем доверять своим личным впечатлениям. Вам не чужды эмоциональные проявления, но в большинстве своем они находятся под самоконтролем. В общении внимательны, стараетесь понять больше, чем сказано словами, но при излишнем влиянии чувств собеседника теряете терпение. Предпочитаете деликатно не высказывать свою точку зрения, не будучи уверенным, что она будет принята. При чтении художественных произведений и просмотре фильмов чаще следите за действием, чем за переживаниями героев. Затрудняетесь прогнозировать развити еотношений между людьми, поэтому, случается, что их поступки оказываются для вас неожиданными. У вас нет раскованности чувств, и этомешает вашему полноценному восприятию людей.");
                    else
                        intent.putExtra("result", "Normal level of empathy, inherent in the vast majority of people. Others may not call you 'thick-skinned', but at the same time you do not belong to the number of particularly sensitive persons. In interpersonal relationships, people are more likely to judge others by their actions than to trust their personal impressions. You are no stranger to emotional manifestations, but most of them are under self-control. In communication, you are attentive, try to understand more than what is said in words, but if you are too influenced by the feelings of the interlocutor, you lose patience. You prefer not to Express your point of view delicately, without being sure that it will be accepted. When reading fiction and watching movies, follow the action more often than the experiences of the characters. You find it difficult to predict the development of relationships between people, so it happens that their actions are unexpected for you. You have no looseness of feeling, and this interferes with your full perception of people.");
                }else
                if ((points >= 12) && (points <= 46)) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                        intent.putExtra("result", "Низкий уровень эмпатийности. Вы испытываете затруднения в установлении контактов слюдьми, неуютно чувствуете себя в большой компании. Эмоциональные проявления в поступках окружающих подчас кажутся Вам непонятными и лишенными смысла. Отдаете предпочтение уединенным занятиям конкретным делом, а не работе с людьми. Вы – сторонник точных формулировок и рациональных решений. Вероятно, у вас мало друзей, а из тех, кто есть, цените больше за деловые качества и ясный ум, чем за чуткость и отзывчивость. Люди платят вам темже. Бывает, когда чувствуете свою отчужденность, окружающие не слишком жалуют вас вниманием. Но это поправимо, если вы раскроете панцирь и станете пристальнее всматриваться в поведение близких и принимать их проблемы как свои.");
                    else
                        intent.putExtra("result", "Low level of empathy. You have difficulties in establishing contacts with mica, you feel uncomfortable in a large company. Emotional manifestations in the actions of others sometimes seem incomprehensible and meaningless to You. You prefer to do a specific thing in private, rather than work with people. You are a proponent of precise formulations and rational solutions. You probably have few friends, and of those who do, you value more for business qualities and a clear mind than for sensitivity and responsiveness. People pay you the same. Sometimes, when you feel alienated, others do not give you too much attention. But this can be corrected if you open your shell and begin to look more closely at the behavior of your loved ones and accept their problems as your own.");
                }else {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                        intent.putExtra("result", "Очень низкий уровень. Эмпатийные тенденции личности неразвиты. Затрудняетесь первым начать разговор, держитесь особняком среди сослуживцев. Особенно трудны контакты с детьми и лицами, которые намного старше вас. В межличностных отношениях нередко оказываетесь в неловком положении. Во многом не находите взаимопонимания с окружающими. Любите острые ощущения, спортивные состязания предпочитаете искусству. В деятельности слишком сконцентрированы на себе. Вы можете быть очень продуктивны в индивидуальной работе, во взаимодействии же с другими не всегда вы глядите в лучшем свете. Болезненно переносите критику в свой адрес, хотя можете на нее бурно не реагировать. Необходима гимнастика чувств.");
                    else
                        intent.putExtra("result", "Very low level. The empathic tendencies of the individual are undeveloped. If you find it difficult to start a conversation first, keep to yourself among your colleagues. Especially difficult are contacts with children and people who are much older than you. In interpersonal relationships, you often find yourself in an awkward position. In many ways, you do not find mutual understanding with others. You like thrills, you prefer sports to art. They are too self-centered in their activities. You can be very productive in individual work, but when you interact with others, you don't always look in the best light. Painfully transfer criticism to your address, although you can not react violently to it. It is necessary to exercise the senses.");
                }
                intent.putExtra("small", small);
                startActivity(intent);
                finish();
            }
        });

        button_B.setOnClickListener(view -> {
            points = questionItem6s.get(currentQuestion).getScoreB() + points;
            //load next question if any
            if (currentQuestion < questionItem6s.size()-1){
                currentQuestion++;
                setQuestionScreen(currentQuestion);
            } else {
                Intent intent = new Intent(getApplicationContext(), EndActivity.class);

                if ((points >= 82) && (points <= 90)) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                        intent.putExtra("result", "Очень высокий уровень эмпатийности. У вас болезненно развито сопереживание. В общении, как барометр, тонко реагируете на настроение собеседника, еще неуспевшего сказать ни слова. Вам трудно от того, что окружающие используют вас в качестве громоотвода, обрушивая на вас эмоциональное состояние. Плохо чувствуете себя в присутствии «тяжелых» людей. Взрослые и дети охотно доверяют вам свои тайны и идут за советом. Нередко испытываете комплекс вины, опасаясь причинить людям хлопоты; не только словом, но даже взглядом боитесь задеть их. В тоже время сами очень ранимы. Можете страдать при виде покалеченного животного или ненаходить себе места от случайного холодного приветствия вашего шефа. Ваша впечатлительность порой долго не дает заснуть. Будучи в расстроенных чувствах, нуждаетесь в эмоциональной поддержке со стороны. При таком отношении к жизни вы близки к невротическим срывам. Побеспокойтесь о психическом здоровье.");
                    else
                        intent.putExtra("result", "Very high level of empathy. You have a morbidly developed empathy. In communication, as a barometer, you subtly react to the mood of the interlocutor, who has not yet managed to say a word. It is difficult for you because others use you as a lightning rod, bringing down an emotional state on you. You feel bad in the presence of 'heavy' people. Adults and children are willing to trust you with their secrets and go for advice. Often you experience a guilt complex, fearing to cause trouble to people; not only with a word, but even with a look, you are afraid to hurt them. At the same time, they are very vulnerable. You can suffer at the sight of a crippled animal or not find a place for yourself from the occasional cold greeting of your boss. Your impressionability sometimes does not allow you to fall asleep for a long time. Being upset, you need emotional support from the outside. With this attitude to life, you are close to neurotic breakdowns. Worry about your mental health.");
                }else
                if ((points >= 63) && (points <= 81)) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                        intent.putExtra("result", "Высокая эмпатийность. Вы чувствительны к нуждам и проблемам окружающих, великодушны, склонны многое им прощать. С неподдельным интересом относитесь к людям. Вам нравится «читать» их лицаи «заглядывать» в их будущее, вы эмоционально отзывчивы, общительны, быстро устанавливаете контакты с окружающими и находите общий язык. Должно быть, и дети тянутся к вам. Окружающие ценят вашу душевность. Вы стараетесь недопускать конфликты и находить компромиссные решения. Хорошо переносите критику в свой адрес. В оценке событий больше доверяете своим чувствам иинтуиции, чем аналитическим выводам. Предпочитаете работать с людьми, нежели в одиночку. Постоянно нуждаетесь в социальном одобрении своих действий. При всех перечисленных качествах вы не всегда аккуратны в точной и кропотливой работе. Не стоит особого труда вы вести вас из равновесия.");
                    else
                        intent.putExtra("result", "High empathy. You are sensitive to the needs and problems of others, generous, and tend to forgive them a lot. Treat people with genuine interest. You like to 'read' their faces and 'look' into their future, you are emotionally responsive, sociable, quickly establish contacts with others and find a common language. The children must be drawn to you, too. Others appreciate your sincerity. You try to avoid conflicts and find compromise solutions. Take criticism well. In the assessment of events and more in touch with their feelings and intuition than analytical conclusions. You prefer to work with people rather than alone. You constantly need social approval for your actions. With all these qualities, you are not always accurate in accurate and painstaking work. It is not worth much effort you lead you out of balance.");
                }else
                if ((points >= 47) && (points <= 62)) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                        intent.putExtra("result", "Нормальный уровень эмпатийности, присущий подавляющему большинству людей. Окружающие не могут назвать вас «толстокожим», но в тоже время вы не относитесь к числу особо чувствительных лиц. В межличностных отношениях судить о других более склонны по их поступкам, чем доверять своим личным впечатлениям. Вам не чужды эмоциональные проявления, но в большинстве своем они находятся под самоконтролем. В общении внимательны, стараетесь понять больше, чем сказано словами, но при излишнем влиянии чувств собеседника теряете терпение. Предпочитаете деликатно не высказывать свою точку зрения, не будучи уверенным, что она будет принята. При чтении художественных произведений и просмотре фильмов чаще следите за действием, чем за переживаниями героев. Затрудняетесь прогнозировать развити еотношений между людьми, поэтому, случается, что их поступки оказываются для вас неожиданными. У вас нет раскованности чувств, и этомешает вашему полноценному восприятию людей.");
                    else
                        intent.putExtra("result", "Normal level of empathy, inherent in the vast majority of people. Others may not call you 'thick-skinned', but at the same time you do not belong to the number of particularly sensitive persons. In interpersonal relationships, people are more likely to judge others by their actions than to trust their personal impressions. You are no stranger to emotional manifestations, but most of them are under self-control. In communication, you are attentive, try to understand more than what is said in words, but if you are too influenced by the feelings of the interlocutor, you lose patience. You prefer not to Express your point of view delicately, without being sure that it will be accepted. When reading fiction and watching movies, follow the action more often than the experiences of the characters. You find it difficult to predict the development of relationships between people, so it happens that their actions are unexpected for you. You have no looseness of feeling, and this interferes with your full perception of people.");
                }else
                if ((points >= 12) && (points <= 46)) {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                        intent.putExtra("result", "Низкий уровень эмпатийности. Вы испытываете затруднения в установлении контактов слюдьми, неуютно чувствуете себя в большой компании. Эмоциональные проявления в поступках окружающих подчас кажутся Вам непонятными и лишенными смысла. Отдаете предпочтение уединенным занятиям конкретным делом, а не работе с людьми. Вы – сторонник точных формулировок и рациональных решений. Вероятно, у вас мало друзей, а из тех, кто есть, цените больше за деловые качества и ясный ум, чем за чуткость и отзывчивость. Люди платят вам темже. Бывает, когда чувствуете свою отчужденность, окружающие не слишком жалуют вас вниманием. Но это поправимо, если вы раскроете панцирь и станете пристальнее всматриваться в поведение близких и принимать их проблемы как свои.");
                    else
                        intent.putExtra("result", "Low level of empathy. You have difficulties in establishing contacts with mica, you feel uncomfortable in a large company. Emotional manifestations in the actions of others sometimes seem incomprehensible and meaningless to You. You prefer to do a specific thing in private, rather than work with people. You are a proponent of precise formulations and rational solutions. You probably have few friends, and of those who do, you value more for business qualities and a clear mind than for sensitivity and responsiveness. People pay you the same. Sometimes, when you feel alienated, others do not give you too much attention. But this can be corrected if you open your shell and begin to look more closely at the behavior of your loved ones and accept their problems as your own.");
                }else {
                    if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                        intent.putExtra("result", "Очень низкий уровень. Эмпатийные тенденции личности неразвиты. Затрудняетесь первым начать разговор, держитесь особняком среди сослуживцев. Особенно трудны контакты с детьми и лицами, которые намного старше вас. В межличностных отношениях нередко оказываетесь в неловком положении. Во многом не находите взаимопонимания с окружающими. Любите острые ощущения, спортивные состязания предпочитаете искусству. В деятельности слишком сконцентрированы на себе. Вы можете быть очень продуктивны в индивидуальной работе, во взаимодействии же с другими не всегда вы глядите в лучшем свете. Болезненно переносите критику в свой адрес, хотя можете на нее бурно не реагировать. Необходима гимнастика чувств.");
                    else
                        intent.putExtra("result", "Very low level. The empathic tendencies of the individual are undeveloped. If you find it difficult to start a conversation first, keep to yourself among your colleagues. Especially difficult are contacts with children and people who are much older than you. In interpersonal relationships, you often find yourself in an awkward position. In many ways, you do not find mutual understanding with others. You like thrills, you prefer sports to art. They are too self-centered in their activities. You can be very productive in individual work, but when you interact with others, you don't always look in the best light. Painfully transfer criticism to your address, although you can not react violently to it. It is necessary to exercise the senses.");
                }
                intent.putExtra("small", small);
                startActivity(intent);
                finish();
            }
        });

        button_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                points = questionItem6s.get(currentQuestion).getScoreC() + points;

                //load next question if any
                if (currentQuestion < questionItem6s.size()-1){
                    currentQuestion++;
                    setQuestionScreen(currentQuestion);
                } else {
                    Intent intent = new Intent(getApplicationContext(), EndActivity.class);

                    if ((points >= 82) && (points <= 90)) {
                        if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                            intent.putExtra("result", "Очень высокий уровень эмпатийности. У вас болезненно развито сопереживание. В общении, как барометр, тонко реагируете на настроение собеседника, еще неуспевшего сказать ни слова. Вам трудно от того, что окружающие используют вас в качестве громоотвода, обрушивая на вас эмоциональное состояние. Плохо чувствуете себя в присутствии «тяжелых» людей. Взрослые и дети охотно доверяют вам свои тайны и идут за советом. Нередко испытываете комплекс вины, опасаясь причинить людям хлопоты; не только словом, но даже взглядом боитесь задеть их. В тоже время сами очень ранимы. Можете страдать при виде покалеченного животного или ненаходить себе места от случайного холодного приветствия вашего шефа. Ваша впечатлительность порой долго не дает заснуть. Будучи в расстроенных чувствах, нуждаетесь в эмоциональной поддержке со стороны. При таком отношении к жизни вы близки к невротическим срывам. Побеспокойтесь о психическом здоровье.");
                        else
                            intent.putExtra("result", "Very high level of empathy. You have a morbidly developed empathy. In communication, as a barometer, you subtly react to the mood of the interlocutor, who has not yet managed to say a word. It is difficult for you because others use you as a lightning rod, bringing down an emotional state on you. You feel bad in the presence of 'heavy' people. Adults and children are willing to trust you with their secrets and go for advice. Often you experience a guilt complex, fearing to cause trouble to people; not only with a word, but even with a look, you are afraid to hurt them. At the same time, they are very vulnerable. You can suffer at the sight of a crippled animal or not find a place for yourself from the occasional cold greeting of your boss. Your impressionability sometimes does not allow you to fall asleep for a long time. Being upset, you need emotional support from the outside. With this attitude to life, you are close to neurotic breakdowns. Worry about your mental health.");
                    }else
                    if ((points >= 63) && (points <= 81)) {
                        if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                            intent.putExtra("result", "Высокая эмпатийность. Вы чувствительны к нуждам и проблемам окружающих, великодушны, склонны многое им прощать. С неподдельным интересом относитесь к людям. Вам нравится «читать» их лицаи «заглядывать» в их будущее, вы эмоционально отзывчивы, общительны, быстро устанавливаете контакты с окружающими и находите общий язык. Должно быть, и дети тянутся к вам. Окружающие ценят вашу душевность. Вы стараетесь недопускать конфликты и находить компромиссные решения. Хорошо переносите критику в свой адрес. В оценке событий больше доверяете своим чувствам иинтуиции, чем аналитическим выводам. Предпочитаете работать с людьми, нежели в одиночку. Постоянно нуждаетесь в социальном одобрении своих действий. При всех перечисленных качествах вы не всегда аккуратны в точной и кропотливой работе. Не стоит особого труда вы вести вас из равновесия.");
                        else
                            intent.putExtra("result", "High empathy. You are sensitive to the needs and problems of others, generous, and tend to forgive them a lot. Treat people with genuine interest. You like to 'read' their faces and 'look' into their future, you are emotionally responsive, sociable, quickly establish contacts with others and find a common language. The children must be drawn to you, too. Others appreciate your sincerity. You try to avoid conflicts and find compromise solutions. Take criticism well. In the assessment of events and more in touch with their feelings and intuition than analytical conclusions. You prefer to work with people rather than alone. You constantly need social approval for your actions. With all these qualities, you are not always accurate in accurate and painstaking work. It is not worth much effort you lead you out of balance.");
                    }else
                    if ((points >= 47) && (points <= 62)) {
                        if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                            intent.putExtra("result", "Нормальный уровень эмпатийности, присущий подавляющему большинству людей. Окружающие не могут назвать вас «толстокожим», но в тоже время вы не относитесь к числу особо чувствительных лиц. В межличностных отношениях судить о других более склонны по их поступкам, чем доверять своим личным впечатлениям. Вам не чужды эмоциональные проявления, но в большинстве своем они находятся под самоконтролем. В общении внимательны, стараетесь понять больше, чем сказано словами, но при излишнем влиянии чувств собеседника теряете терпение. Предпочитаете деликатно не высказывать свою точку зрения, не будучи уверенным, что она будет принята. При чтении художественных произведений и просмотре фильмов чаще следите за действием, чем за переживаниями героев. Затрудняетесь прогнозировать развити еотношений между людьми, поэтому, случается, что их поступки оказываются для вас неожиданными. У вас нет раскованности чувств, и этомешает вашему полноценному восприятию людей.");
                        else
                            intent.putExtra("result", "Normal level of empathy, inherent in the vast majority of people. Others may not call you 'thick-skinned', but at the same time you do not belong to the number of particularly sensitive persons. In interpersonal relationships, people are more likely to judge others by their actions than to trust their personal impressions. You are no stranger to emotional manifestations, but most of them are under self-control. In communication, you are attentive, try to understand more than what is said in words, but if you are too influenced by the feelings of the interlocutor, you lose patience. You prefer not to Express your point of view delicately, without being sure that it will be accepted. When reading fiction and watching movies, follow the action more often than the experiences of the characters. You find it difficult to predict the development of relationships between people, so it happens that their actions are unexpected for you. You have no looseness of feeling, and this interferes with your full perception of people.");
                    }else
                    if ((points >= 12) && (points <= 46)) {
                        if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                            intent.putExtra("result", "Низкий уровень эмпатийности. Вы испытываете затруднения в установлении контактов слюдьми, неуютно чувствуете себя в большой компании. Эмоциональные проявления в поступках окружающих подчас кажутся Вам непонятными и лишенными смысла. Отдаете предпочтение уединенным занятиям конкретным делом, а не работе с людьми. Вы – сторонник точных формулировок и рациональных решений. Вероятно, у вас мало друзей, а из тех, кто есть, цените больше за деловые качества и ясный ум, чем за чуткость и отзывчивость. Люди платят вам темже. Бывает, когда чувствуете свою отчужденность, окружающие не слишком жалуют вас вниманием. Но это поправимо, если вы раскроете панцирь и станете пристальнее всматриваться в поведение близких и принимать их проблемы как свои.");
                        else
                            intent.putExtra("result", "Low level of empathy. You have difficulties in establishing contacts with mica, you feel uncomfortable in a large company. Emotional manifestations in the actions of others sometimes seem incomprehensible and meaningless to You. You prefer to do a specific thing in private, rather than work with people. You are a proponent of precise formulations and rational solutions. You probably have few friends, and of those who do, you value more for business qualities and a clear mind than for sensitivity and responsiveness. People pay you the same. Sometimes, when you feel alienated, others do not give you too much attention. But this can be corrected if you open your shell and begin to look more closely at the behavior of your loved ones and accept their problems as your own.");
                    }else {
                        if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                            intent.putExtra("result", "Очень низкий уровень. Эмпатийные тенденции личности неразвиты. Затрудняетесь первым начать разговор, держитесь особняком среди сослуживцев. Особенно трудны контакты с детьми и лицами, которые намного старше вас. В межличностных отношениях нередко оказываетесь в неловком положении. Во многом не находите взаимопонимания с окружающими. Любите острые ощущения, спортивные состязания предпочитаете искусству. В деятельности слишком сконцентрированы на себе. Вы можете быть очень продуктивны в индивидуальной работе, во взаимодействии же с другими не всегда вы глядите в лучшем свете. Болезненно переносите критику в свой адрес, хотя можете на нее бурно не реагировать. Необходима гимнастика чувств.");
                        else
                            intent.putExtra("result", "Very low level. The empathic tendencies of the individual are undeveloped. If you find it difficult to start a conversation first, keep to yourself among your colleagues. Especially difficult are contacts with children and people who are much older than you. In interpersonal relationships, you often find yourself in an awkward position. In many ways, you do not find mutual understanding with others. You like thrills, you prefer sports to art. They are too self-centered in their activities. You can be very productive in individual work, but when you interact with others, you don't always look in the best light. Painfully transfer criticism to your address, although you can not react violently to it. It is necessary to exercise the senses.");
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
                points = questionItem6s.get(currentQuestion).getScoreD() + points;

                //load next question if any
                if (currentQuestion < questionItem6s.size()-1){
                    currentQuestion++;
                    setQuestionScreen(currentQuestion);
                } else {
                    Intent intent = new Intent(getApplicationContext(), EndActivity.class);
                    if ((points >= 82) && (points <= 90)) {
                        if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                            intent.putExtra("result", "Очень высокий уровень эмпатийности. У вас болезненно развито сопереживание. В общении, как барометр, тонко реагируете на настроение собеседника, еще неуспевшего сказать ни слова. Вам трудно от того, что окружающие используют вас в качестве громоотвода, обрушивая на вас эмоциональное состояние. Плохо чувствуете себя в присутствии «тяжелых» людей. Взрослые и дети охотно доверяют вам свои тайны и идут за советом. Нередко испытываете комплекс вины, опасаясь причинить людям хлопоты; не только словом, но даже взглядом боитесь задеть их. В тоже время сами очень ранимы. Можете страдать при виде покалеченного животного или ненаходить себе места от случайного холодного приветствия вашего шефа. Ваша впечатлительность порой долго не дает заснуть. Будучи в расстроенных чувствах, нуждаетесь в эмоциональной поддержке со стороны. При таком отношении к жизни вы близки к невротическим срывам. Побеспокойтесь о психическом здоровье.");
                        else
                            intent.putExtra("result", "Very high level of empathy. You have a morbidly developed empathy. In communication, as a barometer, you subtly react to the mood of the interlocutor, who has not yet managed to say a word. It is difficult for you because others use you as a lightning rod, bringing down an emotional state on you. You feel bad in the presence of 'heavy' people. Adults and children are willing to trust you with their secrets and go for advice. Often you experience a guilt complex, fearing to cause trouble to people; not only with a word, but even with a look, you are afraid to hurt them. At the same time, they are very vulnerable. You can suffer at the sight of a crippled animal or not find a place for yourself from the occasional cold greeting of your boss. Your impressionability sometimes does not allow you to fall asleep for a long time. Being upset, you need emotional support from the outside. With this attitude to life, you are close to neurotic breakdowns. Worry about your mental health.");
                    }else
                    if ((points >= 63) && (points <= 81)) {
                        if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                            intent.putExtra("result", "Высокая эмпатийность. Вы чувствительны к нуждам и проблемам окружающих, великодушны, склонны многое им прощать. С неподдельным интересом относитесь к людям. Вам нравится «читать» их лицаи «заглядывать» в их будущее, вы эмоционально отзывчивы, общительны, быстро устанавливаете контакты с окружающими и находите общий язык. Должно быть, и дети тянутся к вам. Окружающие ценят вашу душевность. Вы стараетесь недопускать конфликты и находить компромиссные решения. Хорошо переносите критику в свой адрес. В оценке событий больше доверяете своим чувствам иинтуиции, чем аналитическим выводам. Предпочитаете работать с людьми, нежели в одиночку. Постоянно нуждаетесь в социальном одобрении своих действий. При всех перечисленных качествах вы не всегда аккуратны в точной и кропотливой работе. Не стоит особого труда вы вести вас из равновесия.");
                        else
                            intent.putExtra("result", "High empathy. You are sensitive to the needs and problems of others, generous, and tend to forgive them a lot. Treat people with genuine interest. You like to 'read' their faces and 'look' into their future, you are emotionally responsive, sociable, quickly establish contacts with others and find a common language. The children must be drawn to you, too. Others appreciate your sincerity. You try to avoid conflicts and find compromise solutions. Take criticism well. In the assessment of events and more in touch with their feelings and intuition than analytical conclusions. You prefer to work with people rather than alone. You constantly need social approval for your actions. With all these qualities, you are not always accurate in accurate and painstaking work. It is not worth much effort you lead you out of balance.");
                    }else
                    if ((points >= 47) && (points <= 62)) {
                        if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                            intent.putExtra("result", "Нормальный уровень эмпатийности, присущий подавляющему большинству людей. Окружающие не могут назвать вас «толстокожим», но в тоже время вы не относитесь к числу особо чувствительных лиц. В межличностных отношениях судить о других более склонны по их поступкам, чем доверять своим личным впечатлениям. Вам не чужды эмоциональные проявления, но в большинстве своем они находятся под самоконтролем. В общении внимательны, стараетесь понять больше, чем сказано словами, но при излишнем влиянии чувств собеседника теряете терпение. Предпочитаете деликатно не высказывать свою точку зрения, не будучи уверенным, что она будет принята. При чтении художественных произведений и просмотре фильмов чаще следите за действием, чем за переживаниями героев. Затрудняетесь прогнозировать развити еотношений между людьми, поэтому, случается, что их поступки оказываются для вас неожиданными. У вас нет раскованности чувств, и этомешает вашему полноценному восприятию людей.");
                        else
                            intent.putExtra("result", "Normal level of empathy, inherent in the vast majority of people. Others may not call you 'thick-skinned', but at the same time you do not belong to the number of particularly sensitive persons. In interpersonal relationships, people are more likely to judge others by their actions than to trust their personal impressions. You are no stranger to emotional manifestations, but most of them are under self-control. In communication, you are attentive, try to understand more than what is said in words, but if you are too influenced by the feelings of the interlocutor, you lose patience. You prefer not to Express your point of view delicately, without being sure that it will be accepted. When reading fiction and watching movies, follow the action more often than the experiences of the characters. You find it difficult to predict the development of relationships between people, so it happens that their actions are unexpected for you. You have no looseness of feeling, and this interferes with your full perception of people.");
                    }else
                    if ((points >= 12) && (points <= 46)) {
                        if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                            intent.putExtra("result", "Низкий уровень эмпатийности. Вы испытываете затруднения в установлении контактов слюдьми, неуютно чувствуете себя в большой компании. Эмоциональные проявления в поступках окружающих подчас кажутся Вам непонятными и лишенными смысла. Отдаете предпочтение уединенным занятиям конкретным делом, а не работе с людьми. Вы – сторонник точных формулировок и рациональных решений. Вероятно, у вас мало друзей, а из тех, кто есть, цените больше за деловые качества и ясный ум, чем за чуткость и отзывчивость. Люди платят вам темже. Бывает, когда чувствуете свою отчужденность, окружающие не слишком жалуют вас вниманием. Но это поправимо, если вы раскроете панцирь и станете пристальнее всматриваться в поведение близких и принимать их проблемы как свои.");
                        else
                            intent.putExtra("result", "Low level of empathy. You have difficulties in establishing contacts with mica, you feel uncomfortable in a large company. Emotional manifestations in the actions of others sometimes seem incomprehensible and meaningless to You. You prefer to do a specific thing in private, rather than work with people. You are a proponent of precise formulations and rational solutions. You probably have few friends, and of those who do, you value more for business qualities and a clear mind than for sensitivity and responsiveness. People pay you the same. Sometimes, when you feel alienated, others do not give you too much attention. But this can be corrected if you open your shell and begin to look more closely at the behavior of your loved ones and accept their problems as your own.");
                    }else {
                        if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                            intent.putExtra("result", "Очень низкий уровень. Эмпатийные тенденции личности неразвиты. Затрудняетесь первым начать разговор, держитесь особняком среди сослуживцев. Особенно трудны контакты с детьми и лицами, которые намного старше вас. В межличностных отношениях нередко оказываетесь в неловком положении. Во многом не находите взаимопонимания с окружающими. Любите острые ощущения, спортивные состязания предпочитаете искусству. В деятельности слишком сконцентрированы на себе. Вы можете быть очень продуктивны в индивидуальной работе, во взаимодействии же с другими не всегда вы глядите в лучшем свете. Болезненно переносите критику в свой адрес, хотя можете на нее бурно не реагировать. Необходима гимнастика чувств.");
                        else
                            intent.putExtra("result", "Very low level. The empathic tendencies of the individual are undeveloped. If you find it difficult to start a conversation first, keep to yourself among your colleagues. Especially difficult are contacts with children and people who are much older than you. In interpersonal relationships, you often find yourself in an awkward position. In many ways, you do not find mutual understanding with others. You like thrills, you prefer sports to art. They are too self-centered in their activities. You can be very productive in individual work, but when you interact with others, you don't always look in the best light. Painfully transfer criticism to your address, although you can not react violently to it. It is necessary to exercise the senses.");
                    }
                    intent.putExtra("small", small);
                    startActivity(intent);
                    finish();
                }
            }
        });

        button_E.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                points = questionItem6s.get(currentQuestion).getScoreE() + points;

                //load next question if any
                if (currentQuestion < questionItem6s.size()-1){
                    currentQuestion++;
                    setQuestionScreen(currentQuestion);
                } else {
                    Intent intent = new Intent(getApplicationContext(), EndActivity.class);
                    if ((points >= 82) && (points <= 90)) {
                        if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                            intent.putExtra("result", "Очень высокий уровень эмпатийности. У вас болезненно развито сопереживание. В общении, как барометр, тонко реагируете на настроение собеседника, еще неуспевшего сказать ни слова. Вам трудно от того, что окружающие используют вас в качестве громоотвода, обрушивая на вас эмоциональное состояние. Плохо чувствуете себя в присутствии «тяжелых» людей. Взрослые и дети охотно доверяют вам свои тайны и идут за советом. Нередко испытываете комплекс вины, опасаясь причинить людям хлопоты; не только словом, но даже взглядом боитесь задеть их. В тоже время сами очень ранимы. Можете страдать при виде покалеченного животного или ненаходить себе места от случайного холодного приветствия вашего шефа. Ваша впечатлительность порой долго не дает заснуть. Будучи в расстроенных чувствах, нуждаетесь в эмоциональной поддержке со стороны. При таком отношении к жизни вы близки к невротическим срывам. Побеспокойтесь о психическом здоровье.");
                        else
                            intent.putExtra("result", "Very high level of empathy. You have a morbidly developed empathy. In communication, as a barometer, you subtly react to the mood of the interlocutor, who has not yet managed to say a word. It is difficult for you because others use you as a lightning rod, bringing down an emotional state on you. You feel bad in the presence of 'heavy' people. Adults and children are willing to trust you with their secrets and go for advice. Often you experience a guilt complex, fearing to cause trouble to people; not only with a word, but even with a look, you are afraid to hurt them. At the same time, they are very vulnerable. You can suffer at the sight of a crippled animal or not find a place for yourself from the occasional cold greeting of your boss. Your impressionability sometimes does not allow you to fall asleep for a long time. Being upset, you need emotional support from the outside. With this attitude to life, you are close to neurotic breakdowns. Worry about your mental health.");
                    }else
                    if ((points >= 63) && (points <= 81)) {
                        if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                            intent.putExtra("result", "Высокая эмпатийность. Вы чувствительны к нуждам и проблемам окружающих, великодушны, склонны многое им прощать. С неподдельным интересом относитесь к людям. Вам нравится «читать» их лицаи «заглядывать» в их будущее, вы эмоционально отзывчивы, общительны, быстро устанавливаете контакты с окружающими и находите общий язык. Должно быть, и дети тянутся к вам. Окружающие ценят вашу душевность. Вы стараетесь недопускать конфликты и находить компромиссные решения. Хорошо переносите критику в свой адрес. В оценке событий больше доверяете своим чувствам иинтуиции, чем аналитическим выводам. Предпочитаете работать с людьми, нежели в одиночку. Постоянно нуждаетесь в социальном одобрении своих действий. При всех перечисленных качествах вы не всегда аккуратны в точной и кропотливой работе. Не стоит особого труда вы вести вас из равновесия.");
                        else
                            intent.putExtra("result", "High empathy. You are sensitive to the needs and problems of others, generous, and tend to forgive them a lot. Treat people with genuine interest. You like to 'read' their faces and 'look' into their future, you are emotionally responsive, sociable, quickly establish contacts with others and find a common language. The children must be drawn to you, too. Others appreciate your sincerity. You try to avoid conflicts and find compromise solutions. Take criticism well. In the assessment of events and more in touch with their feelings and intuition than analytical conclusions. You prefer to work with people rather than alone. You constantly need social approval for your actions. With all these qualities, you are not always accurate in accurate and painstaking work. It is not worth much effort you lead you out of balance.");
                    }else
                    if ((points >= 47) && (points <= 62)) {
                        if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                            intent.putExtra("result", "Нормальный уровень эмпатийности, присущий подавляющему большинству людей. Окружающие не могут назвать вас «толстокожим», но в тоже время вы не относитесь к числу особо чувствительных лиц. В межличностных отношениях судить о других более склонны по их поступкам, чем доверять своим личным впечатлениям. Вам не чужды эмоциональные проявления, но в большинстве своем они находятся под самоконтролем. В общении внимательны, стараетесь понять больше, чем сказано словами, но при излишнем влиянии чувств собеседника теряете терпение. Предпочитаете деликатно не высказывать свою точку зрения, не будучи уверенным, что она будет принята. При чтении художественных произведений и просмотре фильмов чаще следите за действием, чем за переживаниями героев. Затрудняетесь прогнозировать развити еотношений между людьми, поэтому, случается, что их поступки оказываются для вас неожиданными. У вас нет раскованности чувств, и этомешает вашему полноценному восприятию людей.");
                        else
                            intent.putExtra("result", "Normal level of empathy, inherent in the vast majority of people. Others may not call you 'thick-skinned', but at the same time you do not belong to the number of particularly sensitive persons. In interpersonal relationships, people are more likely to judge others by their actions than to trust their personal impressions. You are no stranger to emotional manifestations, but most of them are under self-control. In communication, you are attentive, try to understand more than what is said in words, but if you are too influenced by the feelings of the interlocutor, you lose patience. You prefer not to Express your point of view delicately, without being sure that it will be accepted. When reading fiction and watching movies, follow the action more often than the experiences of the characters. You find it difficult to predict the development of relationships between people, so it happens that their actions are unexpected for you. You have no looseness of feeling, and this interferes with your full perception of people.");
                    }else
                    if ((points >= 12) && (points <= 46)) {
                        if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                            intent.putExtra("result", "Низкий уровень эмпатийности. Вы испытываете затруднения в установлении контактов слюдьми, неуютно чувствуете себя в большой компании. Эмоциональные проявления в поступках окружающих подчас кажутся Вам непонятными и лишенными смысла. Отдаете предпочтение уединенным занятиям конкретным делом, а не работе с людьми. Вы – сторонник точных формулировок и рациональных решений. Вероятно, у вас мало друзей, а из тех, кто есть, цените больше за деловые качества и ясный ум, чем за чуткость и отзывчивость. Люди платят вам темже. Бывает, когда чувствуете свою отчужденность, окружающие не слишком жалуют вас вниманием. Но это поправимо, если вы раскроете панцирь и станете пристальнее всматриваться в поведение близких и принимать их проблемы как свои.");
                        else
                            intent.putExtra("result", "Low level of empathy. You have difficulties in establishing contacts with mica, you feel uncomfortable in a large company. Emotional manifestations in the actions of others sometimes seem incomprehensible and meaningless to You. You prefer to do a specific thing in private, rather than work with people. You are a proponent of precise formulations and rational solutions. You probably have few friends, and of those who do, you value more for business qualities and a clear mind than for sensitivity and responsiveness. People pay you the same. Sometimes, when you feel alienated, others do not give you too much attention. But this can be corrected if you open your shell and begin to look more closely at the behavior of your loved ones and accept their problems as your own.");
                    }else {
                        if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                            intent.putExtra("result", "Очень низкий уровень. Эмпатийные тенденции личности неразвиты. Затрудняетесь первым начать разговор, держитесь особняком среди сослуживцев. Особенно трудны контакты с детьми и лицами, которые намного старше вас. В межличностных отношениях нередко оказываетесь в неловком положении. Во многом не находите взаимопонимания с окружающими. Любите острые ощущения, спортивные состязания предпочитаете искусству. В деятельности слишком сконцентрированы на себе. Вы можете быть очень продуктивны в индивидуальной работе, во взаимодействии же с другими не всегда вы глядите в лучшем свете. Болезненно переносите критику в свой адрес, хотя можете на нее бурно не реагировать. Необходима гимнастика чувств.");
                        else
                            intent.putExtra("result", "Very low level. The empathic tendencies of the individual are undeveloped. If you find it difficult to start a conversation first, keep to yourself among your colleagues. Especially difficult are contacts with children and people who are much older than you. In interpersonal relationships, you often find yourself in an awkward position. In many ways, you do not find mutual understanding with others. You like thrills, you prefer sports to art. They are too self-centered in their activities. You can be very productive in individual work, but when you interact with others, you don't always look in the best light. Painfully transfer criticism to your address, although you can not react violently to it. It is necessary to exercise the senses.");
                    }
                    intent.putExtra("small", small);
                    startActivity(intent);
                    finish();
                }
            }
        });

        button_F.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                points = questionItem6s.get(currentQuestion).getScoreF() + points;

                //load next question if any
                if (currentQuestion < questionItem6s.size()-1){
                    currentQuestion++;
                    setQuestionScreen(currentQuestion);
                } else {
                    Intent intent = new Intent(getApplicationContext(), EndActivity.class);
                    if ((points >= 82) && (points <= 90)) {
                        if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                            intent.putExtra("result", "Очень высокий уровень эмпатийности. У вас болезненно развито сопереживание. В общении, как барометр, тонко реагируете на настроение собеседника, еще неуспевшего сказать ни слова. Вам трудно от того, что окружающие используют вас в качестве громоотвода, обрушивая на вас эмоциональное состояние. Плохо чувствуете себя в присутствии «тяжелых» людей. Взрослые и дети охотно доверяют вам свои тайны и идут за советом. Нередко испытываете комплекс вины, опасаясь причинить людям хлопоты; не только словом, но даже взглядом боитесь задеть их. В тоже время сами очень ранимы. Можете страдать при виде покалеченного животного или ненаходить себе места от случайного холодного приветствия вашего шефа. Ваша впечатлительность порой долго не дает заснуть. Будучи в расстроенных чувствах, нуждаетесь в эмоциональной поддержке со стороны. При таком отношении к жизни вы близки к невротическим срывам. Побеспокойтесь о психическом здоровье.");
                        else
                            intent.putExtra("result", "Very high level of empathy. You have a morbidly developed empathy. In communication, as a barometer, you subtly react to the mood of the interlocutor, who has not yet managed to say a word. It is difficult for you because others use you as a lightning rod, bringing down an emotional state on you. You feel bad in the presence of 'heavy' people. Adults and children are willing to trust you with their secrets and go for advice. Often you experience a guilt complex, fearing to cause trouble to people; not only with a word, but even with a look, you are afraid to hurt them. At the same time, they are very vulnerable. You can suffer at the sight of a crippled animal or not find a place for yourself from the occasional cold greeting of your boss. Your impressionability sometimes does not allow you to fall asleep for a long time. Being upset, you need emotional support from the outside. With this attitude to life, you are close to neurotic breakdowns. Worry about your mental health.");
                    }else
                    if ((points >= 63) && (points <= 81)) {
                        if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                            intent.putExtra("result", "Высокая эмпатийность. Вы чувствительны к нуждам и проблемам окружающих, великодушны, склонны многое им прощать. С неподдельным интересом относитесь к людям. Вам нравится «читать» их лицаи «заглядывать» в их будущее, вы эмоционально отзывчивы, общительны, быстро устанавливаете контакты с окружающими и находите общий язык. Должно быть, и дети тянутся к вам. Окружающие ценят вашу душевность. Вы стараетесь недопускать конфликты и находить компромиссные решения. Хорошо переносите критику в свой адрес. В оценке событий больше доверяете своим чувствам иинтуиции, чем аналитическим выводам. Предпочитаете работать с людьми, нежели в одиночку. Постоянно нуждаетесь в социальном одобрении своих действий. При всех перечисленных качествах вы не всегда аккуратны в точной и кропотливой работе. Не стоит особого труда вы вести вас из равновесия.");
                        else
                            intent.putExtra("result", "High empathy. You are sensitive to the needs and problems of others, generous, and tend to forgive them a lot. Treat people with genuine interest. You like to 'read' their faces and 'look' into their future, you are emotionally responsive, sociable, quickly establish contacts with others and find a common language. The children must be drawn to you, too. Others appreciate your sincerity. You try to avoid conflicts and find compromise solutions. Take criticism well. In the assessment of events and more in touch with their feelings and intuition than analytical conclusions. You prefer to work with people rather than alone. You constantly need social approval for your actions. With all these qualities, you are not always accurate in accurate and painstaking work. It is not worth much effort you lead you out of balance.");
                    }else
                    if ((points >= 47) && (points <= 62)) {
                        if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                            intent.putExtra("result", "Нормальный уровень эмпатийности, присущий подавляющему большинству людей. Окружающие не могут назвать вас «толстокожим», но в тоже время вы не относитесь к числу особо чувствительных лиц. В межличностных отношениях судить о других более склонны по их поступкам, чем доверять своим личным впечатлениям. Вам не чужды эмоциональные проявления, но в большинстве своем они находятся под самоконтролем. В общении внимательны, стараетесь понять больше, чем сказано словами, но при излишнем влиянии чувств собеседника теряете терпение. Предпочитаете деликатно не высказывать свою точку зрения, не будучи уверенным, что она будет принята. При чтении художественных произведений и просмотре фильмов чаще следите за действием, чем за переживаниями героев. Затрудняетесь прогнозировать развити еотношений между людьми, поэтому, случается, что их поступки оказываются для вас неожиданными. У вас нет раскованности чувств, и этомешает вашему полноценному восприятию людей.");
                        else
                            intent.putExtra("result", "Normal level of empathy, inherent in the vast majority of people. Others may not call you 'thick-skinned', but at the same time you do not belong to the number of particularly sensitive persons. In interpersonal relationships, people are more likely to judge others by their actions than to trust their personal impressions. You are no stranger to emotional manifestations, but most of them are under self-control. In communication, you are attentive, try to understand more than what is said in words, but if you are too influenced by the feelings of the interlocutor, you lose patience. You prefer not to Express your point of view delicately, without being sure that it will be accepted. When reading fiction and watching movies, follow the action more often than the experiences of the characters. You find it difficult to predict the development of relationships between people, so it happens that their actions are unexpected for you. You have no looseness of feeling, and this interferes with your full perception of people.");
                    }else
                    if ((points >= 12) && (points <= 46)) {
                        if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                            intent.putExtra("result", "Низкий уровень эмпатийности. Вы испытываете затруднения в установлении контактов слюдьми, неуютно чувствуете себя в большой компании. Эмоциональные проявления в поступках окружающих подчас кажутся Вам непонятными и лишенными смысла. Отдаете предпочтение уединенным занятиям конкретным делом, а не работе с людьми. Вы – сторонник точных формулировок и рациональных решений. Вероятно, у вас мало друзей, а из тех, кто есть, цените больше за деловые качества и ясный ум, чем за чуткость и отзывчивость. Люди платят вам темже. Бывает, когда чувствуете свою отчужденность, окружающие не слишком жалуют вас вниманием. Но это поправимо, если вы раскроете панцирь и станете пристальнее всматриваться в поведение близких и принимать их проблемы как свои.");
                        else
                            intent.putExtra("result", "Low level of empathy. You have difficulties in establishing contacts with mica, you feel uncomfortable in a large company. Emotional manifestations in the actions of others sometimes seem incomprehensible and meaningless to You. You prefer to do a specific thing in private, rather than work with people. You are a proponent of precise formulations and rational solutions. You probably have few friends, and of those who do, you value more for business qualities and a clear mind than for sensitivity and responsiveness. People pay you the same. Sometimes, when you feel alienated, others do not give you too much attention. But this can be corrected if you open your shell and begin to look more closely at the behavior of your loved ones and accept their problems as your own.");
                    }else {
                        if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
                            intent.putExtra("result", "Очень низкий уровень. Эмпатийные тенденции личности неразвиты. Затрудняетесь первым начать разговор, держитесь особняком среди сослуживцев. Особенно трудны контакты с детьми и лицами, которые намного старше вас. В межличностных отношениях нередко оказываетесь в неловком положении. Во многом не находите взаимопонимания с окружающими. Любите острые ощущения, спортивные состязания предпочитаете искусству. В деятельности слишком сконцентрированы на себе. Вы можете быть очень продуктивны в индивидуальной работе, во взаимодействии же с другими не всегда вы глядите в лучшем свете. Болезненно переносите критику в свой адрес, хотя можете на нее бурно не реагировать. Необходима гимнастика чувств.");
                        else
                            intent.putExtra("result", "Very low level. The empathic tendencies of the individual are undeveloped. If you find it difficult to start a conversation first, keep to yourself among your colleagues. Especially difficult are contacts with children and people who are much older than you. In interpersonal relationships, you often find yourself in an awkward position. In many ways, you do not find mutual understanding with others. You like thrills, you prefer sports to art. They are too self-centered in their activities. You can be very productive in individual work, but when you interact with others, you don't always look in the best light. Painfully transfer criticism to your address, although you can not react violently to it. It is necessary to exercise the senses.");
                    }
                    intent.putExtra("small", small);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void setQuestionScreen(int number){
        question.setText(questionItem6s.get(number).getQuestion());
        count.setText((number+1) + "/" + questionItem6s.size());
        button_A.setText(questionItem6s.get(number).getAnswA());
        button_B.setText(questionItem6s.get(number).getAnswB());
        button_C.setText(questionItem6s.get(number).getAnswC());
        button_D.setText(questionItem6s.get(number).getAnswD());
        button_E.setText(questionItem6s.get(number).getAnswE());
        button_F.setText(questionItem6s.get(number).getAnswF());
    }

    private void loadAllQuestions(){
        questionItem6s = new ArrayList<>();
        String jsonStr;

        //load all questions into json string
        if (getResources().getConfiguration().locale.getLanguage().equals("ru"))
            jsonStr = loadJSONFromAssert("ru/yusupov_test");
        else
            jsonStr = loadJSONFromAssert("en/yusupov_test_en");

        //load all data into list
        try{
            JSONObject jsonObj = new JSONObject(jsonStr);
            JSONArray questions = jsonObj.getJSONArray("questions");

            for (int i = 0; i < questions.length(); i++){
                String answerAString, answerBString, answerCString, answerDString, answerEString, answerFString;
                Integer scoreAString, scoreBString, scoreCString, scoreDString, scoreEString, scoreFString;

                JSONObject question = questions.getJSONObject(i);
                JSONObject ansA, ansB, ansC, ansD, ansE, ansF;
                ansA = question.getJSONObject("A");
                ansB = question.getJSONObject("B");
                ansC = question.getJSONObject("C");
                ansD = question.getJSONObject("D");
                ansE = question.getJSONObject("E");
                ansF = question.getJSONObject("F");


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

                answerFString = ansF.getString("answer");
                scoreFString = ansF.getInt("score");

                questionItem6s.add(new QuestionItem6(
                        questionString,
                        answerAString,
                        answerBString,
                        answerCString,
                        answerDString,
                        answerEString,
                        answerFString,
                        scoreAString,
                        scoreBString,
                        scoreCString,
                        scoreDString,
                        scoreEString,
                        scoreFString
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
