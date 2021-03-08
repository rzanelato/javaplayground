package annotation;

import java.util.Optional;
import org.apache.commons.lang3.StringUtils;

public class NameValidator {

    private String name;
    private boolean couldValidate;
    private boolean empty;

     public void initialize(IsValidName constraintAnnotation) {
        this.name = constraintAnnotation.name();
        this.couldValidate = constraintAnnotation.couldValidate();
        this.empty = constraintAnnotation.empty();
    }

    public boolean isValid(String value) {
        boolean couldEmpty = empty && StringUtils.isBlank(value);
        return couldEmpty || isValidName(value);
    }

    private boolean isValidName(String value) {
        return Optional.ofNullable(value)
                       .map(txt -> couldValidate && name.equals(txt))
                       .orElse(true);
    }
}
