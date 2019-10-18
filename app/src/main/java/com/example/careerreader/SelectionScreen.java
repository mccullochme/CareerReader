package com.example.careerreader;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import java.util.ArrayList;

import android.os.Bundle;
import android.widget.CheckBox;

public class SelectionScreen extends AppCompatActivity {

    ArrayList<College> listOfC = new ArrayList<College>();

    /**
     * This is where all colleges will be stored
     */
    College VCU = new College("Art", 31360, "Urban", 24058, "Public", "Virginia Commonwealth University", "ehlop");

    String userCode = "";

    CheckBox math ;
    CheckBox science ;
    CheckBox history ;
    CheckBox english ;
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
        setContentView(R.layout.screen_selection);
        backButton = findViewById(R.id.backButton);
         math = findViewById(R.id.mathBox);
         science = findViewById(R.id.scienceBox);
         history = findViewById(R.id.historyBox);
         english = findViewById(R.id.englishBox);
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
        Intent intent = new Intent(SelectionScreen.this , MainActivity.class);
        startActivity(intent);
    }

    public void Next(View view){
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
        }if(english.isChecked())
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
        //array list of all colleges
        listOfC.add(VCU);

        Intent intentNext = new Intent(SelectionScreen.this , resultScreenActivity.class);
        intentNext.putExtra("userCode", userCode);
        startActivity(intentNext);


    }

}
