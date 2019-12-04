package com.example.careerreader;

public class Job {
    private String title = "";
    private String location = "";
    private double pay = 0;

    public Job(String Title, String Location, double Pay)
    {
        this.title = Title;
        this.location = Location;
        this.pay = Pay;
    }
    public Job()
    {
        this.title = "";
        this.location = "";
        this.pay = 0;
    }

    public String getTitle()
    {
        return  this.title;
    }

    public double getPay() {
        return pay;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
