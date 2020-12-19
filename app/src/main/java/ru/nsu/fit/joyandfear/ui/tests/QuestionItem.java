package ru.nsu.fit.joyandfear.ui.tests;

public class QuestionItem {

    String question, answA, answB, answC, answD;
    Integer score;

    public QuestionItem(String question, String answA, String answB, String answC, String answD, Integer score) {
        this.question = question;
        this.answA = answA;
        this.answB = answB;
        this.answC = answC;
        this.answD = answD;
        this.score = score;
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

    public String getAnswD() {
        return answD;
    }

    public Integer getScore() {
        return score;
    }
}
