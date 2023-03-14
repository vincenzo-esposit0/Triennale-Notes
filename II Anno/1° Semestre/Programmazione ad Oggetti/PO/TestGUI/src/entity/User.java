package entity;

public class User {
	private String username, password, email;
	private double sumVoti = 0;
	private double totVoti = 0;
	
	public User(String username, String password, String email) {
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public double getMedia() {
		return sumVoti / totVoti;
	}
	
	public void vota(Double voto) {
		sumVoti += voto;
		totVoti++;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", email=" + email + "]";
	}
	
}
