package com.example.careerreader;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
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
    LinearLayout resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_major);
        //gets String array with compatible fields of study
        TextView startText = (TextView) findViewById(R.id.textView3);
        resultView = findViewById(R.id.resultVIEW);

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
                    for(int k = j+1; k < j+10;k++)
                    {
//                        major = major + "\n" + words.get(k);
                        final Button myButton = new Button(this);
                        myButton.setText(words.get(k));
                        myButton.setOnClickListener(new View.OnClickListener(){
                            public void onClick(View v){
                                Intent intent = new Intent();
                                intent.setAction(Intent.ACTION_VIEW);
                                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                                intent.setData(Uri.parse());
                                startActivity(intent);
                            }
                        });
                        myButton.setTag();
                        resultView.addView(myButton);
                    }
                }
            }
        }

        /**
         * IGNORE THIS I made this to test my class to print the compatible FieldOfStudy
         */
        String temp = "";
        for (String fields : compFields) {
            temp += fields;
        }
        startText.setText(temp);

    }
    public void getMajorLink(Button myButton){

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse());
        startActivity(intent);
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