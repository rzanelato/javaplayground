package java8.optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ChainMethodTest {

    @Test
    public void shouldReturnSuccess() {
        ChainMethod method = new ChainMethod();
        assertEquals("Loco", method.chainTestSkillSucess().getName());
    }

    @Test
    public void shouldReturnExceptionOrElse() {
        ChainMethod method = new ChainMethod();

        assertThrows(RuntimeException.class, method::chainTestSkillNull);
        Exception exception = assertThrows(RuntimeException.class, method::chainTestSkillNull);
        assertEquals("SoWrong", exception.getMessage());
    }

    @Test
    public void shouldReturnExceptionNullPointer() {
        ChainMethod method = new ChainMethod();

        assertThrows(NullPointerException.class, method::chainTestNullSkill);
        Exception exception = assertThrows(NullPointerException.class, method::chainTestNullSkill);
        // assertNotNull(exception.getMessage()); // Java 11
    }

}
