package nz.co.afleet.bit603_a2_johnmcpherson;

import android.app.Application;
import android.graphics.Color;

import java.util.HashMap;

public class User {
    private String userName;
    private String password;
    private String favouriteColour;
    private int colourCode;

    // COLOUR_PINK made public in case we want to test it, or access it externally for another reason
    public final static int COLOUR_PINK = 0xFFFF8080;

    // declasre and initialise user list
    private static final HashMap<String, User> users = new HashMap<>();
    static {
        addUser("Jason", "Sword", "Red", Color.RED);
        addUser("Billy", "Dinosaur", "Blue", Color.BLUE);
        addUser("Zack", "Elephant", "Black", Color.BLACK);
        addUser("Trini", "Tiger", "Yellow", Color.YELLOW);
        addUser("Kimberley", "Bird", "Pink", COLOUR_PINK);
    }

    private static void addUser(String userName, String password, String favouriteColour, int colourCode) {
        User newUser = new User(userName, password, favouriteColour, colourCode);
        users.put(userName, newUser);
    }

    // find a User, based on userName
    public static User find(String userName) {
        return users.get(userName);
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
