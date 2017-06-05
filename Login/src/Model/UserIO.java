package Model;

import java.io.*;
import java.nio.file.*;
/**
 * Created by Matt on 5/30/2017.
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
