package nz.co.afleet.bit603_a2_johnmcpherson;

import android.graphics.Color;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
    public void checkUsersLoaded() {
        checkNumberOfUsers();
        checkUsersExist();
        checkSelectedUserIsCorrect();
    }

    private void checkNumberOfUsers() {
        int numUsers = User.getAllUsers().size();
        assertEquals(numUsers, 5);
    }

    private void checkUsersExist() {
        List<String> expectedUsers = Arrays.asList("Jason", "Billy", "Zack", "Trini", "Kimberly");
        HashMap<String, User> users = User.getAllUsers();
        for (String expectedUser : expectedUsers) {
            assertTrue(users.containsKey(expectedUser));
        }
    }

    private void checkSelectedUserIsCorrect() {
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

    @Test
    public void testAddUser() {
        String userName = "Harry";
        String password = "Fox";
        String favouriteColour = "Blue";
        int colourCode = Color.BLUE;

        User.addUser(userName, password, favouriteColour, colourCode);
        User newUser = User.getAllUsers().get(userName);
        assertTrue(newUser.getUserName().equals(userName));
        assertTrue(newUser.getPassword().equals(password));
        assertTrue(newUser.getFavouriteColour().equals(favouriteColour));
        assertEquals(newUser.getColourCode(), colourCode);
    }
}