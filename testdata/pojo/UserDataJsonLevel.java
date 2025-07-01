
package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.*;
import commons.GlobalConstants;

import java.io.File;

public class UserDataJsonLevel {

    //hàm để đọc file json
    public static UserDataJsonLevel getUser() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(new File(GlobalConstants.DATA_TEST_PATH + "UserLevel.json"), UserDataJsonLevel.class);

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @JsonProperty("firstname")
    private String firstName;

    @JsonProperty("lastname")
    private String lastName;

    @JsonProperty("Register")
    Register register;
    static class Register{
        @JsonProperty("fullname")
        private String fullName;
    };

    @JsonProperty("Login")
    Login login;
    static class Login{
        @JsonProperty("username")
        private String userName;

        @JsonProperty("password")
        private String password;
    }

    public String getUsername() {
        return login.userName;
    }

    public String getPassword() {
        return login.password;
    }

    public String getFullName() {
        return register.fullName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }
}
