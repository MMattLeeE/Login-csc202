package Model;

/**
 * Created by Matt on 6/6/2017.
 *
 *  Initially had static variables in ControllerUserPage and used reflection to save time having to type up and set 9 or so static variables.
 *
 *  Later decided that it was better to set user data to separate class in model.
 *  Using reflection proved to be unnecessary and didn't really make the code cleaner...
 */
public final class UserCurrent {
    private UserCurrent() {}

    private static String currentUserFirstName;
    private static String currentUserLastName;
    private static String currentUserSsn;
    private static String currentUserDob;
    private static String currentUserGender;
    private static String currentUserUsername;
    private static String currentUserPassword;
    private static String currentUserEmail;
    private static String currentUserPhoneNumber;
    private static String currentUserProfilePhoto;

    private static User currentUser;

    public static void setCurrentUser(User user) {
        UserCurrent.currentUser = user;
        UserCurrent.currentUserFirstName = currentUser.getFirstName();
        UserCurrent.currentUserLastName = currentUser.getLastName();
        UserCurrent.currentUserSsn = currentUser.getSsn();
        UserCurrent.currentUserDob = currentUser.getDob();
        UserCurrent.currentUserGender = currentUser.getGender();
        UserCurrent.currentUserUsername = currentUser.getUsername();
        UserCurrent.currentUserPassword = currentUser.getPassword();
        UserCurrent.currentUserEmail = currentUser.getEmail();
        UserCurrent.currentUserPhoneNumber = currentUser.getPhoneNumber();
        UserCurrent.currentUserProfilePhoto = currentUser.getProfilePhoto();
    }

    public static String getCurrentUserFirstName() {
        return currentUserFirstName;
    }

    public static String getCurrentUserLastName() {
        return currentUserLastName;
    }

    public static String getCurrentUserSsn() {
        return currentUserSsn;
    }

    public static String getCurrentUserDob() {
        return currentUserDob;
    }

    public static String getCurrentUserGender() {
        return currentUserGender;
    }

    public static String getCurrentUserUsername() {
        return currentUserUsername;
    }

    public static String getCurrentUserPassword() {
        return currentUserPassword;
    }

    public static String getCurrentUserEmail() {
        return currentUserEmail;
    }

    public static String getCurrentUserPhoneNumber() {
        return currentUserPhoneNumber;
    }

    public static String getCurrentUserProfilePhoto() {
        return currentUserProfilePhoto;
    }
}
