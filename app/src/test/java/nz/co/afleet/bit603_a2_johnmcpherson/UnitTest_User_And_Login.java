package nz.co.afleet.bit603_a2_johnmcpherson;

import android.graphics.Color;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UnitTest_User_And_Login {
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
        String TRINI = "Trini";
        String TRINI_PASSWORD = "Tiger";
        String TRINI_FAVOURITE_COLOUR = "Yellow";
        int TRINI_CODE_OF_FAVOURITE_COLOUR = Color.YELLOW;

        User foundUser = User.find(TRINI);
        assertEquals(foundUser.getUserName(), TRINI);
        assertEquals(foundUser.getPassword(), TRINI_PASSWORD);
        assertEquals(foundUser.getFavouriteColour(), TRINI_FAVOURITE_COLOUR);
        assertEquals(foundUser.getColourCode(), TRINI_CODE_OF_FAVOURITE_COLOUR);
    }

    @Test
    public void testAddUser() {
        String HARRY = "Harry";
        String HARRY_PASSWORD = "Fox";
        String HARRY_FAVOURITE_COLOUR = "Blue";
        int HARRY_CODE_OF_FAVOURITE_COLOUR = Color.BLUE;

        User.addUser(HARRY, HARRY_PASSWORD, HARRY_FAVOURITE_COLOUR, HARRY_CODE_OF_FAVOURITE_COLOUR);

        // confirm that the user was added
        User newUser = User.getAllUsers().get(HARRY);
        assert newUser != null; // resolves a warning. And if newUser is not null, we want to crash the test
        assertEquals(newUser.getUserName(), HARRY);
        assertEquals(newUser.getPassword(), HARRY_PASSWORD);
        assertEquals(newUser.getFavouriteColour(), HARRY_FAVOURITE_COLOUR);
        assertEquals(newUser.getColourCode(), HARRY_CODE_OF_FAVOURITE_COLOUR);
    }


    @Test
    public void testForSuccessfulLogin() {
        String nameOfTestUser = "Jason";
        boolean loginSuccessful = User.loginUser(nameOfTestUser, "Sword");
        // check that the login method is indicating success
        assertTrue(loginSuccessful);
        User loggedInUser = User.getLoggedInUser();
        // check that somebody is logged in
        assertNotEquals(loggedInUser, null);
        // check that it is the right person
        assertEquals(loggedInUser, User.find(nameOfTestUser));
    }

    @Test
    public void testLoginUserNameFail() {
        //start by logging in a user
        testForSuccessfulLogin();
        // and checking we have a logged in user
        assertNotEquals(User.getLoggedInUser(), null);

        // try to log in with user name that does not exist
        String nameOfTestUser = "Faker";
        boolean loginSuccessful = User.loginUser(nameOfTestUser, "Sword");
        // check that the login method is indicating failure
        assertFalse(loginSuccessful);

        // check that Jason has been logged out (due to our unsuccessful login attempt)
        User loggedInUser = User.getLoggedInUser();
        assertNull(loggedInUser);
    }

    @Test
    public void testLoginPasswordFail() {
        String JASON = "Jason";

        //start by logging in a user (Jason)
        testForSuccessfulLogin();
        // and checking we have a logged in user
        assertNotEquals(User.getLoggedInUser(), null);

        // try to log in with a wrong password
        String nameOfTestUser = JASON;
        boolean loginSuccessful = User.loginUser(nameOfTestUser, "wrongPassword");
        // check that the login method indicated failure
        assertFalse(loginSuccessful);

        // check that the previous user (logged in, with testLoginSuccess) has been logged out (due to our unsuccessful login attempt)
        User loggedInUser = User.getLoggedInUser();
        assertNull(loggedInUser);
    }
}