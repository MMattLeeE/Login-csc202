package Model;

import java.io.Serializable;

/**
 * Created by Matt on 5/27/2017.
 */
public class Person implements Serializable {
    private String firstName;
    private String lastName;
    private String ssn;
    private String dob;
    private String gender;

    public Person() {
        firstName = "firstTest";
        lastName = "lastTest";
        ssn = "12345666";
        dob = "23456";
        gender = "testGender";
    }

    public Person(String firstName, String lastName, String ssn, String dob, String gender) {
        setFirstName(firstName);
        setLastName(lastName);
        setSsn(ssn);
        setDob(dob);
        setGender(gender);
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

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
