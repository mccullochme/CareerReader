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
    College VCU = new College("Art", 21000, "Urban", 24058, "Public", "Virginia Commonwealth University", "ehlop");
    College ODU = new College("MATH", 16000, "Rural", 19606, "Public", "Old Dominion University", "aflop");
    College GMU = new College("Science", 19000, "Suburban", 23179, "Public", "George Mason University", "ehlop");
    College VTECH = new College("Math", 19000, "Rural", 25175, "Public", "Virginia Polytechnic University", "ehlop");
    College JMU = new College("History", 20000, "Rural", 19262, "Public", "James Madison University", "ehlop");
    College HAMPTON = new College("Sience", 34000, "Urban", 3793, "Private", "Hampton University", "ehlop");
    College LU = new College("Math", 25000, "Suburban", 46680, "Private", "Liberty University", "ehlop");
    College URVA = new College("Art", 25000, "Suburban", 3229, "Private", "University of Richmond", "ehlop");
    College RADFORD = new College("History", 17000, "Rural", 8426, "Public", "Radford University", "ehlop");
    College UVA = new College("Math", 19000, "Urban", 15963, "Public", "University of Virginia", "ehlop");
    //College JMU = new College( "")

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
         math = findViewById(R.id.stemBox);
         science = findViewById(R.id.socialScienceBox);
         history = findViewById(R.id.businessBox);
         english = findViewById(R.id.healthBox);
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

        userCode="";

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
        listOfC.add(ODU);
        listOfC.add(VTECH);
        listOfC.add(GMU);
        listOfC.add(JMU);
        listOfC.add(RADFORD);
        listOfC.add(URVA);
        listOfC.add(LU);
        listOfC.add(HAMPTON);
        listOfC.add(UVA);




        //finish adding all colleges to array list

        //compare userCode to the code of each college in the array list, to see if they match

        //then if the codes match .add it to a new array list that we will use to print out into the result screen

        Intent intentNext = new Intent(SelectionScreen.this , ResultScreen.class);
        intentNext.putExtra("userCode", userCode);
        startActivity(intentNext);

    }

}
