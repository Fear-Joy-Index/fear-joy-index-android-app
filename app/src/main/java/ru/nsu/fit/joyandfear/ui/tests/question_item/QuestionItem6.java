package ru.nsu.fit.joyandfear.ui.tests.question_item;

public class QuestionItem6 {

    String question, answA, answB, answC, answD, answE, answF;
    Integer scoreA, scoreB, scoreC, scoreD, scoreE, scoreF;

    public QuestionItem6(String question, String answA, String answB, String answC, String answD, String answE, String answF, Integer scoreA, Integer scoreB, Integer scoreC, Integer scoreD, Integer scoreE, Integer scoreF) {
        this.question = question;
        this.answA = answA;
        this.answB = answB;
        this.answC = answC;
        this.answD = answD;
        this.answE = answE;
        this.answF = answF;
        this.scoreA = scoreA;
        this.scoreB = scoreB;
        this.scoreC = scoreC;
        this.scoreD = scoreD;
        this.scoreE = scoreE;
        this.scoreF = scoreF;
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

    public String getAnswE() {
        return answE;
    }

    public Integer getScoreE() {
        return scoreE;
    }

    public String getAnswF() { return answF; }

    public Integer getScoreF() {
        return scoreF;
    }
}
