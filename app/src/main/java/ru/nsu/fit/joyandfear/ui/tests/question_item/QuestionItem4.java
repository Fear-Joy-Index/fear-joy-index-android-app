package ru.nsu.fit.joyandfear.ui.tests.question_item;

public class QuestionItem4 {

    String question, answA, answB, answC, answD;
    Integer scoreA, scoreB, scoreC, scoreD;

    public QuestionItem4(String question, String answA, String answB, String answC, String answD, Integer scoreA, Integer scoreB, Integer scoreC, Integer scoreD) {
        this.question = question;
        this.answA = answA;
        this.answB = answB;
        this.answC = answC;
        this.answD = answD;
        this.scoreA = scoreA;
        this.scoreB = scoreB;
        this.scoreC = scoreC;
        this.scoreD = scoreD;
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

    public Integer getScoreA() {
        return scoreA;
    }

    public Integer getScoreB() {
        return scoreB;
    }

    public Integer getScoreC() {
        return scoreC;
    }

    public Integer getScoreD() {
        return scoreD;
    }
}
