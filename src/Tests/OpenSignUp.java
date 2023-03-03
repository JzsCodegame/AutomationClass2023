package Tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

import Pages.SignIn;
import febTestNg2023.Controler;


@Test
public class OpenSignUp extends Controler{

	SignIn login = null;
	
	
	@Test(priority = 0)
	public void testlogin() {
	
	login = new SignIn(driver);
	//login.OpenApp(AppUrl);
	 //login.ClickSignIn();
	
	login.fillupformSignIn(AppUrl,"Tanvirr","xyx@gmail1.com");
	Reporter.log("Test completed successfully.", true);
	}
	
	
}
