package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import febTestNg2023.Controler;
import febTestNg2023.Validations;

public class SignUp extends Controler {
	
Validations validate;
	@FindBy(css="#id_gender1")
	WebElement Mr;
	
	@FindBy(css="input[id='id_gender2']")
	WebElement Mrs;
	
	@FindBy(css="select[name*='days']")
	WebElement Days;
	
	@FindBy(css="input[id^='first']")
	WebElement FirstName;

	@FindBy(css="input[id='optin'][value='1']")
	WebElement CheckBox1;

public SignUp(WebDriver driver) {
	super();
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
}

public void selectMr() {
	Mr.click();
	validate.assertElementSelected2(Mr);
	
}

public void selectMrs() {
	Mrs.click();
	validate.assertElementEnabled2(Mrs);
}

public void selectDays(String inputdays) {
	Days.click();
	Select sinput = new Select(Days);
	sinput.selectByValue(inputdays);
	validate.assertDropdownSelected2(Days, inputdays);
} 

public void selectFirstName(String name) {
	FirstName.click();
	FirstName.sendKeys(name);
	validate.assertXpath1(FirstName, name);
}

public void selectCheckBox1() {
	CheckBox1.click();
	validate.assertCheckboxSelected2(CheckBox1);
}


public void fillform(String inputdays, String name) throws InterruptedException {

	this.selectMr();
	this.selectMrs();
	this.selectDays(inputdays);
	this.selectFirstName(name);
	this.selectCheckBox1();
	

}
}



