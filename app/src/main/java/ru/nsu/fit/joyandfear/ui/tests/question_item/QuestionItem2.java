package ru.nsu.fit.joyandfear.ui.tests.question_item;

public class QuestionItem2 {

    String question, answA, answB;
    Integer scoreA, scoreB;

    public QuestionItem2(String question, String answA, String answB, Integer scoreA, Integer scoreB) {
        this.question = question;
        this.answA = answA;
        this.answB = answB;
        this.scoreA = scoreA;
        this.scoreB = scoreB;
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

    public Integer getScoreA() {
        return scoreA;
    }

    public Integer getScoreB() {
        return scoreB;
    }



}
