package nz.co.afleet.bit603_a2_johnmcpherson;

import android.graphics.Color;

public class User {
    private String user;
    private String password;
    private String favouriteColour;
    private Color colourCode;

    public User(String jason, String sword, String favoriteColour, int colourCode) {
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

    public Color getColourCode() {
        return colourCode;
    }

    public void setColourCode(Color colourCode) {
        this.colourCode = colourCode;
    }
}
