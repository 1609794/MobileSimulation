package com.example.simulationresults;

import android.app.Activity;
import android.app.Instrumentation;

import androidx.test.espresso.Espresso;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static junit.framework.TestCase.assertNotNull;

public class LoginTest {
    @Rule
    public ActivityTestRule<LoginActivity> lActivityTestRule = new ActivityTestRule<LoginActivity>(LoginActivity.class);
    private LoginActivity lActivity = null;
    private String email = "jahar25@hotmail.co.uk";
    private String password = "Hello123";
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(MapsActivity.class.getName(), null, false);
    @Before
    public void setUp() throws Exception {
        lActivity = lActivityTestRule.getActivity();
    }

    @Test
    public void TestLogin (){
        Espresso.onView(withId(R.id.name)).perform(typeText(email));
        Espresso.onView(withId(R.id.password)).perform(typeText(password));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.btnlogin)).perform(click());

        Activity lActivity = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000);
        assertNotNull(lActivity);
        lActivity.finish();
    }

    @After
    public void tearDown() throws Exception {
        lActivity = null;
    }
}