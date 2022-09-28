package sept16_oop.calendar_impl;

import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.util.Date;

public class Employee {
    private String credentials;
    private char sex;
    private LocalDateTime birthday;
    private String phoneNumber;
    private String email;

    public Employee(String credentials, char sex, LocalDateTime birthday, String phoneNumber, String email) {
        this.credentials = credentials;
        this.sex = sex;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getCredentials() {
        return credentials;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }


    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
