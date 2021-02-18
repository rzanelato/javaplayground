package annotation;

import java.util.UUID;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LombokBuilder {

    private UUID id;
    private String product;
    private String description;
    private long quantity;
}
