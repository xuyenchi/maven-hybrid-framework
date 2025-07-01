package skill;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import commons.GlobalConstants;
import pojo.UserDataJsonLevel;

import java.io.File;
import java.util.List;

public class Skill {
    @JsonProperty("name")
    private String name;

    @JsonProperty("position")
    private  String position;

    @JsonProperty("skilltree")
    private List<String> skilltree;

    @JsonProperty("address")
    private Address address;
    static class Address{
        @JsonProperty("street")
        private String street;

        @JsonProperty("streetNo")
        private String streetNo;
    }


    public static Skill getSkill() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(new File(GlobalConstants.DATA_TEST_PATH + "Skill.json"), Skill .class);

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
