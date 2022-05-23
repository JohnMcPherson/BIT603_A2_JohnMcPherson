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

import nz.co.afleet.bit603_a2_johnmcpherson.ui.AddInventoryActivity;

import static nz.co.afleet.bit603_a2_johnmcpherson.UnitTest_User_And_Login.TRINI;
import static nz.co.afleet.bit603_a2_johnmcpherson.UnitTest_User_And_Login.TRINI_PASSWORD;
import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
public class IntegrationTest_AddInventoryItem {
    private AddInventoryActivity mainActivity;
    private TextView errorMessage;

    @Before
    public void setupLoginActivity() {
        mainActivity = Robolectric.setupActivity(AddInventoryActivity.class);
        errorMessage = mainActivity.findViewById(R.id.textErrorMessageAdd);
    }

    @Test
    public void checkErrorMessage() {
        String expectedMessage = "";
        String actualMessage = errorMessage.getText().toString();
        assertEquals(expectedMessage, actualMessage);
    }
}
