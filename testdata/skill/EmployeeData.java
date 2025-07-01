package skill;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import commons.GlobalConstants;

import java.io.File;
import java.util.List;

public class EmployeeData {
    public static EmployeeData getEmployee() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(new File(GlobalConstants.DATA_TEST_PATH + "Employee.json"), EmployeeData.class);

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static class Employee {
        @JsonProperty("name")
        private String name;

        @JsonProperty("email")
        private String email;

        @JsonProperty("age")
        private int age;

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public int getAge() {
            return age;
        }
    }

    @JsonProperty("employees")
    private List<Employee> employeeList;

    public List<Employee> getEmployeeList(){
        return employeeList;
    }
}
