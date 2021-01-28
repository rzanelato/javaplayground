package annotation;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LombokData {

    private final String name;
    private final String email;
    private final List<LombokDataPojo> pojos;

}
