package com.example.careerreader;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;


public class MajorResultsActivity extends AppCompatActivity {

    ArrayList<String> compFields = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_major);
        TextView startText = (TextView) findViewById(R.id.textView3);

        //gets String array with compatible fields of study
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            compFields = getIntent().getExtras().getStringArrayList("fieldOfStudyList");
        }

        /**
         * IGNORE THIS I made this to test my class to print the compatible FieldOfStudy
         */
        String temp = "";
        for(String fields: compFields){
            temp += fields;
        }
        startText.setText(temp);
    }

    public String getMajor(FieldOfStudy fStudy)throws IOException{
        String major = "";
        //major = readIn();
        return major;
    }

    public static String readIn(String in) throws IOException{
        File f1=new File("Majors.txt");
        String[] words=null;
        FileReader fr = new FileReader(f1);
        BufferedReader br = new BufferedReader(fr);
        String s;
        String input=in;
        String word = "";
        while((s=br.readLine())!=null)
        {
            words=s.split(" ");
            for(int i = 0 ; i < words.length ; i++)
            {

                if (input.equals(words[i]))
                {
                    word = words[i];
                    return word;
                }
            }
        }
        fr.close();
    return null;
    }

}
