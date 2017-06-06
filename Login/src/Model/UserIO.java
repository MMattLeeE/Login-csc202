package Model;

import java.io.*;
import java.nio.file.*;
/**
 * Created by Matt on 5/30/2017.
 *
 * UserIO class is basically the same as shown by
 * Professor Kanchanawanchai in the videos below:
 *      video 1:
 *          https://youtu.be/hZeB8NArL2k
 *      video 2:
 *          https://youtu.be/x9g-vXuHNkA
 *
 * A function checkForDatFile was added to create a .dat file when this program is first run without one.
 */
public class UserIO {

    public static void writeUsers(Object data) throws IOException {
        checkForDatFile();
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("users.dat"));
        output.writeObject(data);
    }

    public static Object readUsers() throws IOException, ClassNotFoundException {
        checkForDatFile();
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("users.dat"));
        return input.readObject();
    }

    //Function to check if the .dat file exists and if it doesn't creates one with a test user.
    //Called every time when writing to .dat file.
    private static void checkForDatFile() {
        Path path = Paths.get("users.dat");

        if (Files.notExists(path)){
            User firstUser = new User();
            UserDB.getUsersArrayList().add(firstUser);

            try {
                File firstFile = new File("users.dat");
                firstFile.createNewFile();
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(firstFile, false));
                output.writeObject(UserDB.getUsersArrayList());
                output.flush();
                output.close();

            } catch (IOException e) {
                System.err.println("cannot write to binary file");
                e.printStackTrace();
            }
        }
    }

}
