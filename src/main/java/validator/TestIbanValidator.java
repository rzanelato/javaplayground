package validator;

import java.util.Optional;

import org.apache.commons.validator.routines.IBANValidator;

public class TestIbanValidator {

	public static void main(String[] args) {
		IBANValidator validator = new IBANValidator();
		System.out.println(validator.isValid("ES1521003037562200396637"));
		System.out.println(validator.isValid("IE23BOFI90054322043300"));
		

		String iban = "IE23BOFI90054322043300 ";
		System.out.println(Optional.ofNullable(iban).filter(TestIbanValidator::isValid).orElse("Errrraaaadddooo"));
	}
	
	private static boolean isValid(String iban) {
		return new IBANValidator().isValid(iban);
	}

}
