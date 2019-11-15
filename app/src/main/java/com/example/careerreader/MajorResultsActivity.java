package com.example.careerreader;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;


public class MajorResultsActivity extends AppCompatActivity {

    ArrayList<String> compFields = new ArrayList<String>();
    ArrayList<String> words = new ArrayList<String>();
    String major = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_major);
        //gets String array with compatible fields of study
        TextView startText = (TextView) findViewById(R.id.textView3);
        TextView majorText = (TextView) findViewById(R.id.textView4);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            compFields = getIntent().getExtras().getStringArrayList("fieldOfStudyList");
        }
        readIn();
        for(int i = 0 ; i<compFields.size();i++)
        {
            System.out.println("HELLO" + compFields.size()+ compFields.get(i));
            for(int j = 0; j< words.size();j++)
            {
                if(compFields.get(i).equals(words.get(j)))
                {

                    for(int k = j+1; k<=j+10;k++)
                    {
                        major = major + "\n" + words.get(k);

                    }
                }
            }
        }
        majorText.setText(major);

        /**
         * IGNORE THIS I made this to test my class to print the compatible FieldOfStudy
         */
        String temp = "";
        for (String fields : compFields) {
            temp += fields;
        }
        startText.setText(temp);

    }

    public String getMajor(FieldOfStudy fStudy) throws IOException {
        String major = "";
        //major = readIn();
        return major;
    }

    public void readIn()
    {
        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(getAssets().open("Majors.txt"), StandardCharsets.UTF_8));
            String line = "";
            int i = 0;
            line = br.readLine();
            while(br.ready())
            {
                words.add(line);
                i++;
                line = br.readLine();
            }

}
        catch (IOException e)
        {
            System.out.println("not working" + e);
        }
        }
    }