package Login;

/**
 * Created by Matt on 5/27/2017.
 */
public class Person {
    private String firstName;
    private String lastName;
    private int ssn;
    private int dob;
    private String gender;

    public Person() {
        firstName = "firstTest";
        lastName = "lastTest";
        ssn = 12345666;
        dob = 23456;
        gender = "testGender";
    }

    public Person(String firstName, String lastName, int ssn, int dob, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.dob = dob;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public int getDob() {
        return dob;
    }

    public void setDob(int dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
