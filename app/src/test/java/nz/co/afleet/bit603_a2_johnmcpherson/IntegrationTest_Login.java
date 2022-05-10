/*
ASSUMPTIONS
    -   Integration testing is not a requirement of the Assessment.
        But one of the course videos mentioned Robolectric. I wanted to give it a try, and keep it as a reference
*/

package nz.co.afleet.bit603_a2_johnmcpherson;

import android.app.Activity;
import android.graphics.Color;
import android.widget.Button;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)
public class IntegrationTest_Login {
    private LoginActivity loginActivity;
    private TextView userName;

    @Before
    public void setupLoginActivity() {
        loginActivity = Robolectric.setupActivity(LoginActivity.class);
        userName = loginActivity.findViewById(R.id.editTexttUserName);
    }

    @Test
    public void initialText_isCorrect() {
         testMandatoryIndicatorIsCorrect(loginActivity, R.id.mandatoryUser);
        testMandatoryIndicatorIsCorrect(loginActivity, R.id.mandatoryPassword);
        confirmTextViewTextIsCorrect(R.id.textUserLabel, "User");
        confirmTextViewTextIsCorrect(R.id.textPasswordLabel, "Password");
        confirmTextViewTextIsCorrect(R.id.textErrorMessage, "");
        confirmTextViewTextIsCorrect(R.id.buttonLogin, "Login");
     }

    private void confirmTextViewTextIsCorrect(int viewId, String requiredText) {
        confirmTextViewTextIsCorrect(loginActivity, viewId, requiredText);
    }

     private void confirmTextViewTextIsCorrect(LoginActivity activityToTest, int viewId, String requiredText) {
        TextView viewToTest = activityToTest.findViewById(viewId);
        assertTrue(viewToTest.getText().toString().equals(requiredText));
    }

    private void testMandatoryIndicatorIsCorrect(Activity activityToTest, int indicatorViewId) {
        TextView viewToTest = activityToTest.findViewById(indicatorViewId);
        assertEquals(viewToTest.getCurrentTextColor(), Color.RED);
        assertTrue(viewToTest.getText().toString().equals("*"));
    }

    @Test
    public void errorMessages_areCorrect() {
        // check our starting point
        confirmErrorMessage("");

        Button loginButton = loginActivity.findViewById(R.id.buttonLogin);
        //simulate a click and check initial error message
        loginButton.callOnClick();
        confirmErrorMessage("Please Enter: User and Password");

        //enter a user name
        userName.setText("Test User");

        confirmErrorMessage("Please Enter your password");
    }

    private void confirmErrorMessage(String requiredText) {
        confirmTextViewTextIsCorrect(R.id.textErrorMessage, requiredText);
    }

}
