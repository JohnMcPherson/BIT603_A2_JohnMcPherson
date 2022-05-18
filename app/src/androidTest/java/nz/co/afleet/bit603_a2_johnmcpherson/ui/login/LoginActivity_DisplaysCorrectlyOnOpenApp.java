package nz.co.afleet.bit603_a2_johnmcpherson.ui.login;


import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import nz.co.afleet.bit603_a2_johnmcpherson.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class LoginActivity_DisplaysCorrectlyOnOpenApp {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityTestRule = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void loginActivity_DisplaysCorrectlyOnOpenApp() {
        ViewInteraction textView = onView(
                allOf(withId(R.id.mandatoryUser), withText("*"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        textView.check(matches(withText("*")));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.mandatoryPassword), withText("*"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        textView2.check(matches(withText("*")));

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.textUserLabel), withText("User"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        textView3.check(matches(withText("User")));

        ViewInteraction textView4 = onView(
                allOf(withId(R.id.textPasswordLabel), withText("Password"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        textView4.check(matches(withText("Password")));

        ViewInteraction button = onView(
                allOf(withId(R.id.buttonLogin), withText("LOGIN"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        button.check(matches(isDisplayed()));

        ViewInteraction textView5 = onView(
                allOf(withText("Kiwi Cookies and Cakes - Inventory"),
                        withParent(allOf(withId(androidx.appcompat.R.id.action_bar),
                                withParent(withId(androidx.appcompat.R.id.action_bar_container)))),
                        isDisplayed()));
        textView5.check(matches(withText("Kiwi Cookies and Cakes - Inventory")));
    }
}
