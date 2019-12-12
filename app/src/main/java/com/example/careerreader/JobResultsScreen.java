package com.example.careerreader;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class JobResultsScreen extends AppCompatActivity {
    public static ArrayList<Job> jobArrayList = new ArrayList<Job>();
    private ArrayList<Button> savedJobsList = new ArrayList<Button>();
    LinearLayout resultsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_results_screen);

        Bundle bundle = getIntent().getExtras();

        String searchVal = bundle.getString("jobSearch");
        String searchJobState = bundle.getString("stateFilt");
        String searchJobType = bundle.getString("jobTypeFilt");
        String minSalary = bundle.getString("minSalary");

        searchScraper(searchVal, searchJobState, searchJobType, minSalary);

        resultsView = findViewById(R.id.resultsList);

    }

    public void populateResults(){
        for(Job job: jobArrayList) {
            Button jobButton = new Button(this);
            String newLine = "\n";
            jobButton.setText(job.getTitle() + newLine + newLine + job.getCompany());
            Drawable background = getDrawable(R.drawable.rounded_button);
            jobButton.setBackground(background);
            LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            lParams.setMargins(0, 0, 0, 35);
            jobButton.setTextColor(Color.parseColor("#FFFFFF"));
            jobButton.setLayoutParams(lParams);

            final String url = job.getUrl();
            jobButton.setTag(url);
            jobButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.addCategory(Intent.CATEGORY_BROWSABLE);
                    try {
                        intent.setData(Uri.parse(url));
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }

                    startActivity(intent);
                }
            });
//            jobButton.setOnLongClickListener(new View.OnLongClickListener() {
//                @Override
//                public boolean onLongClick(View view) {
//                    onJobButtonLongClick(view);
//                    return true;
//                }
//            });
            resultsView.addView(jobButton);
            jobArrayList = new ArrayList<Job>();
        }
    }

    public ArrayList<Button> getArrayList(String key){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        Gson gson = new Gson();
        String json = prefs.getString(key, null);
        Type type = new TypeToken<ArrayList<Button>>() {}.getType();
        return gson.fromJson(json, type);
    }

//    public void printJobs(){
//        ArrayList<Button> savedJobs = getArrayList("savedJobs");
//        for(Button x: savedJobs){
//            System.out.println("wow" + x.getText());
//        }
//    }

//    public void onJobButtonLongClick (View v){
//        Button savedButton = (Button)v;
//        if(savedJobsList.contains(savedButton)){
//            savedJobsList.remove(savedButton);
//            Toast t = Toast.makeText(this, "Job Unsaved!", Toast.LENGTH_LONG);
//            t.show();
//        }
//        else{
//            savedJobsList.add(savedButton);
//            Toast t = Toast.makeText(this, "Job Saved!", Toast.LENGTH_LONG);
//            t.show();
//        }
//        saveArrayList(savedJobsList, "savedJobs");
//    }

//    public void saveArrayList(ArrayList<Button> list, String key){
//        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
//        SharedPreferences.Editor editor = prefs.edit();
//        Gson gson = new Gson();
//        String json = gson.toJson(list);
//        editor.putString(key, json);
//        editor.apply();     // This line is IMPORTANT !!!
//    }

    public void searchScraper(String jobVal, String jobState, String jobType, String minSalary){
        SimplyHiredScraper scraper = new SimplyHiredScraper() {
            @Override
            protected void onPostExecute(ArrayList<Job> jobs) {
                try{
                    jobArrayList.addAll(jobs);
                    populateResults();
                }catch(Exception e){
                    System.out.println("Results for scraper not working");
                }
            }
        };
        scraper.execute(jobVal, jobState, jobType, minSalary);
    }
}
