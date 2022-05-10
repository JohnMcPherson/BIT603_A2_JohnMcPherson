package nz.co.afleet.bit603_a2_johnmcpherson;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.HashMap;

public class User {
    private String user;
    private String password;
    private String favouriteColour;
    private int colourCode;

    // COLOUR_PINK made public in case we want to test it, or access it externally for another reason
    public final static int COLOUR_PINK = 0xFFFF8080;

    private static final HashMap<String, User> users = new HashMap<>();
    // initialise users
    static {
        addUser("Jason", "Sword", "Red", Color.RED);
        addUser("Billy", "Dinosaur", "Blue", Color.BLUE);
        addUser("Zack", "Elephant", "Black", Color.BLACK);
        addUser("Trini", "Tiger", "Yellow", Color.YELLOW);
        addUser("Kimberley", "Bird", "Pink", COLOUR_PINK);
    }

    private static void addUser(String user, String password, String favouriteColour, int colourCode) {
        User newUser = new User(user, password, favouriteColour, colourCode);
        users.put(user, newUser);
    }

    public static User findUser(String user) {
         // return users.get(user);
         return null;
    }

    public User(String user, String password, String favouriteColour, int colourCode) {
        this.user = user;
        this.password = password;
        this.favouriteColour = favouriteColour;
        this.colourCode = colourCode;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFavouriteColour() {
        return favouriteColour;
    }

    public void setFavouriteColour(String favouriteColour) {
        this.favouriteColour = favouriteColour;
    }

    public int getColourCode() {
        return colourCode;
    }

    public void setColourCode(int colourCode) {
        this.colourCode = colourCode;
    }
}
