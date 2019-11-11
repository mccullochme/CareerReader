package com.example.careerreader;

import androidx.appcompat.app.AppCompatActivity;

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

    public void generateQuestions() throws IOException{

        ArrayList<RadioButton> rbList = new ArrayList<RadioButton>();
        BufferedReader br = new BufferedReader(new InputStreamReader(getAssets().open("questions.txt"), StandardCharsets.UTF_8));

        while(br.ready()){

            //creates textView with corresponding information
            TextView tv = new TextView(this);
            String strng = br.readLine();
            tv.setText(strng);
            this.viewLinLay.addView(tv);

            //creates radioGroup with horizontal layout
            RadioGroup rg = new RadioGroup(this);
            rg.setOrientation(LinearLayout.HORIZONTAL);
            viewLinLay.addView(rg);

            //creates 5 radioButtons per radioGroup
            int num = 5;
            for(int i = 0; i < num; i++) {
                RadioButton rdbtn = new RadioButton(this);
                rdbtn.setId(View.generateViewId());
                rbList.add(rdbtn);
                rg.addView(rdbtn);

            }
        }
    }


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

}
