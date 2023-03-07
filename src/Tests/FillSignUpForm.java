package Tests;

import org.testng.annotations.Test;

import Pages.SignUp;
import febTestNg2023.Controler;

@Test
public class FillSignUpForm extends Controler {


	
	
	public void testSignUp() throws InterruptedException {
		Thread.sleep(3000);
		
		form.fillform("20","Tanvirr");
	}
	
	
	
	
}
