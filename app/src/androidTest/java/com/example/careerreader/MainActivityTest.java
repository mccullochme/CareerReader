package com.example.careerreader;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isNotChecked;

import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.GeneralLocation;
import androidx.test.espresso.action.GeneralSwipeAction;
import androidx.test.espresso.action.Press;
import androidx.test.espresso.action.Swipe;
import androidx.test.espresso.action.ViewActions;
import androidx.test.rule.ActivityTestRule;
import org.junit.Rule;
import org.junit.Test;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withTagKey;
import static androidx.test.espresso.matcher.ViewMatchers.withTagValue;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.AllOf.allOf;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    public static ViewAction swipeUpFaster() {
        return new GeneralSwipeAction(Swipe.FAST, GeneralLocation.BOTTOM_CENTER,
                GeneralLocation.TOP_CENTER, Press.FINGER);
    }

    public static ViewAction swipeDownFaster() {
        return new GeneralSwipeAction(Swipe.FAST, GeneralLocation.TOP_CENTER,
                GeneralLocation.BOTTOM_CENTER, Press.FINGER);
    }
    //Milestone 1
    // User Story 1 Select College
    @Test
    public void testButtonToEnterSelection() {
        /*
        Select College
        Scenario 1
        This test, tests the FindCollegeButton that will then
        take you to the next page where you are prompt to select major
        */
        onView(withId(R.id.findCollegeButton)).perform(click());
    }

    @Test
    public void testSelectMajorBox() {
        /*
        Select College
        Scenario 2
        This test, tests the ability to select a major by clicking on a checkbox
        */
        onView(withId(R.id.findCollegeButton)).perform(click());
        onView(withId(R.id.stemBox)).check(matches(isNotChecked())).perform(scrollTo(), click());
        onView(withId(R.id.nextButton)).perform(ViewActions.scrollTo()).perform(click());
    }

    @Test
    public void testSelectAllMajors() {
        /*
        Select College
        Scenario 3
        This test, tests the ability to select a major by clicking on a checkbox
        */
        onView(withId(R.id.findCollegeButton)).perform(click());
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
        Select my most compatible major
        Scenario 1
        This test, tests the FindCollegeButton that will then
        take you to the next page where you are prompt to select a price range
        */
        onView(withId(R.id.findCollegeButton)).perform(click());
    }
    @Test
    public void testPriceRange1(){
        /*
        Select College By Price
        Scenario 2
        This tests the ability to select a college in the price range between $20,00-30,00
        */
        onView(withId(R.id.findCollegeButton)).perform(click());
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
        onView(withId(R.id.findCollegeButton)).perform(click());
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
        onView(withId(R.id.findCollegeButton)).perform(click());
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
        onView(withId(R.id.findCollegeButton)).perform(click());
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
        onView(withId(R.id.findCollegeButton)).perform(click());
        onView(withId(R.id.publicBox)).perform(ViewActions.scrollTo()).perform(click());
        onView(withId(R.id.privateBox)).perform(ViewActions.scrollTo()).perform(click());
        onView(withId(R.id.nextButton)).perform(ViewActions.scrollTo()).perform(click());
    }

    //Milestone 2
    // User Story 1 Select my most compatible major
    @Test
    public void testFindMajorButton() {
        /*
        Select my most compatible major
        Scenario 1
        This test, tests the Find a major button , then takes you
        to the next screen with the compatibility statements
        */
        onView(withId(R.id.findMajorButton)).perform(click());

    }

    @Test
    public void testStemOutput() {
        /*
        Select my most compatible major
        Scenario 2
        This tests the ability to select all the STEM related compatibility questions
        then clicks the submit button to be take to the next page where it'll show
        the top ten STEM majors
        */
        String val = "rb";
        onView(withId(R.id.findMajorButton)).perform(click());
        for (int i = 5; i <= 25; i = i + 5) {
            String pos = Integer.toString(i);
            val += pos;
            onView(allOf(withTagValue(is((Object) val)), isDisplayed())).perform(swipeUpFaster(),swipeUpFaster(), click());
            val = "rb";
        }
        //selects the remaining questions with the lowest value
        for (int i = 26; i <= 121; i = i + 5) {
            String pos = Integer.toString(i);
            val += pos;
            onView(allOf(withTagValue(is((Object) val)), isDisplayed()))
                    .perform(swipeUpFaster(), swipeUpFaster(), click());
            val = "rb";
        }
        onView(withId(R.id.button5)).perform(ViewActions.scrollTo()).perform(click());
    }

    @Test
    public void testAllMajorsOutput() {
        /*
        Select my most compatible major
        Scenario 3
        This tests the ability to select all the compatibility questions
        then clicks the submit button to be take to the next page where it'll show all
        majors
         */
        onView(withId(R.id.findMajorButton)).perform(click());
        String val = "rb";
        for(int i  = 5; i <=125; i = i + 5 ) {
            String pos = Integer.toString(i);
            val += pos;
            onView(allOf(withTagValue(is((Object) val)), isDisplayed()))
                    .perform(swipeUpFaster(), swipeUpFaster(), click());
            val = "rb";
        }
        onView(withId(R.id.button5)).perform(ViewActions.scrollTo()).perform(click());
    }


    // User Story 2 Find information about a given major
    @Test
    public void testArtLink(){
        /*
        Find information about a given major
        Scenario 1
        This test, tests the ability to select all the art compatibility questions
        then clicks the submit button to be take to the next page where it'll show all
        majors and then the user is able to click on the liberal studies link to a google search for that
        major
        */
        //this selects the lowest value buttons
        String val = "rb";
        onView(withId(R.id.findMajorButton)).perform(click());
        for(int j  = 1; j < 100; j = j + 5 ) {
            String pos = Integer.toString(j);
            val += pos;
            onView(allOf(withTagValue(is((Object) val)), isDisplayed()))
                    .perform(swipeUpFaster(), swipeUpFaster(),click());
            val = "rb";
        }
        //this selects the art questions with the highest value
        for(int i  = 105; i <=125; i = i + 5 ) {
            String pos = Integer.toString(i);
            val += pos;
            onView(allOf(withTagValue(is((Object) val)), isDisplayed())).perform(swipeUpFaster(), swipeUpFaster(),click());
            val = "rb";
        }
        //this return to the top and clicks on the submit button
        onView(withId(R.id.button5)).perform(ViewActions.scrollTo()).perform(click());
        onView(allOf(withTagValue(is((Object) "Liberal Studies")), isDisplayed())).perform(click());
    }
    @Test
    public void testStemLink(){
        /*
        Find information about a given major
        Scenario 2
        Find information about a given major
        This test, tests the ability to select all the STEM compatibility questions
        then clicks the submit button to be take to the next page where it'll show all
        majors and then the user is able to click on the petroleum engineering  link to a google search for that
        major
        */
        //this selects the first buttons with the highest value for STEM
        String val = "rb";
        onView(withId(R.id.findMajorButton)).perform(click());
        for (int i = 5; i <= 25; i = i + 5) {
            String pos = Integer.toString(i);
            val += pos;
            onView(allOf(withTagValue(is((Object) val)), isDisplayed())).perform(swipeUpFaster(),swipeUpFaster(), click());
            val = "rb";
        }
        //selects the remaining questions with the lowest value
        for (int i = 26; i <= 121; i = i + 5) {
            String pos = Integer.toString(i);
            val += pos;
            onView(allOf(withTagValue(is((Object) val)), isDisplayed()))
                    .perform(swipeUpFaster(), swipeUpFaster(), click());
            val = "rb";
        }
        //this returns to the top and clicks the submit button
        onView(withId(R.id.button5)).perform(ViewActions.scrollTo()).perform(click());
        onView(allOf(withTagValue(is((Object) "Petroleum Engineering")), isDisplayed())).perform(click());

    }
    @Test
    public void testBusinessLink(){
        /*
        Find information about a given major
        Scenario 3
        Find information about a given major
        This test, tests the ability to select all the business compatibility questions
        then clicks the submit button to be take to the next page where it'll show all
        majors and then the user is able to click on the entrepreneurship link to a google search for that
        major
        */
        //this selects the radio buttons with the lowest value
        String val = "rb";
        onView(withId(R.id.findMajorButton)).perform(click());
        for(int j  = 1; j < 50; j = j + 5 ) {
            String pos = Integer.toString(j);
            val += pos;
            onView(allOf(withTagValue(is((Object) val)), isDisplayed()))
                    .perform(swipeUpFaster(), swipeUpFaster(),click());
            val = "rb";
        }
        //clicks the business questions with the highest value
        for (int i = 55; i <= 75; i = i + 5) {
            String pos = Integer.toString(i);
            val += pos;
            onView(allOf(withTagValue(is((Object) val)), isDisplayed()))
                    .perform(swipeUpFaster(), swipeUpFaster(),click());
            val = "rb";
        }
        //this selects the rest of the radio buttons with the lowest value
        for (int k = 76; k <= 121; k = k + 5) {
            String pos = Integer.toString(k);
            val += pos;
            onView(allOf(withTagValue(is((Object) val)), isDisplayed()))
                    .perform(swipeUpFaster(), swipeUpFaster(),click());
            val = "rb";
        }
        //scrolls back to the top to click on the submit button
        onView(withId(R.id.button5)).perform(ViewActions.scrollTo()).perform(click());
        onView(allOf(withTagValue(is((Object) "Entrepreneurship")), isDisplayed())).perform(click());
    }

    // User Story 3 Find a college based off of major
    @Test
    public void testFindStemCollegeFunction(){
        /*
        Find a college based off of major preferences
        Scenario 1
        This test, tests the when "Find College" is clicked at bottom of
        screen of the STEM results page, then it shows possible colleges with corresponding
        STEM majors
        */
        //this clicks on the first 5 questions with the highest value for STEM
        String val = "rb";
        onView(withId(R.id.findMajorButton)).perform(click());
        for (int i = 5; i <= 25; i = i + 5) {
            String pos = Integer.toString(i);
            val += pos;
            onView(allOf(withTagValue(is((Object) val)), isDisplayed())).perform(swipeUpFaster(),swipeUpFaster(), click());
            val = "rb";
        }
        //selects the remaining questions with the lowest value
        for (int i = 26; i <= 121; i = i + 5) {
            String pos = Integer.toString(i);
            val += pos;
            onView(allOf(withTagValue(is((Object) val)), isDisplayed()))
                    .perform(swipeUpFaster(), swipeUpFaster(), click());
            val = "rb";
        }
        //this returns to the top and clicks the submit button
        onView(withId(R.id.button5)).perform(ViewActions.scrollTo()).perform(click());
        onView(withId(R.id.findCollegeWithMajor)).perform(ViewActions.scrollTo()).perform(click());
    }
    @Test
    public void testFindArtCollegeFunction(){
        /*
        Find a college based off of major
        Scenario 2
        This test, tests the when "Find College" is clicked at bottom of
        screen of the Art results page, then it shows possible colleges with corresponding
        Art majors
        */
        //this clicks the radio buttons before the desired questions with the lowest values
        String val = "rb";
        onView(withId(R.id.findMajorButton)).perform(click());
        for(int j  = 1; j < 100; j = j + 5 ) {
            String pos = Integer.toString(j);
            val += pos;
            onView(allOf(withTagValue(is((Object) val)), isDisplayed()))
                    .perform(swipeUpFaster(), swipeUpFaster(),click());
            val = "rb";
        }
        //this selects the radio buttons with the highest value for the art major
        for(int i  = 105; i <=125; i = i + 5 ) {
            String pos = Integer.toString(i);
            val += pos;
            onView(allOf(withTagValue(is((Object) val)), isDisplayed())).perform(swipeUpFaster(), swipeUpFaster(),click());
            val = "rb";
        }
        //this returns to the top to click the submit button
        onView(withId(R.id.button5)).perform(ViewActions.scrollTo()).perform(click());
        onView(withId(R.id.findCollegeWithMajor)).perform(ViewActions.scrollTo()).perform(click());
    }
    @Test
    public void testFindBusinessCollegeFunction(){
        /*
        Find a college based off of major
        Scenario 3
        This test, tests the when "Find College" is clicked at bottom of
        screen of the business results page, then it shows possible colleges with corresponding
        business majors
        */
        //this clicks lowest value radio buttons before reaching the desired ones
        String val = "rb";
        onView(withId(R.id.findMajorButton)).perform(click());
        for(int j  = 1; j < 50; j = j + 5 ) {
            String pos = Integer.toString(j);
            val += pos;
            onView(allOf(withTagValue(is((Object) val)), isDisplayed()))
                    .perform(swipeUpFaster(), swipeUpFaster(),click());
            val = "rb";
        }
        //clicks the business questions with the highest value
        for (int i = 55; i <= 75; i = i + 5) {
            String pos = Integer.toString(i);
            val += pos;
            onView(allOf(withTagValue(is((Object) val)), isDisplayed()))
                    .perform(swipeUpFaster(), swipeUpFaster(),click());
            val = "rb";
        }
        //this selects the rest of the radio buttons with the lowest value
        for (int k = 76; k <= 121; k = k + 5) {
            String pos = Integer.toString(k);
            val += pos;
            onView(allOf(withTagValue(is((Object) val)), isDisplayed()))
                    .perform(swipeUpFaster(), swipeUpFaster(),click());
            val = "rb";
        }
        //scroll back to the top to click on the submit button case
        onView(withId(R.id.button5)).perform(ViewActions.scrollTo()).perform(click());
        onView(withId(R.id.findCollegeWithMajor)).perform(ViewActions.scrollTo()).perform(click());
    }


}