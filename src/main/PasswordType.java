package main;

public enum PasswordType {
	STRONG (0, "The password is strong") {
		@Override
		public String condition(String password) {
			return getMessage();
		}
	},
	SMALL_PASS (1, "The password must have at least 6 characters") {
		@Override
		public String condition(String password) {
			if(password.length() < 6) return getMessage();
			else return BIG_PASS.condition(password);
		}
	},
	BIG_PASS (1, "The password must have less than 20 characters") {
		@Override
		public String condition(String password) {
			if(password.length() > 20) return getMessage();
			else return UPPERCASE.condition(password);
		}
	},
	UPPERCASE (1, "The password must have at least one uppercase character") {
		@Override
		public String condition(String password) {
			if(password.equals(password.toLowerCase())) return getMessage();
			else return LOWERCASE.condition(password);
		}
	},
	LOWERCASE (1, "The password must have at least one lowercase character") {
		@Override
		public String condition(String password) {
			if(password.equals(password.toUpperCase())) return getMessage();
			else return PasswordType.DIGIT.condition(password);
		}
	},
	DIGIT (1, "The password must have at least one digit") {
		@Override
		public String condition(String password) {
			if(!password.matches(".*\\d.*")) return getMessage();
			else return PasswordType.REPEATED_CHARACTERS.condition(password);
		}
	},
	REPEATED_CHARACTERS(1, "The password must NOT contain three repeating characters") {
		@Override
		public String condition(String password) {
			for(int i = 0; i < password.length() - 2; i++) {
				char firstChar = password.charAt(i);
				if(firstChar == password.charAt(i+1) && firstChar == password.charAt(i+2)) {
					return getMessage();
				}
			}
			return STRONG.condition(password);
		}
	}
	;

	private int state;
	private String message;
	public String password;

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
	
	public abstract String condition(String password);
	
	public static String execute(String password) {
		return SMALL_PASS.condition(password);
	}
}
