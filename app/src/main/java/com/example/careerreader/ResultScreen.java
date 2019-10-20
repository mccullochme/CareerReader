package com.example.careerreader;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.os.Bundle;
import android.content.Intent;

public class ResultScreen extends AppCompatActivity {
    TextView sampleView;
    String sample2 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_screen2);
        sampleView = findViewById(R.id.sampleText);
        sample2 = getIntent().getExtras() .getString("userCode");
        sampleView.setText(sample2);


    }
}
