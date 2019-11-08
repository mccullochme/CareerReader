package com.example.careerreader;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

     String fieldOfStudy= "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView startText = (TextView) findViewById(R.id.textView5);
        fieldOfStudy = getIntent().getExtras().getString("fieldOfStudy");
        startText.setText("Based on your Responces here are the top 10 majors in" + fieldOfStudy);
    }
}
