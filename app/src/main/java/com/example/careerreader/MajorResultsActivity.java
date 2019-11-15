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
        Button button = findViewById(R.id.button6);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userCode = getCode();
                Intent intentNext = new Intent(MajorResultsActivity.this , ResultScreen.class);
                intentNext.putExtra("userCode", userCode);
                startActivity(intentNext);
            }
        });

        for(int i = 0 ; i<compFields.size();i++)
        {
            System.out.println("HELLO" + compFields.size()+ compFields.get(i));
            for(int j = 0; j< words.size();j++)
            {
                if(compFields.get(i).equals(words.get(j)))
                {
                    for(int k = j+1; k < j+10;k++)
                    {
                        final Button myButton = new Button(this);
                        myButton.setText(words.get(k));
                        myButton.setTag(words.get(k));
                        myButton.setOnClickListener(new View.OnClickListener(){
                            public void onClick(View v){
                                Intent intent = new Intent();
                                intent.setAction(Intent.ACTION_VIEW);
                                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                                try{
                                    intent.setData(Uri.parse(getMajorLink(myButton)));
                                }catch(IOException e){
                                    throw new RuntimeException(e);
                                }

                                startActivity(intent);
                            }
                        });
                        resultView.addView(myButton);
                    }
                }
            }
        }

        //sets heading of majorResultsScreen
        String temp = "Your compatible majors for your field(s) of study are: ";
        for (String fields : compFields) {
            temp += fields + ", ";
        }
        startText.setText(temp);

    }

    //gets corresponding link for major, to be searched in google
    public String getMajorLink(Button myButton)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(getAssets().open("majorLinks.txt"), StandardCharsets.UTF_8));
        String majorLink = "";
        String major = "";

        while(br.ready()){
            major = br.readLine();
            if(major.equals(myButton.getTag())){
                majorLink = br.readLine();
            }
        }
        return majorLink;
    }

    public String getCode(){
        String code = "";
        for(int i = 0; i<compFields.size();i++)
        {
            if(compFields.get(i).equals("STEM"))
            {
                code = code + "a";
            }
            if(compFields.get(i).equals("SocialScience"))
            {
                code = code + "b";
            }
            if(compFields.get(i).equals("Business"))
            {
                code = code + "c";
            }
            if(compFields.get(i).equals("Health"))
            {
                code = code + "d";
            }
            if(compFields.get(i).equals("Art"))
            {
                code = code + "e";
            }
        }
        return code;
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