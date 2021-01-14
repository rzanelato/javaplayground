package annotation;

import java.util.Optional;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

public class NameValidator implements ConstraintValidator<IsValidName, String> {

    private String name;
    private boolean couldValidate;
    private boolean empty;


    @Override public void initialize(IsValidName constraintAnnotation) {
        this.name = constraintAnnotation.name();
        this.couldValidate = constraintAnnotation.couldValidate();
        this.empty = constraintAnnotation.empty();


    }

    @Override public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        boolean couldEmpty = empty && StringUtils.isBlank(value);

        return couldEmpty || isValidName(value);
    }

    private boolean isValidName(String value) {
        return Optional.ofNullable(value)
                       .filter(txt -> couldValidate && name.equals(txt))
                       .map(x -> true)
                       .orElse(false);
    }
}
