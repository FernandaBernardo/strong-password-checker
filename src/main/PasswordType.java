package main;

public enum PasswordType {
	STRONG (0, "The password is strong"),
	INVALID (1, "The password is invalid"),
	LENGTH (1, "The password must have between 6 and 20 characters"),
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
