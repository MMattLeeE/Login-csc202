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

    public static void printArrayList() {
        for (int i=0; i < users.size(); i++) {
            System.out.print(users.get(i).getFirstName());
            System.out.print(" " + users.get(i).getLastName());
            System.out.print(" " + users.get(i).getSsn());
            System.out.print(" " + users.get(i).getDob());
            System.out.print(" " + users.get(i).getGender());
            System.out.print(" " + users.get(i).getUsername());
            System.out.print(" " + users.get(i).getPassword());
            System.out.print(" " + users.get(i).getEmail());
            System.out.print(" " + users.get(i).getPhoneNumber());
            System.out.print(" " + users.get(i).getProfilePhoto());
            System.out.println();
        }
    }
}
