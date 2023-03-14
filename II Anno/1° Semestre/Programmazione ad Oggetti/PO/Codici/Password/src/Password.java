public class Password {
	
	public boolean checkPassword(String password){
	 String passwordPattern = "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,50}";
	 java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(passwordPattern);
	 java.util.regex.Matcher matcher = pattern.matcher(password);
	 return matcher.matches();
	}
}