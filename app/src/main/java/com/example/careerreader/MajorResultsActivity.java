package com.example.careerreader;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


public class MajorResultsActivity extends AppCompatActivity {

    ArrayList<String> compFields = new ArrayList<String>();
    String[] words = null;
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

        String [] majors = new String[60];
        majors = readIn();
        for(int i = 0 ; i<compFields.size();i++)
        {
            for(int j = 0; j< 60;j++)
            {
                if(compFields.get(i).compareTo(majors[j]) ==0)
                {
                    for(int k = j+1; k<=j+10;k++)
                    {
                        major = major + majors[k];
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
//
//        String[] majors = readIn();
//        temp = "";
//        for(String major : majors)
//        {
//            temp += major;
//        }
//        majorText.setText("lebron");
    }

    public String getMajor(FieldOfStudy fStudy) throws IOException {
        String major = "";
        //major = readIn();
        return major;
    }

    public String[] readIn()
    {
        try
        {

            File f1 = new File("Majors.txt");
            FileReader fr = new FileReader(f1);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            int i = 0;
            while((line =br.readLine())!= null)
            {
                words[i] = line;
                i++;
            }

//            File f1 = new File("Majors.txt");
//            Scanner scnr = new Scanner(f1);
//            int i = 0;
//            while(scnr.hasNext())
//            {
//                words[i] = scnr.nextLine();
//            }
//        }
//        catch(IOException e)
//        {
//            System.out.println("not working " + e);
//        }
//        return words;
//    }


//    public String[] readIn() {
//        try {
//            File f1 = new File("Majors.txt");
//            Scanner scnr = new Scanner(f1);
//            FileReader fr = new FileReader(f1);
//            BufferedReader br = new BufferedReader(fr);
//            String word = "";
//        while((s=br.readLine())!=null) {
//            words = s.split(" ");
//            for (int i = 0; i < words.length; i++) {
//
//                if (input.equals(words[i])) {
//                    word = words[i];
//                    return word;
//////                }
//////            }
//////        }
//            for (int i = 0; i < compFields.size(); i++) {
//                String temp = ".";
//                temp = temp + compFields.get(i);
//                while (scnr.hasNext()) {
//                    String temp1 = scnr.nextLine();
//                    if (temp.compareTo(temp1) == 0) {
//                        int j = 0;
//                        while (j < 10) {
//                            word = scnr.nextLine();
//                            words[j] = word;
//                            System.out.println(word);
//                            j++;
//                        }
//                    }
//                }
//
//            }
//        }
//        catch (IOException e)
//        {
//            System.out.println(e);
//        }
//        return words;
//    }
}
        catch (IOException e)
        {
            System.out.println("not working" + e);
        }
        return words;
        }
    }