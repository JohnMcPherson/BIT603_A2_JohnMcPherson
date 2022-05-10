/*
ASSUMPTIONS
    -   Integration testing is not a requirement of the Assessment.
        But one of the course videos mentioned Robolectric. I wanted to give it a try, and keep it as a reference
*/

package nz.co.afleet.bit603_a2_johnmcpherson;

import android.app.Activity;
import android.graphics.Color;
import android.widget.TextView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)
public class IntegrationTest_Login {
    @Test
    public void labels_areCorrect() {
        LoginActivity loginActivity = Robolectric.setupActivity(LoginActivity.class);
        testMandatoryIndicatorIsCorrect(loginActivity, R.id.mandatoryUser);
        testMandatoryIndicatorIsCorrect(loginActivity, R.id.mandatoryPassword);
        testLabelIsCorrect(loginActivity, R.id.textUserLabel, "User");
        testLabelIsCorrect(loginActivity, R.id.textPasswordLabel, "Password");
    }

    private void testLabelIsCorrect(LoginActivity activityToTest, int viewId, String requiredText) {
        TextView viewToTest = activityToTest.findViewById(viewId);
        assertTrue(viewToTest.getText().toString().equals(requiredText));
    }

    private void testMandatoryIndicatorIsCorrect(Activity activityToTest, int indicatorViewId) {
        TextView viewToTest = activityToTest.findViewById(indicatorViewId);
        assertEquals(viewToTest.getCurrentTextColor(), Color.RED);
        assertTrue(viewToTest.getText().toString().equals("*"));
    }
}
