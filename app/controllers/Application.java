package controllers;

import models.User;
import play.mvc.Before;
import play.mvc.Controller;

public class Application extends Controller {

	@Before
	static void setConnectedUser() {
		User user = Security.userConnected();
		renderArgs.put("user", user);
	}

    public static void index() {

		render();
    }
    
	public static void logout() throws Throwable {
		Secure.logout();
		index();
	}

}