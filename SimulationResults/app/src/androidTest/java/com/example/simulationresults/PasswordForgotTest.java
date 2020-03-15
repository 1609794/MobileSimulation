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

public class PasswordForgotTest{
    @Rule
    public ActivityTestRule<LoginActivity> lActivityTestRule = new ActivityTestRule<LoginActivity>(LoginActivity.class);
    private LoginActivity lActivity = null;
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(PasswordActivity.class.getName(), null, false);
    @Before
    public void setUp() throws Exception {
        lActivity = lActivityTestRule.getActivity();
    }

    @Test
    public void TestPasswordForgotPage(){
        assertNotNull(lActivity.findViewById(R.id.forgetPassword));

        onView(withId(R.id.forgetPassword)).perform(click());

        Activity passwordActivity = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000);

        assertNotNull(passwordActivity);
        passwordActivity.finish();
    }

    @After
    public void tearDown() throws Exception {
        lActivity = null;
    }
}
