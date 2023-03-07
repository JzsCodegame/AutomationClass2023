package Tests;

//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.Test;

//import Pages.SignIn;
//import Pages.SignUp;
import febTestNg2023.Controler;


@Test
public class OpenSignUp extends Controler{

	
	
	
	@Test(priority = 0)
	public void testlogin() {
	//login = new SignIn(driver);
	  //login.OpenApp(AppUrl);
		//login.ClickSignIn();
	login.fillupformSignIn(AppUrl,"Tanvirr","xyx@gmail1.com");
		Reporter.log("Test completed successfully.", true);
	}
	
	 @Test(priority = 1)
	public void testSignUp() throws InterruptedException {
		Thread.sleep(3000);
		//SignUp form = new SignUp(driver);
		form.fillform("20","Tanvirr");
	} 
}
