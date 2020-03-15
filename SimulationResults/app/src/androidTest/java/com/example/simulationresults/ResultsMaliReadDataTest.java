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

public class ResultsMaliReadDataTest {
    @Rule
    public ActivityTestRule<ResultsMali> resultsMaliActivityTestRule = new ActivityTestRule<ResultsMali>(ResultsMali.class);
    private ResultsMali resultsMaliActivity = null;
    @Before
    public void setUp() throws Exception {
        resultsMaliActivity = resultsMaliActivityTestRule.getActivity();
    }

    @Test
    public void TestMaliCSVData(){
        onView(withId(R.id.gridView1)).check(matches(isDisplayed()));
    }

    @After
    public void tearDown() throws Exception {
        resultsMaliActivity = null;
    }
}