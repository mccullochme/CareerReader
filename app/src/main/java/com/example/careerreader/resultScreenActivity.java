package com.example.careerreader;
import android.widget.TextView;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class resultScreenActivity extends AppCompatActivity {

    TextView sample;
    String sample2 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sample = findViewById(R.id.textView4);
    }
    protected void onActivityResult(){
        sample2 = data.getExtras().getString("userCode");
    }

}
