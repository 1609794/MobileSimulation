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

public class RegisterPageTest {
    @Rule
    public ActivityTestRule<LoginActivity> lActivityTestRule = new ActivityTestRule<LoginActivity>(LoginActivity.class);
    private LoginActivity lActivity = null;
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(Register.class.getName(), null, false);
    @Before
    public void setUp() throws Exception {
        lActivity = lActivityTestRule.getActivity();
    }

    @Test
    public void TestRegister(){
        assertNotNull(lActivity.findViewById(R.id.register));

        onView(withId(R.id.register)).perform(click());

        Activity lActivity = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000);

        assertNotNull(lActivity);
        lActivity.finish();
    }

    @After
    public void tearDown() throws Exception {
        lActivity = null;
    }
}