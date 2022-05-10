package nz.co.afleet.bit603_a2_johnmcpherson;

public class User {
    private String user;
    private String password;
    private String favouriteColour;
    private int colourCode;

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
