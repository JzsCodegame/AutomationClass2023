package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import febTestNg2023.Controler;
import febTestNg2023.Validations;


public class SignIn extends Controler {
	 
	//SignUp Page;
	Validations validate;
	
	By SignIn = By.xpath("//*[@id='header']/div/div/div/div[2]/div/ul/li[4]/a");
	By UserName = By.xpath("//input[@name='name']");
	By EnterEmail= By.xpath("//input[starts-with(@data-qa, 'signup')][position()=2]");
	By SubmitButton= By.xpath("//button[contains(@data-qa,'signup-button')]");
	
	
	
	public SignIn(WebDriver driver) {
		super();
		this.driver = driver;
		validate = new Validations(driver, EnterEmail);
		
	}
	
	public void OpenApp(String AppUrls) {
		driver.get(AppUrls);	
		}
	  
	
	
public String getSignInTitle() {

	      return driver.getTitle();
	    }
	    
	  public void ClickSignIn() {

	       driver.findElement(SignIn).click();
	       
	   	validate.assertElementPresent(SignIn);
	    }
	  
	    //Set email in email textbox

	    
	  public void EnterUserName(String username) {

	       driver.findElement(UserName).sendKeys(username);
	       validate.assertTrue(true, username);
	       

	    }
	  
	  public void EnterEmailAddress(String email) {

	       driver.findElement(EnterEmail).sendKeys(email);
	       try {
	           Thread.sleep(2000); // wait for 1 second to allow the input field to be updated
	       } catch (InterruptedException e) {
	           e.printStackTrace();
	       }
	       
	       validate.assertXpath(EnterEmail, email);

	    }
	    
	  //Click on Craete Account button

	    public void clickAccountButton() {
	    	validate.assertElementEnabled(SubmitButton);
	            driver.findElement(SubmitButton).click();
	            

	    }
	    
	    public void fillupformSignIn(String AppUrls, String usernameX, String emailX) {
	    	this.OpenApp(AppUrls);
	    	this.ClickSignIn();
	    	this.EnterUserName(usernameX);
	    	this.EnterEmailAddress(emailX);
	    	this.clickAccountButton();
	    	
	    	
	    	
	    	
	    	
	    	
	    }
}
