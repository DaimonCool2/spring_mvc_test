package kz.java.training.entity;

import javax.validation.GroupSequence;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import kz.java.training.validation.sequence.First;
import kz.java.training.validation.sequence.Second;

@GroupSequence({ First.class, Second.class, User.class })
public class User {
	private static final String USERNAME_PATTERN = "[a-zA-Z0-9_\\-]{3,}";
	private static final String PASSWORD_PATTERN = "[a-zA-Z0-9_\\-]{6,}";

	@NotEmpty(message = "Пустое поле", groups = First.class)
	@Pattern(regexp = USERNAME_PATTERN, message = "{username.pattern.error}", groups = Second.class)
	private String username;

	@NotEmpty(message = "Пустое поле", groups = First.class)
	@Pattern(regexp = PASSWORD_PATTERN, message = "{password.pattern.error}", groups = Second.class)
	private String password;

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

}
