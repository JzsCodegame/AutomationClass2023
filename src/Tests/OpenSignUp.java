package Tests;

import org.testng.annotations.Test;

import Pages.SignIn;
import febTestNg2023.Controler;

@Test
public class OpenSignUp extends Controler{

	SignIn login;
	
	
	
	public void testlogin() {
	
	login = new SignIn(driver);
	 login.fillupformSignIn("Tanvirr","xyz@gmail.com");
	
	}
	
	
}
