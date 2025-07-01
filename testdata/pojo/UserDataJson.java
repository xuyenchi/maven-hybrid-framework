package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import  com.fasterxml.jackson.databind.*;
import commons.GlobalConstants;

import java.io.File;

public class UserDataJson {

    //hàm để đọc file json
    public static UserDataJson getUser(){
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(new File(GlobalConstants.DATA_TEST_PATH + "User.json"), UserDataJson .class);

        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    @JsonProperty("firstname")
    private String firstName;

    @JsonProperty("lastname")
    private String lastName;

    @JsonProperty("middlename")
    private String middleName;

    @JsonProperty("email")
    private String emailAddress;

    @JsonProperty("password")
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }
}
