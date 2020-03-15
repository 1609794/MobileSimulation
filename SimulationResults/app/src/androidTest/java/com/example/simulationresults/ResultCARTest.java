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

public class ResultCARTest {

    @Rule
    public ActivityTestRule<NavCAR> navCARActivityTestRule = new ActivityTestRule<NavCAR>(NavCAR.class);
    private NavCAR navCAR = null;
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(CAR.class.getName(), null, false);
    @Before
    public void setUp() throws Exception {
        navCAR = navCARActivityTestRule.getActivity();
    }

    @Test
    public void TestCARView(){
        assertNotNull(navCAR.findViewById(R.id.tableCAR));

        onView(withId(R.id.tableCAR)).perform(click());

        Activity navCAR = getInstrumentation().waitForMonitorWithTimeout(monitor, 8000);

        assertNotNull(navCAR);
        navCAR.finish();
    }

    @After
    public void tearDown() throws Exception {
        navCAR = null;
    }
}