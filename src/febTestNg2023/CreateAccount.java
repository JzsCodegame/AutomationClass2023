package febTestNg2023;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;





@Test
public class CreateAccount extends Controler {
	
	
	
	public void OpenBroweser() { //1st Step of the test case
		driver.get(AppUrl);
		
	}
	public void ClickSignIn() { //2nd Step of test case
		driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")).click();
	}
	public void EnterUserName() {
		Ex.until(ExpectedConditions.elementToBeClickable(UserName));
		UserName = driver.findElement(By.xpath("//input[@name='name']"));
		UserName.sendKeys("Tanvir");
	}
	public void EnterEmail() {
		driver.findElement(By.xpath("//input[starts-with(@data-qa, 'signup')][position()=2]")).sendKeys("xyz@yahoo.com");
	}
    public void Submit() {
	driver.findElement(By.xpath("//button[contains(@data-qa,'signup-button')]")).click();
	
}
}
