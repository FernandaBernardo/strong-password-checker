package main;

public class StrongPasswordChecker {

	public static String check(String password) {
		return checkType(password).getMessage();
	}

	private static PasswordType checkType(String password) {
		boolean hasUppercaseChar = !password.equals(password.toLowerCase());
		boolean hasLowercaseChar = !password.equals(password.toUpperCase());
		boolean hasDigit = password.matches(".*\\d.*");
		if(!(password.length() >= 6 && password.length() <= 20)) {
			return PasswordType.LENGTH;
		}
		if(!(hasUppercaseChar && hasLowercaseChar && hasDigit)) {
			return PasswordType.INVALID;
		}
		return PasswordType.STRONG;
	}

}
