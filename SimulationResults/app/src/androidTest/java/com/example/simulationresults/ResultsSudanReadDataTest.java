package com.example.simulationresults;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class ResultsSudanReadDataTest {
    @Rule
    public ActivityTestRule<ResultsShowActivity> resultsShowActivityActivityTestRule = new ActivityTestRule<ResultsShowActivity>(ResultsShowActivity.class);
    private ResultsShowActivity resultsShowActivity = null;
    @Before
    public void setUp() throws Exception {
        resultsShowActivity = resultsShowActivityActivityTestRule.getActivity();
    }

    @Test
    public void TestSudanCSVData(){
        onView(withId(R.id.gridView)).check(matches(isDisplayed()));
    }

    @After
    public void tearDown() throws Exception {
        resultsShowActivity = null;
    }
}