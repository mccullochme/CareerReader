package com.example.careerreader;

public class CareerFacade
{
    private final College college;
    private final FieldOfStudy fieldOfStudy;

    public CareerFacade()
    {
        this.college = new College();
        this.fieldOfStudy = new FieldOfStudy();
    }

    public void find() {
        college.setFieldOfStudy("ART");
        college.setEnvironment("rural");
        college.setType("Public");
        college.setSize(10000);
        college.setTuition(30000);

        fieldOfStudy.setName("STEM");
    }

}

class random
{
    public static void main(String[] args)
    {
        CareerFacade yourCareer = new CareerFacade();
        yourCareer.find();

    }
}
