package pojo;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Skill {

    @JsonProperty("name")
    private final String name;

    @JsonProperty("code")
    private final String code;

    public Skill(
            @JsonProperty("name") final String name,
            @JsonProperty("code") final String code
    ) {
        this.name = name;
        this.code = code;
    }
}
