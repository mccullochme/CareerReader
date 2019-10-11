package com.example.careerreader;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Button findC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findC = findViewById(R.id.FindCollegeButton);
        findC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , Main3Activity.class);
                startActivity(intent);
            }
        });


    }


//    public void goBack(View view)
//    {
//        Intent intent = new Intent(this, MainActivity.class);
//        intent.putExtra("message", password);
//        setResult(RESULT_OK,intent);
//        finish();
//        // startActivity(intent);
//
//    }


}
