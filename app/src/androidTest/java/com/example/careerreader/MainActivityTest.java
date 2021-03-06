package com.example.careerreader;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isNotChecked;

import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.GeneralLocation;
import androidx.test.espresso.action.GeneralSwipeAction;
import androidx.test.espresso.action.Press;
import androidx.test.espresso.action.Swipe;
import androidx.test.espresso.action.ViewActions;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withTagValue;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.AllOf.allOf;

public class MainActivityTest {

    @Test
    public void ActivityTest2() {

    }


    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }



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

    //Milestone 3
    // User Story 1 Find job by type
    @Test
    public void testFullTimeJobFilter() {
        /*
        Filter to show only full time jobs
        Scenario 1
        This test, tests the ability to filter the job results
        to show only full time jobs.
        */
        onView(withId(R.id.findJobButton)).perform(click());
        onView(withId(R.id.jobText)).perform(typeText("Mechanical Engineer"));
        onView(withId(R.id.jobText)).perform(closeSoftKeyboard());
        onView(withId(R.id.filterButton)).perform(click());
        onData(anything()).atPosition(0).perform(click());
        onData(anything()).atPosition(2).perform(click());
        onView(withId(R.id.jobSearchButton)).perform(click());

    }
    @Test
    public void testPartTimeJobFilter() {
        /*
        Filter to show only part time jobs
        Scenario 2
        This test, tests the ability to filter the job results
        to show only part time jobs.
        */
        onView(withId(R.id.findJobButton)).perform(click());
        onView(withId(R.id.jobText)).perform(typeText("Software Developer"));
        onView(withId(R.id.jobText)).perform(closeSoftKeyboard());
        onView(withId(R.id.filterButton)).perform(click());
        onData(anything()).atPosition(0).perform(click());
        onData(anything()).atPosition(3).perform(click());
        onView(withId(R.id.jobSearchButton)).perform(click());

    }
    @Test
    public void testInternshipsFilter() {
        /*
        Filter to show only internships
        Scenario 3
        This test, tests the ability to filter the job results
        to show internships.
        */
        onView(withId(R.id.findJobButton)).perform(click());
        onView(withId(R.id.jobText)).perform(typeText("Chemical Engineer"));
        onView(withId(R.id.jobText)).perform(closeSoftKeyboard());
        onView(withId(R.id.filterButton)).perform(click());
        onData(anything()).atPosition(0).perform(click());
        onData(anything()).atPosition(4).perform(click());
        onView(withId(R.id.jobSearchButton)).perform(click());
    }

    // User Story 2 Find job by location
    @Test
    public void testArkansasFilter() {
        /*
        Filter to show only jobs in Arkansas
        Scenario 1
        This test, tests the ability to filter only ME jobs in Arkansas
        */
        onView(withId(R.id.findJobButton)).perform(click());
        onView(withId(R.id.jobText)).perform(typeText("Mechanical Engineer"));
        onView(withId(R.id.jobText)).perform(closeSoftKeyboard());
        onView(withId(R.id.filterButton)).perform(click());
        onData(anything()).atPosition(1).perform(click());
        onData(anything()).atPosition(2).perform(click());
        onView(withId(R.id.jobSearchButton)).perform(click());

    }
    @Test
    public void testAlabamaFilter() {
        /*
        Filter to show only jobs in Alabama
        Scenario 2
        This test, tests the ability to filter only Bio jobs in Alabama
        */
        onView(withId(R.id.findJobButton)).perform(click());
        onView(withId(R.id.jobText)).perform(typeText("Biology"));
        onView(withId(R.id.jobText)).perform(closeSoftKeyboard());
        onView(withId(R.id.filterButton)).perform(click());
        onData(anything()).atPosition(1).perform(click());
        onData(anything()).atPosition(3).perform(click());
        onView(withId(R.id.jobSearchButton)).perform(click());

    }
    @Test
    public void testArizonaFilter() {
        /*
        Filter to show only retail jobs in Arizona
        Scenario 3
        This test, tests the ability to filter only retail jobs in Arizona
        */
        onView(withId(R.id.findJobButton)).perform(click());
        onView(withId(R.id.jobText)).perform(typeText("Retail"));
        onView(withId(R.id.jobText)).perform(closeSoftKeyboard());
        onView(withId(R.id.filterButton)).perform(click());
        onData(anything()).atPosition(1).perform(click());
        onData(anything()).atPosition(4).perform(click());
        onView(withId(R.id.jobSearchButton)).perform(click());
    }

    //User story 3
    @Test
    public void testRedirectToWebPE() {
        /*
        Scenario 1
        This test, tests the ability to click on an external link for Petroleum Engineering to be
        redirected to a career site where one can apply for the job specified
        */
        ViewInteraction appCompatButton = onView(
                Matchers.allOf(withId(R.id.findJobButton), withText("Find your job"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                Matchers.allOf(withId(R.id.jobText),
                        childAtPosition(
                                Matchers.allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("Petroleum Engineering"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                Matchers.allOf(withId(R.id.jobText), withText("Petroleum Engineering"),
                        childAtPosition(
                                Matchers.allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatEditText2.perform(click());

        ViewInteraction appCompatEditText3 = onView(
                Matchers.allOf(withId(R.id.jobText), withText("Petroleum Engineering"),
                        childAtPosition(
                                Matchers.allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatEditText3.perform(replaceText("Petroleum Engineering"));

        ViewInteraction appCompatEditText4 = onView(
                Matchers.allOf(withId(R.id.jobText), withText("Petroleum Engineering"),
                        childAtPosition(
                                Matchers.allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatEditText4.perform(closeSoftKeyboard());

        ViewInteraction appCompatButton2 = onView(
                Matchers.allOf(withId(R.id.jobSearchButton),
                        childAtPosition(
                                Matchers.allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction button = onView(
                Matchers.allOf(
                        childAtPosition(
                                Matchers.allOf(withId(R.id.resultsList),
                                        childAtPosition(
                                                withId(R.id.resultsView),
                                                0)),
                                0)));
        button.perform(scrollTo(), click());
    }

    @Test
    public void testRedirectTocWebLS() {
        /*
        Scenario 2
        This test, tests the ability to click on an external link for Liberal Science to be
        redirected to a career site where one can apply for the job specified
        */
        ViewInteraction appCompatButton = onView(
                Matchers.allOf(withId(R.id.findJobButton), withText("Find your job"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                Matchers.allOf(withId(R.id.jobText),
                        childAtPosition(
                                Matchers.allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("Liberal Studies"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                Matchers.allOf(withId(R.id.jobText), withText("Liberal Studies"),
                        childAtPosition(
                                Matchers.allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatEditText2.perform(click());

        ViewInteraction appCompatEditText3 = onView(
                Matchers.allOf(withId(R.id.jobText), withText("Liberal Studies"),
                        childAtPosition(
                                Matchers.allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatEditText3.perform(replaceText("Liberal Studies"));

        ViewInteraction appCompatEditText4 = onView(
                Matchers.allOf(withId(R.id.jobText), withText("Liberal Studies"),
                        childAtPosition(
                                Matchers.allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatEditText4.perform(closeSoftKeyboard());

        ViewInteraction appCompatButton2 = onView(
                Matchers.allOf(withId(R.id.jobSearchButton),
                        childAtPosition(
                                Matchers.allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction button = onView(
                Matchers.allOf(
                        childAtPosition(
                                Matchers.allOf(withId(R.id.resultsList),
                                        childAtPosition(
                                                withId(R.id.resultsView),
                                                0)),
                                0)));
        button.perform(scrollTo(), click());

    }

    @Test
    public void testRedirectTocWebCS() {
        /*
        Scenario 3
        This test, tests the ability to click on an external link for Computer Science jobs to be
        redirected to a career site where one can apply for the job specified
        */
        ViewInteraction appCompatButton = onView(
                Matchers.allOf(withId(R.id.findJobButton), withText("Find your job"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                Matchers.allOf(withId(R.id.jobText),
                        childAtPosition(
                                Matchers.allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("Computer Science"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                Matchers.allOf(withId(R.id.jobText), withText("Computer Science"),
                        childAtPosition(
                                Matchers.allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatEditText2.perform(click());

        ViewInteraction appCompatEditText3 = onView(
                Matchers.allOf(withId(R.id.jobText), withText("Computer Science"),
                        childAtPosition(
                                Matchers.allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatEditText3.perform(replaceText("Computer Science"));

        ViewInteraction appCompatEditText4 = onView(
                Matchers.allOf(withId(R.id.jobText), withText("Computer Science"),
                        childAtPosition(
                                Matchers.allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatEditText4.perform(closeSoftKeyboard());

        ViewInteraction appCompatButton2 = onView(
                Matchers.allOf(withId(R.id.jobSearchButton),
                        childAtPosition(
                                Matchers.allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction button = onView(
                Matchers.allOf(
                        childAtPosition(
                                Matchers.allOf(withId(R.id.resultsList),
                                        childAtPosition(
                                                withId(R.id.resultsView),
                                                0)),
                                0)));
        button.perform(scrollTo(), click());

    }
    //User story number 4
    @Test
    public void testSalaryFilter() {
        /*
        Scenario 1
        This test, tests the ability to by salary.
        */
        onView(withId(R.id.findJobButton)).perform(click());
        onView(withId(R.id.jobText)).perform(closeSoftKeyboard());
        onView(withId(R.id.filterButton)).perform(click());
        onData(anything()).atPosition(2).perform(click());

    }
    @Test
    public void testSalaryRange30K() {
        /*
        Scenario 2
        This test, tests the ability to filter by salary
        for the range $30,000.
        */
        onView(withId(R.id.findJobButton)).perform(click());
        onView(withId(R.id.jobText)).perform(typeText("Software"));
        onView(withId(R.id.jobText)).perform(closeSoftKeyboard());
        onView(withId(R.id.filterButton)).perform(click());
        onData(anything()).atPosition(2).perform(click());
        onData(anything()).atPosition(2).perform(click());
        onView(withId(R.id.jobSearchButton)).perform(click());
    }
    @Test
    public void testSalaryRange60K() {
        /*
        Scenario 3
        This test, tests the ability to filter by salary
        for the range $60,000.
        */
        onView(withId(R.id.findJobButton)).perform(click());
        onView(withId(R.id.jobText)).perform(typeText("Software"));
        onView(withId(R.id.jobText)).perform(closeSoftKeyboard());
        onView(withId(R.id.filterButton)).perform(click());
        onData(anything()).atPosition(2).perform(click());
        onData(anything()).atPosition(4).perform(click());
        onView(withId(R.id.jobSearchButton)).perform(click());
    }


}