package Login;

import Login.Person;

import java.io.Serializable;

/**
 * Created by Matt on 5/27/2017.
 */
public class User extends Person implements Serializable {
    private String username;
    private String email;
    private int phoneNumber;
    private String password;
    private String profilePhoto;

    public User () {
        username = "testUsername";
        email = "testEmail@email.com";
        phoneNumber = 1112223333;
        password = "testPassword";
        profilePhoto ="testPhoto";
    }

    public User(String username, String email, int phoneNumber, String password, String profilePhoto) {
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.profilePhoto = profilePhoto;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }
}
