package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.PasswordType;
import main.StrongPasswordChecker;

public class StrongPasswordCheckerTest {

	@Test
	public void shouldHasBetween6And20Characters() {
		assertNotEquals(PasswordType.LENGTH.getMessage(), StrongPasswordChecker.check("password")); // >6 && <20 characters
		assertNotEquals(PasswordType.LENGTH.getMessage(), StrongPasswordChecker.check("passwo")); // 6 characters
		assertNotEquals(PasswordType.LENGTH.getMessage(), StrongPasswordChecker.check("passwordpasswordpass")); // 20 characters
		assertEquals(PasswordType.LENGTH.getMessage(), StrongPasswordChecker.check("passw")); // <6 characters
		assertEquals(PasswordType.LENGTH.getMessage(), StrongPasswordChecker.check("passwordpasswordpassw")); // >20 characters
	}

	@Test
	public void shouldHasLowercaseUppercaseOrDigit() {
		assertEquals(PasswordType.INVALID.getMessage(), StrongPasswordChecker.check("passWord"));
		assertEquals(PasswordType.INVALID.getMessage(), StrongPasswordChecker.check("password2"));
		assertEquals(PasswordType.STRONG.getMessage(), StrongPasswordChecker.check("pasSword2"));
	}
}
