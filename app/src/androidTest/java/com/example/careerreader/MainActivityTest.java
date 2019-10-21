package com.example.careerreader;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isNotChecked;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.action.ViewActions;
import androidx.test.rule.ActivityTestRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);


    // User Story 1 Select College
    @Test
    public void testButtonToEnterSelection(){
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
        onView(withId(R.id.stemBox)).check(matches(isNotChecked())).perform(scrollTo(), click());
        onView(withId(R.id.nextButton)).perform(ViewActions.scrollTo()).perform(click());
    }
    @Test
    public void testSelectAllMajors(){
        /*
        Select College
        Scenario 3
        * This test, tests the ability to select a major by clicking on a checkbox
        */
        onView(withId(R.id.FindCollegeButton)).perform(click());
        onView(withId(R.id.stemBox)).check(matches(isNotChecked())).perform(scrollTo(), click());
        onView(withId(R.id.socialScienceBox)).check(matches(isNotChecked())).perform(scrollTo(), click());
        onView(withId(R.id.businessBox)).check(matches(isNotChecked())).perform(scrollTo(), click());
        onView(withId(R.id.healthBox)).check(matches(isNotChecked())).perform(scrollTo(), click());
        onView(withId(R.id.artBox)).check(matches(isNotChecked())).perform(scrollTo(), click());
        onView(withId(R.id.nextButton)).perform(ViewActions.scrollTo()).perform(click());
    }
    // User Story 2 Select College
    @Test
    public void testFindCollegeButton(){
        /*
        Select College by price
        Scenario 1
        * This test, tests the FindCollegeButton that will then
        take you to the next page where you are prompt to select a price range
        */
        onView(withId(R.id.FindCollegeButton)).perform(click());
    }
    @Test
    public void testPriceRange1(){
        /*
        Select College By Price
        Scenario 2
        *
        This tests the ability to select a college in the price range between $20,00-30,00
        */
        onView(withId(R.id.FindCollegeButton)).perform(click());
        onView(withId(R.id.twentyToThirty)).perform(click());
        onView(withId(R.id.nextButton)).perform(ViewActions.scrollTo()).perform(click());
    }
    @Test
    public void testPriceRange2(){
        /*
        Select College By Price
        Scenario 3
        This tests the ability to select a college in the price range between $0-$20,00 and $40,00
        */
        onView(withId(R.id.FindCollegeButton)).perform(click());
        onView(withId(R.id.zeroToTwenty)).perform(click());
        onView(withId(R.id.fortyPlus)).perform(click());
        onView(withId(R.id.nextButton)).perform(ViewActions.scrollTo()).perform(click());
    }
    // User story 3 Find private or public colleges
    @Test
    public void testSelectingPrivateSchoolBox(){
        /*
        Find public or private colleges
        Scenario 1
        This test, tests the ability to select only private schools
        */
        onView(withId(R.id.FindCollegeButton)).perform(click());
        onView(withId(R.id.privateBox)).perform(ViewActions.scrollTo()).perform(click());
        onView(withId(R.id.nextButton)).perform(ViewActions.scrollTo()).perform(click());
    }
    @Test
    public void testSelectingPublicSchoolBox(){
        /*
        Find public or private colleges
        Scenario 2
        This test, tests the ability to select only public schools
        */
        onView(withId(R.id.FindCollegeButton)).perform(click());
        onView(withId(R.id.publicBox)).perform(ViewActions.scrollTo()).perform(click());
        onView(withId(R.id.nextButton)).perform(ViewActions.scrollTo()).perform(click());
    }
    @Test
    public void testSelectingPublicAndPrivate(){
        /*
        Find public or private colleges
        Scenario 3
        This test, tests the ability to select both public and private schools
        */
        onView(withId(R.id.FindCollegeButton)).perform(click());
        onView(withId(R.id.publicBox)).perform(ViewActions.scrollTo()).perform(click());
        onView(withId(R.id.privateBox)).perform(ViewActions.scrollTo()).perform(click());
        onView(withId(R.id.nextButton)).perform(ViewActions.scrollTo()).perform(click());
    }

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }
}