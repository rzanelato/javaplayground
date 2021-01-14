package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface IsValidName {
    String name();
    boolean couldValidate() default false;
    boolean empty() default true;
}
