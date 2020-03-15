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

public class ReadBurundiDataTest {
    @Rule
    public ActivityTestRule<ResultsBurundi> resultsBurundiActivityTestRule = new ActivityTestRule<ResultsBurundi>(ResultsBurundi.class);
    private ResultsBurundi resultsBurundiActivity = null;
    @Before
    public void setUp() throws Exception {
        resultsBurundiActivity = resultsBurundiActivityTestRule.getActivity();
    }

    @Test
    public void TestBurundiCSVData(){
        onView(withId(R.id.gridView2)).check(matches(isDisplayed()));
    }

    @After
    public void tearDown() throws Exception {
        resultsBurundiActivity = null;
    }
}