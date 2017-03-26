package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.StrongPasswordChecker;

public class StrongPasswordCheckerTest {

	@Test
	public void shouldHasBetween6And20Characters() {
		assertEquals(0, StrongPasswordChecker.check("password")); // >6 && <20 characters
		assertEquals(0, StrongPasswordChecker.check("passwo")); // 6 characters
		assertEquals(0, StrongPasswordChecker.check("passwordpasswordpass")); // 20 characters
		assertEquals(1, StrongPasswordChecker.check("passw")); // <6 characters
		assertEquals(1, StrongPasswordChecker.check("passwordpasswordpassw")); // >20 characters
	}
}
