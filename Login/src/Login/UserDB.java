package Login;

import java.util.ArrayList;

/**
 * Created by Matt on 5/30/2017.
 */
public class UserDB {

    private static ArrayList<User> users = new ArrayList<User>();

    public static ArrayList<User> getUsersArrayList() {
        return users;
    }

    public static void setUsersArrayList(ArrayList<User> users) {
        UserDB.users = users;
    }
}
