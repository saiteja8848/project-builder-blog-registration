package businesslogic;

public class RegistrationValidation {
	public boolean checkUserDetails(String email, String password, String confirmPassword) {
		boolean result = true;
		boolean passwordStatus = validPassword(password, confirmPassword);
		boolean emailStatus = validEmail(email);
		if (passwordStatus == true && emailStatus == true)
			result = true;
		else
			result = false;
		return result;
	}

	public boolean validPassword(String password, String confirmPassword) {

		boolean result = true;
		if (password != "" && confirmPassword != "" && password.equals(confirmPassword)) {
			if (password.length() >= 8 && password.length() <= 20) {
				int ucount = 0, lcount = 0, ncount = 0;
				for (int i = 0; i < password.length(); i++) {
					if (Character.isDigit(password.charAt(i))) {
						ncount++;
					} else if (Character.isUpperCase(password.charAt(i))) {
						ucount++;
					} else if (Character.isLowerCase(password.charAt(i))) {
						lcount++;
					}
				}
				if (ucount >= 1 && lcount >= 1 && ncount >= 1) {
					result = true;
				} else
					result = false;
			} else
				result = false;
		} else
			result = false;
		return result;
	}

	private boolean validEmail(String email) {
		boolean result = true;
		if (email.length() > 10) {
			result = true;
		} else
			result = false;
		return result;
	}

}