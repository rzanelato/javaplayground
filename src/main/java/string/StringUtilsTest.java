package string;

import org.apache.commons.lang3.StringUtils;

public class StringUtilsTest {

	public static void main(String[] args) {
		System.out.println("Teste - text");
		stringUtils("text");
		System.out.println("Teste - \"\"");
		stringUtils("");
		System.out.println("Teste - \" \"");
		stringUtils(" ");
		System.out.println("Teste - null");
		stringUtils(null);
	}

	private static void stringUtils(String text) {
		System.out.println("isNoneBlank: " + StringUtils.isNoneBlank(text));
		System.out.println("isNotBlank: " + StringUtils.isNotBlank(text));
		System.out.println("isNoneEmpty: " + StringUtils.isNoneEmpty(text));
		System.out.println("isNotEmpty: " + StringUtils.isNotEmpty(text));
		System.out.println();
	}
}
