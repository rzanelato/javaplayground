package string;

import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class StringCodificacao {

	public static void main(String[] args) {
		String utf8 = "Coração";
		String iso = "Coração";
		/*
		 * System.out.println(new String(utf8.getBytes(), "UTF-8"));
		System.out.println(new String(iso.getBytes(), "Cp1252"));
		System.out.println(new String(utf8.getBytes("ISO-8859-1")));
		System.out.println(new String (utf8.getBytes("UTF-8")));
		
		 */
		System.out.println(codingCp(iso));
		System.out.println(codingIso(iso));
		System.out.println(codingUtf(iso));
		

	}
	
	private static String codingCp(String str) {
		try {
			return new String (str.getBytes("Cp1252"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		}
	}
	
	private static String codingIso(String str) {
		try {
			return new String (str.getBytes("ISO-8859-3"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		}
	}
	
	private static String codingUtf(String str) {
		try {
			return new String (str.getBytes("UTF8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		}
	}

}
