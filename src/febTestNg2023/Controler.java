package febTestNg2023;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class Controler {

	WebDriver driver;
	String AppUrl;
	WebDriverWait Ex;
	WebElement UserName;
	
	@BeforeSuite()
	public void config() {
	
	System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Java\\jdk-19\\Selenium Tools\\chromedriver.exe");
	AppUrl = "https://automationexercise.com/";
	
}
	@BeforeTest()
	public void setup() {
		driver = new ChromeDriver();
	}
	
	@BeforeClass
	 public void Synchronize() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Ex = new WebDriverWait(driver, 10);
	}
	
	@BeforeMethod() 
	public void BrowserConfig() {
		driver.manage().window().maximize(); //We maximize or change browser based on our preference.
		//Ex = new WebDriverWait(driver, 15);
	}
	
	@AfterMethod()
	public void validations(){
    	System.out.println("Validations succesfully");// We validate our code executions.
    	System.out.println("Method executed succesfully");
    	
    }
	@AfterTest()
	public void BrowserClosing() throws InterruptedException {
		Thread.sleep(2000); //We use thread.sleep to make Java wait so we can see our execution results.
		driver.close();// We close the browser
		
	}
	@AfterSuite
	public void terminate() {
		driver.quit(); // We close the instance and terminate the session. It will erase all the cache memory and make our next execution better.
	}
	
}