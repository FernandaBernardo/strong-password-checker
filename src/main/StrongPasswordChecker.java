package main;

public class StrongPasswordChecker {

	public static int check(String password) {
		if(password.length() >= 6 && password.length() <= 20) return 0;
		return 1;
	}

}
