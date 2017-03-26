package main;

public class StrongPasswordChecker {

	public static String check(String password) {
		return checkType(password).getMessage();
	}

	private static PasswordType checkType(String password) {
		if(password.length() < 6) {
			return PasswordType.SMALL_PASS;
		}
		if(password.length() > 20) {
			return PasswordType.BIG_PASS;
		}
		boolean hasUppercaseChar = !password.equals(password.toLowerCase());
		if(!hasUppercaseChar) {
			return PasswordType.UPPERCASE;
		}
		boolean hasLowercaseChar = !password.equals(password.toUpperCase());
		if(!hasLowercaseChar) {
			return PasswordType.LOWERCASE;
		}
		boolean hasDigit = password.matches(".*\\d.*");
		if(!hasDigit) {
			return PasswordType.DIGIT;
		}

		for(int i = 0; i < password.length() - 2; i++) {
			char firstChar = password.charAt(i);
			if(firstChar == password.charAt(i+1) && firstChar == password.charAt(i+2)) {
				return PasswordType.REPEATED_CHARACTERS;
			}
		}

		return PasswordType.STRONG;
	}

}
