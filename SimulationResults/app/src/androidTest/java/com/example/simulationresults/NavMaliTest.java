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

public class NavMaliTest {

        @Rule
        public ActivityTestRule<NavMali> navMaliActivityTestRule = new ActivityTestRule<NavMali>(NavMali.class);
        private NavMali navMaliActivity = null;
        Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(ResultsMali.class.getName(), null, false);
        @Before
        public void setUp() throws Exception {
            navMaliActivity = navMaliActivityTestRule.getActivity();
        }

        @Test
        public void TestMaliView(){
            assertNotNull(navMaliActivity.findViewById(R.id.tableMali));

            onView(withId(R.id.tableMali)).perform(click());

            Activity resultsMali = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000);

            assertNotNull(resultsMali);
            resultsMali.finish();
        }

        @After
        public void tearDown() throws Exception {
            navMaliActivity = null;
        }
    }
