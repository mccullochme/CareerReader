package com.example.careerreader;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.assertion.ViewAssertions.selectedDescendantsMatch;
import static androidx.test.espresso.matcher.ViewMatchers.isNotChecked;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.util.EspressoOptional;
import androidx.test.rule.ActivityTestRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);



    @Test
    public void testButton(){
        /*
        Select College
        Scenario 1
        * This test, tests the FindCollegeButton that will then
        take you to the next page where you are prompt to select major
        */
        onView(withId(R.id.FindCollegeButton)).perform(click());
    }
    @Test
    public void testSelectMajorBox(){
        /*
        Select College
        Scenario 2
        * This test, tests the ability to select a major by clicking on a checkbox
        */
        onView(withId(R.id.FindCollegeButton)).perform(click());
        onView(withId(R.id.mathBox)).check(matches(isNotChecked())).perform(scrollTo(), click());
    }
    @Test
    public void testSelectAllMajors(){
        /*
        Select College
        Scenario 3
        * This test, tests the ability to select a major by clicking on a checkbox
        */
        onView(withId(R.id.FindCollegeButton)).perform(click());
        onView(withId(R.id.mathBox)).check(matches(isNotChecked())).perform(scrollTo(), click());
        onView(withId(R.id.scienceBox)).check(matches(isNotChecked())).perform(scrollTo(), click());
        onView(withId(R.id.historyBox)).check(matches(isNotChecked())).perform(scrollTo(), click());
        onView(withId(R.id.englishBox)).check(matches(isNotChecked())).perform(scrollTo(), click());
        onView(withId(R.id.artBox)).check(matches(isNotChecked())).perform(scrollTo(), click());
    }

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }
}