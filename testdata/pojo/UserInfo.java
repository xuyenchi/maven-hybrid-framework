package pojo;

import lombok.Getter;
import lombok.Setter;
//
//@Getter
//@Setter
public class UserInfo {

    private String firstName;
    private String middleName;
    private String lastName;
    private String emailAddress;
    private String password;

    public String getFullName() {
        return firstName + " " + middleName + " " + lastName;
    }

    private String fullName;
    public static UserInfo getUserData(){
        return new UserInfo();
    }

    public String getPassword() {
        return password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getFirstName() {
        return firstName;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


}
