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

public class CARDataReadTest {
    @Rule
    public ActivityTestRule<CAR> resultsCARActivity = new ActivityTestRule<CAR>(CAR.class);
    private CAR CARActivity = null;
    @Before
    public void setUp() throws Exception {
        CARActivity = resultsCARActivity.getActivity();
    }

    @Test
    public void TestCARCSVData(){
        onView(withId(R.id.gridView3)).check(matches(isDisplayed()));
    }

    @After
    public void tearDown() throws Exception {
        CARActivity = null;
    }
}