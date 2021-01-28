package annotation;

import java.util.UUID;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(buildMethodName = "builds")
public class LombokBuilder {

    private final UUID id;
    private final String product;
    private final String description;
    private final long quantity;
}
