package logic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParenthesesFinal {
	
	private final String REGEX = "[\\(\\)]";

	public static void main(String[] args) {
		ParenthesesFinal para = new ParenthesesFinal();
		
		System.out.println("Result True: "+para.isValid("(if (any? x) sum (/1 x))"));
		System.out.println("Result False: "+para.isValid("())("));
		System.out.println("Result True: "+para.isValid("I said (it's not (yet) complete). (she didn't listen)"));
		System.out.println("Result False: "+para.isValid(":-)"));
		System.out.println("Result True: "+para.isValid("(((()))(()))"));
		System.out.println("Result False: "+para.isValid("(((()))(())"));
		System.out.println("Result True: "+para.isValid("(($1 and $2) or $3)"));
		System.out.println("Result False: "+para.isValid("(($1 and $2) or ($3 or $1)"));

	}
	
	public boolean isValid(String text) {
		String parentheses = getParentheses(text);
		if (parentheses.length() == 0) {
			return true;
		}
		boolean isOddParentheses = parentheses.length() % 2 == 1;
		if (isOddParentheses) {
			return false;
		}
		if (parentheses.startsWith(")")) {
				return false;
		}
		String replacedParentheses = parentheses.replace("()", "");
		return isValid(replacedParentheses);
	}

	private String getParentheses(String text) {
		Pattern p = Pattern.compile(REGEX);
		Matcher m = p.matcher(text);
		StringBuilder returnText = new StringBuilder();
		while (m.find()) {
			returnText.append(m.group());
		}
		return returnText.toString();
	}

}
