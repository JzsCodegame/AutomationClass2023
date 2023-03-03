package Tests;

import org.testng.annotations.Test;

import Pages.SignUp;
import febTestNg2023.Controler;

@Test
public class FillSignUpForm extends Controler {

	SignUp form = null;
	
	@Test(priority = 1)
	public void testSignUp() throws InterruptedException {
		form = new SignUp(driver);
		form.fillform("20","Tanvirr");
	}
	
	
	
	
}
