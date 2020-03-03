package dk.easj.anbo.collectwordsx;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule(MainActivity.class);

    @Test
    public void testIt() {
        // Context of the app under test.
        //Context appContext = InstrumentationRegistry.getTargetContext();

        //assertEquals("dk.easj.anbo.collectwords", appContext.getPackageName());

        onView(withText("Type a word")).check(matches(isDisplayed()));
        onView(withId(R.id.mainWordEdittext)).perform(typeText("Anders"));
        onView(withId(R.id.mainButtonSave)).perform(click());
        onView(withId(R.id.mainButtonShow)).perform(click());
        onView(withId(R.id.mainMessageTextview)).check(matches(withText(("[Anders]"))));

        onView(withId(R.id.mainWordEdittext)).perform(typeText("Peter"));
        onView(withId(R.id.mainButtonSave)).perform(click());
        onView(withId(R.id.mainButtonShow)).perform(click());
        onView(withId(R.id.mainMessageTextview)).check(matches(withText(("[Anders, Peter]"))));

        onView(withId(R.id.mainButtonClear)).perform(click());
        onView(withId(R.id.mainButtonShow)).perform(click());
        onView(withId(R.id.mainMessageTextview)).check(matches(withText("empty")));
    }

    @Test
    public void test2() {
        onView(withText("Type a word")).check(matches(isDisplayed()));
    }
}
