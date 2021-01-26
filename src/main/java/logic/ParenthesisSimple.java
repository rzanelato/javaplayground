package logic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParenthesisSimple {

    private static final String REGEX = "[\\(\\)]";

    public static boolean isValid(final String text) {
        String parenthesis = getOnlyParentheses(text);
        int countText =  parenthesis.length() / 2;
        for (int index = 0; index < countText; index++) {
            System.out.println(parenthesis);
            parenthesis = parenthesis.replace("()", "");
        }
        return parenthesis.length() == 0;
    }

    private static String getOnlyParentheses(String text) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(text);
        StringBuilder onlyParenthesisText = new StringBuilder();
        while (matcher.find()) {
            onlyParenthesisText.append(matcher.group());
        }
        return onlyParenthesisText.toString();
    }

}
