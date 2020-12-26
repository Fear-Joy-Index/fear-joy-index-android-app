package ru.nsu.fit.joyandfear.ui.tests.question_item;

public class QuestionItem3 {

    String question, answA, answB, answC;
    Integer scoreA, scoreB, scoreC;

    public QuestionItem3(String question, String answA, String answB, String answC, Integer scoreA, Integer scoreB, Integer scoreC) {
        this.question = question;
        this.answA = answA;
        this.answB = answB;
        this.answC = answC;
        this.scoreA = scoreA;
        this.scoreB = scoreB;
        this.scoreC = scoreC;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswA() {
        return answA;
    }

    public String getAnswB() {
        return answB;
    }

    public String getAnswC() {
        return answC;
    }

    public Integer getScoreA() {
        return scoreA;
    }

    public Integer getScoreB() {
        return scoreB;
    }

    public Integer getScoreC() {
        return scoreC;
    }

}
