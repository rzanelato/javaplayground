package pojo;

import annotation.IsValidName;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Person {

    @IsValidName(name = "Renato")
    @JsonProperty("name")
    private String name;

    @JsonProperty("age")
    private int age;

    @IsValidName(name = "Zana", empty = true, couldValidate = true)
    @JsonProperty("occupation")
    private String occupation;

    @JsonProperty("skills")
    private List<Skill> skills;

}


