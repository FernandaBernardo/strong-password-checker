package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.PasswordType;
import main.StrongPasswordChecker;

public class StrongPasswordCheckerTest {

	@Test
	public void shouldHasBetween6And20Characters() {
		assertNotEquals(PasswordType.BIG_PASS.getMessage(), StrongPasswordChecker.check("password")); // >6 && <20 characters
		assertNotEquals(PasswordType.SMALL_PASS.getMessage(), StrongPasswordChecker.check("password")); // >6 && <20 characters
		assertNotEquals(PasswordType.SMALL_PASS.getMessage(), StrongPasswordChecker.check("passwo")); // 6 characters
		assertNotEquals(PasswordType.BIG_PASS.getMessage(), StrongPasswordChecker.check("passwordpasswordpass")); // 20 characters
		assertEquals(PasswordType.SMALL_PASS.getMessage(), StrongPasswordChecker.check("passw")); // <6 characters
		assertEquals(PasswordType.BIG_PASS.getMessage(), StrongPasswordChecker.check("passwordpasswordpassw")); // >20 characters
	}

	@Test
	public void shouldHasLowercaseUppercaseOrDigit() {
		assertEquals(PasswordType.UPPERCASE.getMessage(), StrongPasswordChecker.check("password2"));
		assertEquals(PasswordType.LOWERCASE.getMessage(), StrongPasswordChecker.check("PASSWORD"));
		assertEquals(PasswordType.DIGIT.getMessage(), StrongPasswordChecker.check("passWord"));
		assertEquals(PasswordType.STRONG.getMessage(), StrongPasswordChecker.check("pasSword2"));
	}

	@Test
	public void shouldNotRepeatCharacterMoreThanThreeTimes() {
		assertEquals(PasswordType.REPEATED_CHARACTERS.getMessage(), StrongPasswordChecker.check("1Abababcaaaababababa"));
		assertEquals(PasswordType.STRONG.getMessage(), StrongPasswordChecker.check("1Ababbabcaababababa"));
	}
}
