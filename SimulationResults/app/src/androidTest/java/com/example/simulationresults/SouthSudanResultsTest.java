package com.example.simulationresults;

import android.app.Activity;
import android.app.Instrumentation;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static junit.framework.TestCase.assertNotNull;

public class SouthSudanResultsTest {
    @Rule
    public ActivityTestRule<Navigate> navigateActivityTestRule = new ActivityTestRule<Navigate>(Navigate.class);
    private Navigate navigateActivity = null;
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(ResultsShowActivity.class.getName(), null, false);
    @Before
    public void setUp() throws Exception {
        navigateActivity = navigateActivityTestRule.getActivity();
    }

    @Test
    public void TestSudanView(){
        assertNotNull(navigateActivity.findViewById(R.id.tableSudan));

        onView(withId(R.id.tableSudan)).perform(click());

        Activity resultsSudan = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000);

        assertNotNull(resultsSudan);
        resultsSudan.finish();
    }

    @After
    public void tearDown() throws Exception {
        navigateActivity = null;
    }
}