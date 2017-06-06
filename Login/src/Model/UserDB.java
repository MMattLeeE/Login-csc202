package Model;

import java.util.ArrayList;

/**
 * Created by Matt on 5/30/2017.
 *
 * UserDB class is basically the same as shown by
 * Professor Kanchanawanchai in the videos below:
 *      video 1:
 *          https://youtu.be/hZeB8NArL2k
 *      video 2:
 *          https://youtu.be/x9g-vXuHNkA
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
