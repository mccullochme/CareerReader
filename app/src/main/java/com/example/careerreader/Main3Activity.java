package com.example.careerreader;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

import android.os.Bundle;
import android.widget.CheckBox;

public class Main3Activity extends AppCompatActivity {


    String userCode = "";

    CheckBox math ;
    CheckBox science ;
    CheckBox history ;
    CheckBox englsih ;
    CheckBox art ;
    CheckBox zeroToFive ;
    CheckBox fiveToTen ;
    CheckBox tenToTwenty ;
    CheckBox twentyPlus ;
    CheckBox rural ;
    CheckBox subUrban ;
    CheckBox urban ;
    CheckBox small ;
    CheckBox medium ;
    CheckBox large ;
    CheckBox publicC ;
    CheckBox privateC ;
    Button backButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        backButton = findViewById(R.id.backButton);


       math = findViewById(R.id.mathBox);
        science = findViewById(R.id.scienceBox);
         history = findViewById(R.id.historyBox);
         englsih = findViewById(R.id.englishBox);
         art = findViewById(R.id.artBox);
         zeroToFive = findViewById(R.id.zeroToFive);
         fiveToTen = findViewById(R.id.fiveToTen);
         tenToTwenty = findViewById(R.id.tenToTwenty);
         twentyPlus = findViewById(R.id.twentyPlus);
         rural = findViewById(R.id.ruralBox);
        subUrban = findViewById(R.id.suburbanBox);
         urban = findViewById(R.id.urbanBox);
         small = findViewById(R.id.smallBox);
         medium = findViewById(R.id.mediumBox);
         large = findViewById(R.id.largeBox);
         publicC = findViewById(R.id.publicBox);
         privateC = findViewById(R.id.privateBox);




    }

    public void goBack(View view)
    {
        Intent intent = new Intent(Main3Activity.this , MainActivity.class);
        startActivity(intent);
    }
    public void Next(View view){
        Intent intent = new Intent(Main3Activity.this , resultsscreenActivity.class);
        startActivity(intent);

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


    if(userCode.){

    }

}
