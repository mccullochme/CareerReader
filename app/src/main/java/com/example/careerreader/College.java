package com.example.careerreader;

public class College {
    private String fieldOfStudy = "";
    private String environment = "";
    private String type = "";
    private int size = 0;
    private int tuition = 0;


    public College (String fieldOfStudy, String environment, String type, int size, int tuition){
        this.fieldOfStudy = fieldOfStudy;
        this.environment = environment;
        this.type = type;
        this.size = size;
        this.tuition = tuition;
    }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTuition() {
        return tuition;
    }

    public void setTuition(int tuition) {
        this.tuition = tuition;
    }

}
