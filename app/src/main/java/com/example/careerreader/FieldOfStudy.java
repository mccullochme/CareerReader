package com.example.careerreader;

import java.util.ArrayList;

public class FieldOfStudy {
    private int total = 0;
    private String name = "";
    private ArrayList<Question> qList;

    public FieldOfStudy (String name, int total, ArrayList<Question> qList){
        this.name = name;
        this.total = total;
        this.qList = qList;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Question> getqList() {
        return qList;
    }

    public void setqList(ArrayList<Question> qList) {
        this.qList = qList;
    }
}
