package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import febTestNg2023.Controler;

public class SignIn extends Controler {

	By SignIn = By.xpath("//*[@id=\\\"header\\\"]/div/div/div/div[2]/div/ul/li[4]/a");
	By UserName = By.xpath("//input[@name='name']");
	By EnterEmail= By.xpath("//input[starts-with(@data-qa, 'signup')][position()=2]");
	By SubmitButton= By.xpath("//button[contains(@data-qa,'signup-button')]");
	
	
	
	public SignIn(WebDriver driver) {
		super();
		this.driver = driver;
		
	}
	  public String getSignInTitle() {

	      return driver.getTitle();
	    }
	    
	  public void ClickSignIn() {

	       driver.findElement(SignIn).click();

	    }
	  
	    //Set email in email textbox

	    
	  public void EnterUserName(String username) {

	       driver.findElement(UserName).sendKeys(username);
	       

	    }
	  
	  public void EnterEmailAddress(String email) {

	       driver.findElement(EnterEmail).sendKeys(email);
	       

	    }
	    
	  //Click on Craete Account button

	    public void clickAccountButton() {

	            driver.findElement(SubmitButton).click();

	    }
	    
	    public void fillupformSignIn(String usernameX, String emailX) {
	    	this.ClickSignIn();
	    	this.EnterUserName(usernameX);
	    	this.EnterEmailAddress(emailX);
	    	this.clickAccountButton();
	    	
	    	
	    	
	    	
	    	
	    	
	    }
}
