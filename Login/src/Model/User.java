package Model;

import java.io.Serializable;

/**
 * Created by Matt on 5/27/2017.
 */
public class User extends Person implements Serializable {
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private String profilePhoto;

    public User() {
        super();
        setUsername("testUsername");
        setPassword("!1Testpassword");
        setEmail("testEmail@email.com");
        setPhoneNumber("1112223333");
        setProfilePhoto("testPhoto");
    }

    public User(String username, String password, String email, String phoneNumber, String profilePhoto) {
        setUsername(username);
        setPassword(password);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        setProfilePhoto(profilePhoto);
    }

    public User(String firstName, String lastName, String ssn, String dob, String gender, String username, String password, String email, String phoneNumber, String profilePhoto) {
        super(firstName,lastName,ssn,dob,gender);
        setUsername(username);
        setPassword(password);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        setProfilePhoto(profilePhoto);
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
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
