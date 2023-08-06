package telran.user.model;

public class User {
	private String emale;
	private String password;

	public User(String emale, String password) {
		setEmale(emale);
		setPassword(password);
	}

	public String getEmale() {
		return emale;
	}

	public void setEmale(String emale) {
		if (isEmaleValid(emale)) {
			this.emale = emale;
		} else {
			System.out.println(emale + " is not valid");
		}
	}

	/*
	 * 1) @ exist and only one 2) dot after @ 3) after last dot 2 and more symbols
	 * 4) alphabet, digits, _ , - , . , @
	 */
	private boolean isEmaleValid(String emale) {
		int indexAt = emale.indexOf('@');
		if (indexAt == -1 || indexAt != emale.lastIndexOf('@')) {
			return false;
		}
		if (emale.indexOf('.', indexAt) == -1) {
			return false;
		}
		if (emale.lastIndexOf('.') > (emale.length() - 3)) {
			return false;
		}
		for (int i = 0; i < emale.length(); i++) {
			char c = emale.charAt(i);
			if (!(c == '_' || c == '-' || c == '.' || c == '@' || Character.isDigit(c) || Character.isAlphabetic(c))) {
				return false;
			}
		}
		return true;
	}

	public String getPassword() {
		return password;
	}

	/*
	 * 1) length >=8 2) min one digit 3) min one symbol in upperCase 4) min one
	 * symbol in lowerCase 5) min one as a special symbol = !@%"&
	 */

	public void setPassword(String password) {
		if (isPasswordValid(password)) {
			this.password = password;
		} else {
			System.out.println(password + " is not valid");
		}
	}

	private boolean isPasswordValid(String password) {
		if (password.length() >= 8) {
			boolean isLowerCase = false;
			boolean isDigit = false;
			boolean isUpperCase = false;
			boolean isSpecialSym = false;
			for (int i = 0; i < password.length(); i++) {
				char p = password.charAt(i);
				if (Character.isLowerCase(p)) {
					isLowerCase = true;
				}
				if (Character.isDigit(p)) {
					isDigit = true;
				}
				if (Character.isUpperCase(p)) {
					isUpperCase = true;
				}
				if (password.indexOf('!') >= 0 || password.indexOf('@') >= 0 || password.indexOf('%') >= 0
						|| password.indexOf('"') >= 0 || password.indexOf('&') >= 0) {
					isSpecialSym = true;
				}
			}
			if (isDigit & isLowerCase & isUpperCase & isSpecialSym) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "User [emale=" + emale + ", password=" + password + "]";
	}

}
