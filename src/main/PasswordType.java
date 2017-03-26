package main;

public enum PasswordType {
	STRONG (0, "The password is strong"),
	INVALID (1, "The password is invalid"),
	SMALL_PASS (1, "The password must have at least 6 characters"),
	BIG_PASS (1, "The password must have less than 20 characters"),
	UPPERCASE (1, "The password must have at least one uppercase character"),
	LOWERCASE (1, "The password must have at least one lowercase character"),
	DIGIT (1, "The password must have at least one digit"),
	REPEATED_CHARACTERS(1, "The password must NOT contain three repeating characters")
	;

	private int state;
	private String message;

	private PasswordType(int state, String message) {
		this.state = state;
		this.message = message;
	}

	public int getState() {
		return state;
	}

	public String getMessage() {
		return message;
	}

}
