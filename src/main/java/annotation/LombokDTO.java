package annotation;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

@Data
@JsonAutoDetect
@JsonInclude(Include.NON_NULL)
public class LombokDTO {

    private final String name;
    private final String email;
    @JsonProperty("lists")
    @JsonInclude(Include.NON_EMPTY)
    private final List<LombokPojo> pojos;

}
