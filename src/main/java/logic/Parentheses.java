package logic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parentheses {

    private static final String REGEX = "[\\(\\)]";

    public static void main(String[] args) {

        System.out.println("Result True: "+Parentheses.isValid("(if (any? x) sum (/1 x))"));
        System.out.println("Result False: "+Parentheses.isValid("())("));
        System.out.println("Result True: "+Parentheses.isValid("I said (it's not (yet) complete). (she didn't listen)"));
        System.out.println("Result False: "+Parentheses.isValid(":-)"));
        System.out.println("Result True: "+Parentheses.isValid("(((()))(()))"));
        System.out.println("Result False: "+Parentheses.isValid("(((()))(())"));
        System.out.println("Result True: "+Parentheses.isValid("(($1 and $2) or $3)"));
        System.out.println("Result False: "+Parentheses.isValid("(($1 and $2) or ($3 or $1)"));
        System.out.println("Result False: "+Parentheses.isValid("))(("));
        System.out.println("Result False: "+Parentheses.isValid("((()()"));
        System.out.println("Result True: "+Parentheses.isValid("$1 and $2"));
        System.out.println("Result False: "+Parentheses.isValid("($1 and $2"));
        System.out.println("Result False: "+Parentheses.isValid("()()))"));

    }

    public static boolean isValid(String text) {
        String parentheses = getParentheses(text);
        boolean isOddParentheses = parentheses.length() % 2 == 1;
        if (isOddParentheses) {
            return false;
        }
        return recursiveValidation(parentheses);
    }

    private static String getParentheses(String text) {
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(text);
        String returnText = "";

        while (m.find()) {
            returnText += m.group();
        }
        return returnText;
    }

    private static boolean recursiveValidation(String parentheses) {
        if (parentheses.length() == 0) {
            return true;
        }
        if (parentheses.startsWith(")") || parentheses.length() == 2 && parentheses.startsWith("((")) {
            return false;
        }
        String replacedParentheses = parentheses.replace("()", "");
        return recursiveValidation(replacedParentheses);
    }

}
