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

public class ServerCARTest {

    @Rule
    public ActivityTestRule<NavCAR> navCARActivityTestRule = new ActivityTestRule<NavCAR>(NavCAR.class);
    private NavCAR navCAR = null;
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(SSH.class.getName(), null, false);
    @Before
    public void setUp() throws Exception {
        navCAR = navCARActivityTestRule.getActivity();
    }

    @Test
    public void TestCARServer(){
        assertNotNull(navCAR.findViewById(R.id.serverCAR));

        onView(withId(R.id.serverCAR)).perform(click());

        Activity serverCAR = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000);

        assertNotNull(serverCAR);
        serverCAR.finish();
    }

    @After
    public void tearDown() throws Exception {
        navCAR = null;
    }
}