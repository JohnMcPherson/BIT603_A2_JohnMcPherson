package nz.co.afleet.bit603_a2_johnmcpherson;

import android.graphics.Color;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UnitTest_User {
    @Test
    public void userCreateRead_isCorrect() {
        String USER_NAME = "Jason";
        String PASSWORD = "Sword";
        String FAVOURITE_COLOUR = "Red";
        int COLOUR_CODE = Color.RED;

        User testUser = new User(USER_NAME, PASSWORD, FAVOURITE_COLOUR, COLOUR_CODE);
        assertTrue(USER_NAME.equals(testUser.getUserName()));
        assertTrue(PASSWORD.equals(testUser.getPassword()));
        assertTrue(FAVOURITE_COLOUR.equals(testUser.getFavouriteColour()));
        assertEquals(COLOUR_CODE, testUser.getColourCode());
    }

    @Test
    public void checkSelectedUserIsCorrect() {
        String selectedUser = "Trini";
        String password = "Tiger";
        String favouriteColour = "Yellow";
        int colourCode = Color.YELLOW;

        User foundUser = User.find(selectedUser);
        assertTrue(foundUser.getUserName().equals(selectedUser));
        assertTrue(foundUser.getPassword().equals(password));
        assertTrue(foundUser.getFavouriteColour().equals(favouriteColour));
        assertEquals(foundUser.getColourCode(), colourCode);
    }
}