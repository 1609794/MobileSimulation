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

public class ServerBurundiTest {
    @Rule
    public ActivityTestRule<NavBurundi> navBurundiActivityTestRule = new ActivityTestRule<NavBurundi>(NavBurundi.class);
    private NavBurundi navBurundiActivity = null;
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(SSH.class.getName(), null, false);
    @Before
    public void setUp() throws Exception {
        navBurundiActivity = navBurundiActivityTestRule.getActivity();
    }

    @Test
    public void TestBurundiServer(){
        assertNotNull(navBurundiActivity.findViewById(R.id.serverBurundi));

        onView(withId(R.id.serverBurundi)).perform(click());

        Activity serverBurundi = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000);

        assertNotNull(serverBurundi);
        serverBurundi.finish();
    }

    @After
    public void tearDown() throws Exception {
        navBurundiActivity = null;
    }
}