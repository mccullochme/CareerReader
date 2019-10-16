package com.example.careerreader;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.util.EspressoOptional;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.*;

public class MainActivityTest {

    //@Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    public void testButton(){
        //to click the find college button
        Espresso.onView(withId(R.id.FindCollegeButton)).perform(click());

    }
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }
}