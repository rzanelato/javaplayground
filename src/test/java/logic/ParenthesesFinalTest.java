package logic;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ParenthesesFinalTest {

    private ParenthesesFinal parentheses = new ParenthesesFinal();

    @Test
    void shouldBeValid() {
        assertTrue(parentheses.isValid("(if (any? x) sum (/1 x))"));
        assertTrue(parentheses.isValid("I said (it's not (yet) complete). (she didn't listen)"));
        assertTrue(parentheses.isValid("(((()))(()))"));
        assertTrue(parentheses.isValid("(($1 and $2) or $3)"));
        assertTrue(parentheses.isValid("$1 and $2"));

    }

    @Test
    void shouldBeInvalid() {
        assertFalse(parentheses.isValid("())("));
        assertFalse(parentheses.isValid(":-)"));
        assertFalse(parentheses.isValid("(((()))(())"));
        assertFalse(parentheses.isValid("(($1 and $2) or ($3 or $1)"));
        assertFalse(parentheses.isValid("))(("));
        assertFalse(parentheses.isValid("($1 and $2"));
        assertFalse(parentheses.isValid("()()))"));
        assertFalse(parentheses.isValid("((())"));
        //assertFalse(parentheses.isValid("((()()"));
    }

}
