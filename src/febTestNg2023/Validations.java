package febTestNg2023;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Pages.SignIn;
import Pages.SignUp;

public class Validations extends Controler {

	private SignUp Page;
    
	public Validations(WebDriver driver, By enterEmail, SignUp Page) {     //, By enterEmail) 
    	super();        
    	this.driver = driver;
    	this.Page = Page;
    	PageFactory.initElements(driver, Page);
    }
	
	
    public void assertTitle(String expectedTitle) {
		String actualTitle = driver.getTitle().trim();
		Assert.assertEquals(actualTitle, expectedTitle, "Actual title '" + actualTitle + "' does not match expected title '" + expectedTitle + "'");
	}
    
    
    public void assertUrl(String expectedUrl) {
    	String actualUrl = driver.getCurrentUrl().trim();
    	Assert.assertEquals(actualUrl, expectedUrl, "Actual URL '" + actualUrl + "' does not match expected URL '" + expectedUrl + "'");
    }
    
    
    public void assertXpath(By xpath, String expectedText) {
        try {
            Thread.sleep(3000); // Wait for 3 second to allow the input field to be updated
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement element = driver.findElement(xpath);
        String actualText = element.getAttribute("value").trim();
        Assert.assertEquals(actualText, expectedText, "Actual text '" + actualText + "' does not match expected text '" + expectedText + "' for XPath expression: " + xpath.toString());
    }
    
    
  public void assertXpath1(WebElement element, String expectedText) {
        try {
            Thread.sleep(3000); // Wait for 3 second to allow the input field to be updated
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //xpath = driver.findElement(xpath));
        String actualText = element.getAttribute("value").trim();
        Assert.assertEquals(actualText, expectedText, "Actual text '" + actualText + "' does not match expected text '" + expectedText + "' for XPath expression: " + element.toString());
    }
  
  
    
    public void assertElementSelected(By by) {
    	WebElement element = driver.findElement(by);
    	Assert.assertTrue(element.isSelected(), "Element is not selected: " + by);
    }
    
    
    public void assertElementSelected2(WebElement element) {
    	//WebElement element = driver.findElement(by);
    	Assert.assertTrue(element.isSelected(), "Element is not selected: " + element);
    }
    
    
    public void assertElementEnabled(By by) {
    	WebElement element = driver.findElement(by);
    	Assert.assertTrue(element.isEnabled(), "Element is not enabled: " + by);
    }
    
    
    public void assertElementEnabled2(WebElement element) {
    	//WebElement element = driver.findElement(by);
    	Assert.assertTrue(element.isEnabled(), "Element is not enabled: " + element);
    }
    
    
    public void assertElementDisplayed(By by) {
    	WebElement element = driver.findElement(by);
    	Assert.assertTrue(element.isDisplayed(), "Element is not displayed: " + by);
    }
    
    
    public void assertElementDisplayed2(WebElement element) {
    	//WebElement element = driver.findElement(by);
    	Assert.assertTrue(element.isDisplayed(), "Element is not displayed: " + element);
    }
   
    
    public void assertDropdownSelected(By dropdown, String expectedOption) {
    	Select select = new Select(driver.findElement(dropdown));
    	String actualOption = select.getFirstSelectedOption().getText().trim();
    	Assert.assertEquals(actualOption, expectedOption, "Actual dropdown selection '" + actualOption + "' does not match expected selection '" + expectedOption + "'");
    }
    
    public void assertDropdownSelected2(WebElement dropdown, String expectedOption) {
    	Select select = new Select(dropdown);
    	String actualOption = select.getFirstSelectedOption().getText().trim();
    	Assert.assertEquals(actualOption, expectedOption, "Actual dropdown selection '" + actualOption + "' does not match expected selection '" + expectedOption + "'");
    }
    
    
    public void assertCheckboxSelected(By checkbox) {
    	Assert.assertTrue(driver.findElement(checkbox).isSelected(), "Checkbox is not selected: " + checkbox);
    	
    }
    
    
    
    public void assertCheckboxSelected2(WebElement checkbox) {
    	Assert.assertTrue(checkbox.isSelected(), "Checkbox is not selected: " + checkbox);
    	Assert.assertTrue(checkbox.isDisplayed(), "Element is not displayed: " + checkbox);
    }
    
    
    public void assertRadioButtonSelected(By radioGroup, String expectedOption) {
    	List<WebElement> radioButtons = driver.findElements(radioGroup);
    	String actualOption = "";
    	for (WebElement radioButton : radioButtons) {
    		if (radioButton.isSelected()) {
    			actualOption = radioButton.getText().trim();
    			break;
    		}
    	}
    	Assert.assertEquals(actualOption, expectedOption, "Actual radio button selection '" + actualOption + "' does not match expected selection '" + expectedOption + "'");
    }
    public void assertAlertPresent() {
    	try {
    		driver.switchTo().alert();
    		Assert.assertTrue(true, "Alert is present on the page");
    	} catch (NoAlertPresentException e) {
    		Assert.fail("Alert is not present on the page");
    	}
    }
    public void assertListSize(By by, int expectedSize) {
    	List<WebElement> elements = driver.findElements(by);
    	int actualSize = elements.size();
    	if (actualSize == expectedSize) {
    		Assert.assertTrue(true, "List size matches the expected size: " + expectedSize);
    	} else {
    		Assert.fail("List size does not match the expected size. Actual size: " + actualSize + ", Expected size: " + expectedSize);
    	}
    }
    public void assertListContains(By by, String expectedText) {
    	List<WebElement> elements = driver.findElements(by);
    	for (WebElement element : elements) {
    		String actualText = element.getText().trim();
    		if (actualText.equals(expectedText)) {
    			Assert.assertTrue(true, "List contains the expected text: " + expectedText);
    			return;
    		}
    	}
    	Assert.fail("List does not contain the expected text: " + expectedText);
    }
    private boolean isElementPresent(By xpath) {
        try {
            driver.findElement(xpath);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void assertElementPresent(By xpath) {
        Assert.assertTrue(isElementPresent(xpath), "Element is present: " + xpath);
    }

    
    public void assertElementNoPresent(By by) {
        Assert.assertFalse(driver.findElement(by).isDisplayed(), "Element not found: " + by);
    }

    public void assertString(String actualString, String expectedString) {
        Assert.assertEquals(actualString, expectedString);
    }

    public void assertTrue(boolean statement, String message) {
        Assert.assertTrue(statement, message);
    }

    public void assertFalse(boolean statement, String message) {
        Assert.assertFalse(statement, message);
    }

}
