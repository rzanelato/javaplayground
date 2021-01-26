package logic;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ParenthesisSimpleTest {

    @Test
    void shouldBeValid() {
        //assertTrue(ParenthesisSimple.isValid("(if (any? x) sum (1 x))"));
        //assertTrue(ParenthesisSimple.isValid("I said (it's not (yet) complete). (she didn't listen)"));
        assertTrue(ParenthesisSimple.isValid("(((()))(()))"));
        assertTrue(ParenthesisSimple.isValid("(($1 and $2) or $3)"));
        assertTrue(ParenthesisSimple.isValid("$1 and $2"));
        assertTrue(ParenthesisSimple.isValid("()()()()()()"));
        assertTrue(ParenthesisSimple.isValid("(()()()()()())"));
        assertTrue(ParenthesisSimple.isValid("()()()(()()())"));

    }

    @Test
    void shouldBeInvalid() {
        assertFalse(ParenthesisSimple.isValid("(($1 and $2) or ($3 or $1)"));
        assertFalse(ParenthesisSimple.isValid("($1 and $2)) or ($3 or $1)"));
        assertFalse(ParenthesisSimple.isValid("($1 and $2"));
        assertFalse(ParenthesisSimple.isValid(":-)"));
        assertFalse(ParenthesisSimple.isValid("())("));
        assertFalse(ParenthesisSimple.isValid("(((()))(())"));
        assertFalse(ParenthesisSimple.isValid("))(("));
        assertFalse(ParenthesisSimple.isValid("))"));
        assertFalse(ParenthesisSimple.isValid("(("));
        assertFalse(ParenthesisSimple.isValid("((()()"));
        assertFalse(ParenthesisSimple.isValid("()()))"));
        assertFalse(ParenthesisSimple.isValid("((())"));
    }


}
