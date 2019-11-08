package com.example.careerreader;

public class Question {
    private int value = 0;
    private String question = "";

    public Question (int value, String question){
        this.value = value;
        this.question = question;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
