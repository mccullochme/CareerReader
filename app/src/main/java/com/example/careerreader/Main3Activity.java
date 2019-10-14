package com.example.careerreader;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

import android.os.Bundle;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Button backButton = findViewById(R.id.backButton);
    }

    public void goBack(View view)
    {
        Intent intent = new Intent(Main3Activity.this , MainActivity.class);
        startActivity(intent);
    }


}
