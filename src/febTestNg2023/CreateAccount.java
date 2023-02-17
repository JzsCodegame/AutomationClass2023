package febTestNg2023;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;





@Test
public class CreateAccount extends Controler {
	
	
	@Test(priority = 0)
	public void OpenBroweser() { //1st Step of the test case
		driver.get(AppUrl);
		
	}
	@Test(priority = 1)
	public void ClickSignIn() throws InterruptedException { //2nd Step of test case
		
		driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")).click();
	}
	
	@Test(priority = 2)
	public void EnterUserName() {
		
		UserName = driver.findElement(By.xpath("//input[@name='name']"));
		
		Ex.until(ExpectedConditions.elementToBeClickable(UserName));
		
		UserName.sendKeys("Tanvir");
	}
	
	@Test(priority = 3)
	public void EnterEmail() {
		driver.findElement(By.xpath("//input[starts-with(@data-qa, 'signup')][position()=2]")).sendKeys("xyz@yahoo.com");
	}
	
	@Test(priority = 4)
    public void Submit() {
	driver.findElement(By.xpath("//button[contains(@data-qa,'signup-button')]")).click();
	
}
}
