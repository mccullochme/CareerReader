package com.example.careerreader;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.os.Bundle;
import android.content.Intent;

import java.util.ArrayList;

public class ResultScreen extends AppCompatActivity {
    TextView sampleView;
    String sample2 = "";
    String sample3 = "";
    ArrayList<College> listOfC = new ArrayList<College>();
    ArrayList<College> finalArray = new ArrayList<College>();

    /**
     * This is where all colleges will be stored
     */
    College VCU = new College("Art", 31360, "Urban", 24058, "Public", "Virginia Commonwealth University", "ehlop");
    College ODU = new College("Health", 16000, "Rural", 19606, "Public", "Old Dominion University", "dfjop");
    College GMU = new College("Business", 19000, "Suburban", 23179, "Public", "George Mason University", "cfkop");
    College VTECH = new College("STEM", 19000, "Rural", 25175, "Public", "Virginia Polytechnic University", "afjop");
    College JMU = new College("Health", 20000, "Rural", 19262, "Public", "James Madison University", "bfjop");
    College HAMPTON = new College("STEM", 34000, "Urban", 3793, "Private", "Hampton University", "ahlmq");
    College LU = new College("Business", 25000, "Suburban", 46680, "Private", "Liberty University", "cgkoq");
    College URVA = new College("Business", 25000, "Suburban", 3229, "Private", "University of Richmond", "cgkmq");
    College RADFORD = new College("Social Science", 17000, "Rural", 8426, "Public", "Radford University", "bfjnp");
    College UVA = new College("STEM", 19000, "Urban", 15963, "Public", "University of Virginia", "aflop");
    //College JMU = new College( "")
    //College JMU = new College( ""

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_screen2);
        sampleView = findViewById(R.id.sampleText);
        sample2 = getIntent().getExtras() .getString("userCode");
        sampleView.setText(sample2);


        //array list of all colleges
        listOfC.add(VCU);

        for(int i = 0; i<listOfC.size();i++)
        {
            boolean includes = true;
            String temp = sample2;
            String chare = "";
            for(int j = 0; j<temp.length();j++)
            {
                chare = Character.toString(temp.charAt(j));
                if(!listOfC.get(i).getCode().contains(chare))
                {
                    includes = false;
                }
            }

            if(includes)
            {
                sample3 = sample3 + "\n"+  listOfC.get(i).getName() + "\n"+ "The Main Field of study is : " + listOfC.get(i).getFieldOfStudy()+ "\n"+ "The Tution and Fees Per Year : " +listOfC.get(i).getTuition()+ "\n"+ "Environment : " +listOfC.get(i).getEnvironment()+ "\n"+ "Size : " +listOfC.get(i).getSize() + "\n"+ "Type : " +listOfC.get(i).getType() + "\n" +"\n";
            }
}
        sampleView.setText(sample3);
 }
}
