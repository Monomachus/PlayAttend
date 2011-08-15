package controllers;

import models.User;
import play.libs.Codec;

public class Security extends Secure.Security {

	static boolean authenticate(String username, String password) {
		User user = User.find("byName", username).first();
		return user != null && user.passwordHash.equals(Codec.hexMD5(password));
	}

	static User userConnected() {
		String username = Secure.Security.connected();
		User user = User.find("byName", username).first();

		return user;
	}

}
