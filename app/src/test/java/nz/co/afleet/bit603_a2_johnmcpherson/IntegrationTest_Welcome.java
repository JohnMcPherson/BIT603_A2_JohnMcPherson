/*
ASSUMPTIONS
    -   Integration testing is not a requirement of the Assessment.
        But one of the course videos mentioned Robolectric. I wanted to give it a try, and keep it as a reference
*/

package nz.co.afleet.bit603_a2_johnmcpherson;

import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import nz.co.afleet.bit603_a2_johnmcpherson.ui.main.MainActivity;

import static nz.co.afleet.bit603_a2_johnmcpherson.UnitTest_User_And_Login.TRINI;
import static nz.co.afleet.bit603_a2_johnmcpherson.UnitTest_User_And_Login.TRINI_PASSWORD;
import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
public class IntegrationTest_Welcome {
    public static final String WELCOME = "Welcome";

    private MainActivity mainActivity;
    private TextView welcomeMessage;

    @Before
    public void setupLoginActivity() {
        mainActivity = Robolectric.setupActivity(MainActivity.class);
        welcomeMessage = mainActivity.findViewById(R.id.textViewWelcomeMessage);
    }

    @Test
    public void checkWelcomeMessage() {
        User.loginUser(TRINI, TRINI_PASSWORD);
        confirmWelcomeMessageDisplayed(WELCOME + " " + TRINI);
    }

    @Test
    public void checkWelcomeMessageNoUser() {
        // the real app shouldn't get here, but we have code for it, so test it

        // make sure no one is logged in
        User.logoutUser();

        // confirm all we have is the word "Welcome"
        confirmWelcomeMessageDisplayed(WELCOME);
    }

    private void confirmWelcomeMessageDisplayed(String expectedMessage) {
        String actualMessage = welcomeMessage.getText().toString();
        assertEquals(expectedMessage, actualMessage);
    }

}
