package logic;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParenthesesTest {

    @Test
    void shouldBeValid() {
        assertTrue(Parentheses.isValid("(if (any? x) sum (/1 x))"));
        assertTrue(Parentheses.isValid("I said (it's not (yet) complete). (she didn't listen)"));
        assertTrue(Parentheses.isValid("(((()))(()))"));
        assertTrue(Parentheses.isValid("(($1 and $2) or $3)"));
        assertTrue(Parentheses.isValid("$1 and $2"));

    }

    @Test
    void shouldBeInvalid() {
        assertFalse(Parentheses.isValid("())("));
        assertFalse(Parentheses.isValid(":-)"));
        assertFalse(Parentheses.isValid("(((()))(())"));
        assertFalse(Parentheses.isValid("(($1 and $2) or ($3 or $1)"));
        assertFalse(Parentheses.isValid("))(("));
        assertFalse(Parentheses.isValid("((()()"));
        assertFalse(Parentheses.isValid("($1 and $2"));
        assertFalse(Parentheses.isValid("()()))"));
        assertFalse(Parentheses.isValid("((())"));
    }


}
