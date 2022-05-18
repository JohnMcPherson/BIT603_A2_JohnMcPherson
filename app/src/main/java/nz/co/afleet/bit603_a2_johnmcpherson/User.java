package nz.co.afleet.bit603_a2_johnmcpherson;

import android.graphics.Color;

import java.util.HashMap;

public class User {
    private String userName;
    private String password;
    private String favouriteColour;
    private int colourCode;

    private static User loggedInUser;

    // COLOUR_PINK made public in case we want to test it, or access it externally for another reason
    public final static int COLOUR_PINK = 0xFFFF8080;

    // declare and initialise user list
    private static final HashMap<String, User> users = new HashMap<>();

    static {
        loadUsers();
    }

    private static void loadUsers() {
        addUser("Jason", "Sword", "Red", Color.RED);
        addUser("Billy", "Dinosaur", "Blue", Color.BLUE);
        addUser("Zack", "Elephant", "Black", Color.BLACK);
        addUser("Trini", "Tiger", "Yellow", Color.YELLOW);
        addUser("Kimberly", "Bird", "Pink", COLOUR_PINK);
    }

    // There is no current requirement for this to be public, because addUser is only used by the loadUsers method
    // But, for a real world app, we would soon want to provide UI capability to add users.
    // And, making it public makes it easy to unit test.
    public static void addUser(String userName, String password, String favouriteColour, int colourCode) {
        User newUser = new User(userName, password, favouriteColour, colourCode);
        users.put(userName, newUser);
    }

    // Made public to allow easy unit testing
    // But likely to be required (as public) for future development
    public static HashMap<String, User> getAllUsers() {
        return users;
    }

    // find a User, based on userName
    public static User find(String userName) {
        return users.get(userName);
    }

    public static boolean loginUser(String userName, String password) {
        loggedInUser = null; // if we are trying to log in, we want to ensure that any existing users are logged out
        User user = find(userName);
        if (user == null) return false;
        if (user.getPassword().equals(password)) {
            loggedInUser = user;
            return true;
        } else {
            return false;
        }
    }

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public User(String userName, String password, String favouriteColour, int colourCode) {
        this.userName = userName;
        this.password = password;
        this.favouriteColour = favouriteColour;
        this.colourCode = colourCode;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getFavouriteColour() {
        return favouriteColour;
    }

    public int getColourCode() {
        return colourCode;
    }

    // setters not required. We initialise directly, and have no requirement to update
    // setters would be added later if (and when) update is required
}
