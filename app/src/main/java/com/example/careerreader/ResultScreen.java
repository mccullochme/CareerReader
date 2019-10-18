package com.example.careerreader;
import android.widget.TextView;
import android.os.Bundle;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class ResultScreen extends AppCompatActivity {

    TextView sampleView;
    String sample2 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sampleView = findViewById(R.id.sampleText);
        sample2 = getIntent().getStringExtra("userCode");
        sampleView.setText(sample2);
    }

    //protected void onActivity
}
