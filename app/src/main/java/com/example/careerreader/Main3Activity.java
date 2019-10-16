package com.example.careerreader;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

import android.os.Bundle;
import android.widget.CheckBox;

public class Main3Activity extends AppCompatActivity {


    private String userCode = "";
    final private CheckBox math = findViewById(R.id.mathBox);
    final private CheckBox science = findViewById(R.id.scienceBox);
    final private CheckBox history = findViewById(R.id.historyBox);
    final private CheckBox englsih = findViewById(R.id.englishBox);
    final private CheckBox art = findViewById(R.id.artBox);
    final private CheckBox zeroToFive = findViewById(R.id.zeroToFive);
    final private CheckBox fiveToTen = findViewById(R.id.fiveToTen);
    final private CheckBox tenToTwenty = findViewById(R.id.tenToTwenty);
    final private CheckBox twentyPlus = findViewById(R.id.twentyPlus);
    final private CheckBox rural = findViewById(R.id.ruralBox);
    final private CheckBox subUrban = findViewById(R.id.suburbanBox);
    final private CheckBox urban = findViewById(R.id.urbanBox);
    final private CheckBox small = findViewById(R.id.smallBox);
    final private CheckBox medium = findViewById(R.id.mediumBox);
    final private CheckBox large = findViewById(R.id.largeBox);
    final private CheckBox publicC = findViewById(R.id.publicBox);
    final private CheckBox privateC = findViewById(R.id.privateBox);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Button backButton = findViewById(R.id.backButton);
        if(math.isChecked())
        {
            userCode = userCode + "a";
        }
        if(science.isChecked())
        {
            userCode = userCode + "b";
        }
        if(history.isChecked())
        {
            userCode = userCode + "c";
        }if(englsih.isChecked())
        {
            userCode = userCode + "d";
        }
        if(art.isChecked())
        {
            userCode = userCode + "e";
        }
        if(zeroToFive.isChecked())
        {
            userCode = userCode + "f";
        }
        if(fiveToTen.isChecked())
        {
            userCode = userCode + "g";
        }
        if(tenToTwenty.isChecked())
        {
            userCode = userCode + "h";
        }
        if(twentyPlus.isChecked())
        {
            userCode = userCode + "i";
        }
        if(rural.isChecked())
        {
            userCode = userCode + "j";
        }
        if(subUrban.isChecked())
        {
            userCode = userCode + "k";
        }
        if(urban.isChecked())
        {
            userCode = userCode + "l";
        }
        if(small.isChecked())
        {
            userCode = userCode + "m";
        }
        if(medium.isChecked())
        {
            userCode = userCode + "n";
        }
        if(large.isChecked())
        {
            userCode = userCode + "o";
        }
        if(publicC.isChecked())
        {
            userCode = userCode + "p";
        }
        if(privateC.isChecked())
        {
            userCode = userCode + "q";
        }

    }

    public void goBack(View view)
    {
        Intent intent = new Intent(Main3Activity.this , MainActivity.class);
        startActivity(intent);
    }





}
