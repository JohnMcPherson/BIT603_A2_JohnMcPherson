/*
HOW TO TEST
   - Run the test (in PORTRAIT)
   - reopen the app
   - login
   - inventory
   - confirm that all 20 items can be scrolled to

   (Espresso does not automate ability to scroll and check. We would have to write that code ourselves)
*/

package nz.co.afleet.bit603_a2_johnmcpherson.ui.main;


import android.app.Application;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import nz.co.afleet.bit603_a2_johnmcpherson.R;
import nz.co.afleet.bit603_a2_johnmcpherson.inventory_database.InventoryItem;
import nz.co.afleet.bit603_a2_johnmcpherson.ui.login.LoginActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.longClick;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class Test20ItemsVisibility_REOPEN_AND_CHECK_AFTER_TEST {

    @Rule
    public ActivityScenarioRule<LoginActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(LoginActivity.class);

    @Before
    public void clearDatabase() {
        // Clear the InventoryItem table before the test (otherwise duplicate items may break the test)
        mActivityScenarioRule.getScenario().onActivity(activity -> {
            Application application = activity.getApplication();
            InventoryItem.FOR_TEST_USE_ONLY_deleteAllInventoryItems(application);
        });
    }

    @Test
    public void test20ItemsVisibility() {
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.editTextUserName),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatEditText.perform(longClick());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.editTextUserName),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("Trini"), closeSoftKeyboard());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.editTextPassword),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        appCompatEditText3.perform(replaceText("Tiger"), closeSoftKeyboard());

        ViewInteraction materialButton = onView(
                allOf(withId(R.id.buttonLogin), withText("Login"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                8),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction tabView = onView(
                allOf(withContentDescription("Inventory"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tabs),
                                        0),
                                1),
                        isDisplayed()));
        tabView.perform(click());

        ViewInteraction floatingActionButton = onView(
                allOf(withId(R.id.fabAddInventoryItem),
                        childAtPosition(
                                withParent(withId(R.id.view_pager)),
                                1),
                        isDisplayed()));
        floatingActionButton.perform(click());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.editTextItemName),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatEditText4.perform(replaceText("Item 1"), closeSoftKeyboard());

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.editTextQuantity),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText5.perform(replaceText("1"), closeSoftKeyboard());

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.buttonAdd), withText("Add"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        materialButton2.perform(click());

        ViewInteraction floatingActionButton2 = onView(
                allOf(withId(R.id.fabAddInventoryItem),
                        childAtPosition(
                                withParent(withId(R.id.view_pager)),
                                1),
                        isDisplayed()));
        floatingActionButton2.perform(click());

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.editTextItemName),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatEditText6.perform(replaceText("Item 2"), closeSoftKeyboard());

        ViewInteraction appCompatEditText7 = onView(
                allOf(withId(R.id.editTextQuantity),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText7.perform(replaceText("2"), closeSoftKeyboard());

        ViewInteraction materialButton3 = onView(
                allOf(withId(R.id.buttonAdd), withText("Add"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        materialButton3.perform(click());

        ViewInteraction floatingActionButton3 = onView(
                allOf(withId(R.id.fabAddInventoryItem),
                        childAtPosition(
                                withParent(withId(R.id.view_pager)),
                                1),
                        isDisplayed()));
        floatingActionButton3.perform(click());

        ViewInteraction appCompatEditText8 = onView(
                allOf(withId(R.id.editTextItemName),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatEditText8.perform(replaceText("Item 3"), closeSoftKeyboard());

        ViewInteraction appCompatEditText9 = onView(
                allOf(withId(R.id.editTextQuantity),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText9.perform(replaceText("3"), closeSoftKeyboard());

        ViewInteraction materialButton4 = onView(
                allOf(withId(R.id.buttonAdd), withText("Add"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        materialButton4.perform(click());

        ViewInteraction floatingActionButton4 = onView(
                allOf(withId(R.id.fabAddInventoryItem),
                        childAtPosition(
                                withParent(withId(R.id.view_pager)),
                                1),
                        isDisplayed()));
        floatingActionButton4.perform(click());

        ViewInteraction appCompatEditText10 = onView(
                allOf(withId(R.id.editTextItemName),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatEditText10.perform(replaceText("Item 4"), closeSoftKeyboard());

        ViewInteraction appCompatEditText11 = onView(
                allOf(withId(R.id.editTextQuantity),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText11.perform(replaceText("4"), closeSoftKeyboard());

        ViewInteraction materialButton5 = onView(
                allOf(withId(R.id.buttonAdd), withText("Add"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        materialButton5.perform(click());

        ViewInteraction floatingActionButton5 = onView(
                allOf(withId(R.id.fabAddInventoryItem),
                        childAtPosition(
                                withParent(withId(R.id.view_pager)),
                                1),
                        isDisplayed()));
        floatingActionButton5.perform(click());

        ViewInteraction appCompatEditText12 = onView(
                allOf(withId(R.id.editTextItemName),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatEditText12.perform(replaceText("item 5"), closeSoftKeyboard());

        ViewInteraction appCompatEditText13 = onView(
                allOf(withId(R.id.editTextQuantity),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText13.perform(replaceText("5"), closeSoftKeyboard());

        ViewInteraction materialButton6 = onView(
                allOf(withId(R.id.buttonAdd), withText("Add"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        materialButton6.perform(click());

        ViewInteraction floatingActionButton6 = onView(
                allOf(withId(R.id.fabAddInventoryItem),
                        childAtPosition(
                                withParent(withId(R.id.view_pager)),
                                1),
                        isDisplayed()));
        floatingActionButton6.perform(click());

        ViewInteraction appCompatEditText14 = onView(
                allOf(withId(R.id.editTextItemName),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatEditText14.perform(replaceText("item 6"), closeSoftKeyboard());

        ViewInteraction appCompatEditText15 = onView(
                allOf(withId(R.id.editTextQuantity),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText15.perform(replaceText("6"), closeSoftKeyboard());

        ViewInteraction materialButton7 = onView(
                allOf(withId(R.id.buttonAdd), withText("Add"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        materialButton7.perform(click());

        ViewInteraction floatingActionButton7 = onView(
                allOf(withId(R.id.fabAddInventoryItem),
                        childAtPosition(
                                withParent(withId(R.id.view_pager)),
                                1),
                        isDisplayed()));
        floatingActionButton7.perform(click());

        ViewInteraction appCompatEditText16 = onView(
                allOf(withId(R.id.editTextItemName),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatEditText16.perform(replaceText("item 7"), closeSoftKeyboard());

        ViewInteraction appCompatEditText17 = onView(
                allOf(withId(R.id.editTextQuantity),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText17.perform(replaceText("7"), closeSoftKeyboard());

        ViewInteraction materialButton8 = onView(
                allOf(withId(R.id.buttonAdd), withText("Add"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        materialButton8.perform(click());

        ViewInteraction floatingActionButton8 = onView(
                allOf(withId(R.id.fabAddInventoryItem),
                        childAtPosition(
                                withParent(withId(R.id.view_pager)),
                                1),
                        isDisplayed()));
        floatingActionButton8.perform(click());

        ViewInteraction appCompatEditText18 = onView(
                allOf(withId(R.id.editTextItemName),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatEditText18.perform(replaceText("Item 8"), closeSoftKeyboard());

        ViewInteraction appCompatEditText19 = onView(
                allOf(withId(R.id.editTextQuantity),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText19.perform(replaceText("8"), closeSoftKeyboard());

        ViewInteraction materialButton9 = onView(
                allOf(withId(R.id.buttonAdd), withText("Add"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        materialButton9.perform(click());

        ViewInteraction floatingActionButton9 = onView(
                allOf(withId(R.id.fabAddInventoryItem),
                        childAtPosition(
                                withParent(withId(R.id.view_pager)),
                                1),
                        isDisplayed()));
        floatingActionButton9.perform(click());

        ViewInteraction appCompatEditText20 = onView(
                allOf(withId(R.id.editTextItemName),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatEditText20.perform(replaceText("Item 9"), closeSoftKeyboard());

        ViewInteraction appCompatEditText21 = onView(
                allOf(withId(R.id.editTextQuantity),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText21.perform(replaceText("9"), closeSoftKeyboard());

        ViewInteraction materialButton10 = onView(
                allOf(withId(R.id.buttonAdd), withText("Add"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        materialButton10.perform(click());

        ViewInteraction floatingActionButton10 = onView(
                allOf(withId(R.id.fabAddInventoryItem),
                        childAtPosition(
                                withParent(withId(R.id.view_pager)),
                                1),
                        isDisplayed()));
        floatingActionButton10.perform(click());

        ViewInteraction appCompatEditText22 = onView(
                allOf(withId(R.id.editTextItemName),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatEditText22.perform(replaceText("Item 10"), closeSoftKeyboard());

        ViewInteraction appCompatEditText23 = onView(
                allOf(withId(R.id.editTextQuantity),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText23.perform(replaceText("10"), closeSoftKeyboard());

        ViewInteraction materialButton11 = onView(
                allOf(withId(R.id.buttonAdd), withText("Add"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        materialButton11.perform(click());

        ViewInteraction floatingActionButton11 = onView(
                allOf(withId(R.id.fabAddInventoryItem),
                        childAtPosition(
                                withParent(withId(R.id.view_pager)),
                                1),
                        isDisplayed()));
        floatingActionButton11.perform(click());

        ViewInteraction appCompatEditText24 = onView(
                allOf(withId(R.id.editTextItemName),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatEditText24.perform(replaceText("Item 11"), closeSoftKeyboard());

        ViewInteraction appCompatEditText25 = onView(
                allOf(withId(R.id.editTextQuantity),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText25.perform(replaceText("11"), closeSoftKeyboard());

        ViewInteraction materialButton12 = onView(
                allOf(withId(R.id.buttonAdd), withText("Add"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        materialButton12.perform(click());

        ViewInteraction floatingActionButton12 = onView(
                allOf(withId(R.id.fabAddInventoryItem),
                        childAtPosition(
                                withParent(withId(R.id.view_pager)),
                                1),
                        isDisplayed()));
        floatingActionButton12.perform(click());

        ViewInteraction appCompatEditText26 = onView(
                allOf(withId(R.id.editTextItemName),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatEditText26.perform(replaceText("Item 12"), closeSoftKeyboard());

        ViewInteraction appCompatEditText27 = onView(
                allOf(withId(R.id.editTextQuantity),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText27.perform(replaceText("12"), closeSoftKeyboard());

        ViewInteraction materialButton13 = onView(
                allOf(withId(R.id.buttonAdd), withText("Add"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        materialButton13.perform(click());

        ViewInteraction floatingActionButton13 = onView(
                allOf(withId(R.id.fabAddInventoryItem),
                        childAtPosition(
                                withParent(withId(R.id.view_pager)),
                                1),
                        isDisplayed()));
        floatingActionButton13.perform(click());

        ViewInteraction appCompatEditText28 = onView(
                allOf(withId(R.id.editTextItemName),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatEditText28.perform(replaceText("Item 13"), closeSoftKeyboard());

        ViewInteraction appCompatEditText29 = onView(
                allOf(withId(R.id.editTextQuantity),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText29.perform(replaceText("13"), closeSoftKeyboard());

        ViewInteraction materialButton14 = onView(
                allOf(withId(R.id.buttonAdd), withText("Add"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        materialButton14.perform(click());

        ViewInteraction floatingActionButton14 = onView(
                allOf(withId(R.id.fabAddInventoryItem),
                        childAtPosition(
                                withParent(withId(R.id.view_pager)),
                                1),
                        isDisplayed()));
        floatingActionButton14.perform(click());

        ViewInteraction appCompatEditText30 = onView(
                allOf(withId(R.id.editTextItemName),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatEditText30.perform(replaceText("Item 14"), closeSoftKeyboard());

        ViewInteraction appCompatEditText31 = onView(
                allOf(withId(R.id.editTextQuantity),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText31.perform(replaceText("14"), closeSoftKeyboard());

        ViewInteraction materialButton15 = onView(
                allOf(withId(R.id.buttonAdd), withText("Add"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        materialButton15.perform(click());

        ViewInteraction floatingActionButton15 = onView(
                allOf(withId(R.id.fabAddInventoryItem),
                        childAtPosition(
                                withParent(withId(R.id.view_pager)),
                                1),
                        isDisplayed()));
        floatingActionButton15.perform(click());

        ViewInteraction appCompatEditText32 = onView(
                allOf(withId(R.id.editTextItemName),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatEditText32.perform(replaceText("Item 15"), closeSoftKeyboard());

        ViewInteraction appCompatEditText33 = onView(
                allOf(withId(R.id.editTextQuantity),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText33.perform(replaceText("15"), closeSoftKeyboard());

        ViewInteraction materialButton16 = onView(
                allOf(withId(R.id.buttonAdd), withText("Add"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        materialButton16.perform(click());

        ViewInteraction floatingActionButton16 = onView(
                allOf(withId(R.id.fabAddInventoryItem),
                        childAtPosition(
                                withParent(withId(R.id.view_pager)),
                                1),
                        isDisplayed()));
        floatingActionButton16.perform(click());

        ViewInteraction appCompatEditText34 = onView(
                allOf(withId(R.id.editTextItemName),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatEditText34.perform(replaceText("Item 16"), closeSoftKeyboard());

        ViewInteraction appCompatEditText35 = onView(
                allOf(withId(R.id.editTextQuantity),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText35.perform(replaceText("16"), closeSoftKeyboard());

        ViewInteraction materialButton17 = onView(
                allOf(withId(R.id.buttonAdd), withText("Add"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        materialButton17.perform(click());

        ViewInteraction floatingActionButton17 = onView(
                allOf(withId(R.id.fabAddInventoryItem),
                        childAtPosition(
                                withParent(withId(R.id.view_pager)),
                                1),
                        isDisplayed()));
        floatingActionButton17.perform(click());

        ViewInteraction appCompatEditText36 = onView(
                allOf(withId(R.id.editTextItemName),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatEditText36.perform(replaceText("Item 17"), closeSoftKeyboard());

        ViewInteraction appCompatEditText37 = onView(
                allOf(withId(R.id.editTextQuantity),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText37.perform(replaceText("17"), closeSoftKeyboard());

        ViewInteraction materialButton18 = onView(
                allOf(withId(R.id.buttonAdd), withText("Add"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        materialButton18.perform(click());

        ViewInteraction floatingActionButton18 = onView(
                allOf(withId(R.id.fabAddInventoryItem),
                        childAtPosition(
                                withParent(withId(R.id.view_pager)),
                                1),
                        isDisplayed()));
        floatingActionButton18.perform(click());

        ViewInteraction appCompatEditText38 = onView(
                allOf(withId(R.id.editTextItemName),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatEditText38.perform(replaceText("Item 18"), closeSoftKeyboard());

        ViewInteraction appCompatEditText39 = onView(
                allOf(withId(R.id.editTextQuantity),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText39.perform(replaceText("18"), closeSoftKeyboard());

        ViewInteraction materialButton19 = onView(
                allOf(withId(R.id.buttonAdd), withText("Add"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        materialButton19.perform(click());

        ViewInteraction floatingActionButton19 = onView(
                allOf(withId(R.id.fabAddInventoryItem),
                        childAtPosition(
                                withParent(withId(R.id.view_pager)),
                                1),
                        isDisplayed()));
        floatingActionButton19.perform(click());

        ViewInteraction appCompatEditText40 = onView(
                allOf(withId(R.id.editTextItemName),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatEditText40.perform(replaceText("item 19"), closeSoftKeyboard());

        ViewInteraction appCompatEditText41 = onView(
                allOf(withId(R.id.editTextItemName), withText("item 19"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatEditText41.perform(click());

        ViewInteraction appCompatEditText42 = onView(
                allOf(withId(R.id.editTextItemName), withText("item 19"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatEditText42.perform(replaceText("Item 19"));

        ViewInteraction appCompatEditText43 = onView(
                allOf(withId(R.id.editTextItemName), withText("Item 19"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatEditText43.perform(closeSoftKeyboard());

        ViewInteraction appCompatEditText44 = onView(
                allOf(withId(R.id.editTextQuantity),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText44.perform(replaceText("19"), closeSoftKeyboard());

        ViewInteraction materialButton20 = onView(
                allOf(withId(R.id.buttonAdd), withText("Add"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        materialButton20.perform(click());

        ViewInteraction floatingActionButton20 = onView(
                allOf(withId(R.id.fabAddInventoryItem),
                        childAtPosition(
                                withParent(withId(R.id.view_pager)),
                                1),
                        isDisplayed()));
        floatingActionButton20.perform(click());

        ViewInteraction appCompatEditText45 = onView(
                allOf(withId(R.id.editTextItemName),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatEditText45.perform(replaceText("Item 20"), closeSoftKeyboard());

        ViewInteraction appCompatEditText46 = onView(
                allOf(withId(R.id.editTextQuantity),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText46.perform(replaceText("20"), closeSoftKeyboard());

        ViewInteraction materialButton21 = onView(
                allOf(withId(R.id.buttonAdd), withText("Add"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        materialButton21.perform(click());
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
