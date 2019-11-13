package com.example.careerreader;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class MajorSelectionScreen extends AppCompatActivity {

    LinearLayout viewLinLay;
    ArrayList<FieldOfStudy> fosList = new ArrayList<FieldOfStudy>();
    ArrayList<FieldOfStudy> resultList = new ArrayList<FieldOfStudy>();

    FieldOfStudy STEM = new FieldOfStudy("STEM", 0);
    FieldOfStudy socSci = new FieldOfStudy("Social Science", 0);
    FieldOfStudy business = new FieldOfStudy("Business", 0);
    FieldOfStudy health = new FieldOfStudy("Health", 0);
    FieldOfStudy art = new FieldOfStudy("Art", 0);

    ArrayList<String> compFOSList = new ArrayList<String>();

    int numChecked = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_major_selection_screen);
        viewLinLay = findViewById(R.id.linLay);

        try {
            generateQuestions();
        } catch(IOException e){
            throw new RuntimeException(e);
        }

    }

    public void backButton(View view){
        Intent goBack = new Intent(MajorSelectionScreen.this , MainActivity.class);
        startActivity(goBack);
    }

    public void submitButton(View view){

        if (allChecked()) {
            getCompatibleField();
            Intent intentNext = new Intent(MajorSelectionScreen.this , MajorResultsActivity.class);
            intentNext.putExtra("fieldOfStudyList", compFOSList);
            startActivity(intentNext);
        }
    }

    public boolean allChecked(){
        boolean allChecked = false;
        return allChecked;
    }


    public void generateQuestions() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(getAssets().open("questions.txt"), StandardCharsets.UTF_8));
        int radioGroupNum = 1;
        while(br.ready()){

            //creates textView with corresponding information
            TextView tv = new TextView(this);
            String strng = br.readLine();
            tv.setText(strng);
            viewLinLay.addView(tv);

            //creates radioGroup with horizontal layout
            RadioGroup rg = new RadioGroup(this);
            rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedID) {
                    onRadioButtonClicked(group, checkedID);
                }
            });

            //assigns radioGroup with correct tag
            if(radioGroupNum <= 5){
                rg.setTag("STEM");
            }
            else if(radioGroupNum <= 10){
                rg.setTag("SocialScience");
            }
            else if(radioGroupNum <= 15){
                rg.setTag("Business");
            }
            else if(radioGroupNum <= 20){
                rg.setTag("Health");
            }
            else if(radioGroupNum <= 25){
                rg.setTag("Art");
            }
            rg.setId(radioGroupNum);
            rg.setOrientation(LinearLayout.HORIZONTAL);
            viewLinLay.addView(rg);

            //creates 5 radioButtons per radioGroup and onClickListener for each radioButton
            int numButtons = 5;
            for(int i = 0; i < numButtons; i++) {
                RadioButton rdbtn = new RadioButton(this);
                rg.addView(rdbtn);
            }
            radioGroupNum++;
        }
    }



    //method that is called when a radioButton is clicked
    public void onRadioButtonClicked(RadioGroup group, int checkedID){
        System.out.println("wow"+ checkedID);
        numChecked++;
        if(group.getTag().equals("STEM")){
            STEM.setTotal(STEM.getTotal() + checkedID/group.getId());
            System.out.println("wow"+ group.getTag());
        }
        else if(group.getTag().equals("SocialScience")){
            socSci.setTotal(socSci.getTotal() + checkedID/group.getId());
            System.out.println("wow"+ group.getTag());
        }
        else if(group.getTag().equals("Business")){
            business.setTotal(business.getTotal() + checkedID/group.getId());
            System.out.println("wow"+ group.getTag());
        }
        else if(group.getTag().equals("Health")){
            health.setTotal(business.getTotal() + checkedID/group.getId());
            System.out.println("wow"+ group.getTag());
        }
        else if(group.getTag().equals("Art")){
            art.setTotal(art.getTotal() + checkedID/group.getId());
            System.out.println("wow"+ group.getTag());
        }

    }

    //compares the total of each field and places the corresponding string into compFOSList
    public ArrayList<String> getCompatibleField(){

        fosList.add(STEM);
        fosList.add(socSci);
        fosList.add(business);
        fosList.add(health);
        fosList.add(art);

        FieldOfStudy bestFOS = fosList.get(0);
        int highNum = 0;

        for(int i = 0; i < fosList.size()-1; i++) {
            int next = i + 1;
            highNum = bestFOS.getTotal();
            if (highNum < fosList.get(next).getTotal()) {
                highNum = fosList.get(next).getTotal();
                bestFOS = fosList.get(next);
            }
        }
        for(FieldOfStudy fos: fosList){
            if(fos.getTotal() == highNum){
                compFOSList.add(bestFOS.getName());
            }
        }


        return compFOSList;
    }

}
