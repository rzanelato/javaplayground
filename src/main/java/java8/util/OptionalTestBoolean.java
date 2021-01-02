package java8.util;

import java.util.Optional;

public class OptionalTestBoolean {
	
	public static void main(String[] args) throws Exception {
		boolean isExists = false;
		
		
		Optional.ofNullable(isExists).filter(isValid -> isValid).orElseThrow(() -> new Exception("FALSE"));
	}

}
