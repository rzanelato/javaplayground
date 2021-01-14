package annotation;

import org.junit.jupiter.api.Test;
import pojo.Person;

public class NameValidatorTest {

    @Test
    public void shouldWork() {
        Person person = new Person("",36, "Zaaana", null);
    }

}
