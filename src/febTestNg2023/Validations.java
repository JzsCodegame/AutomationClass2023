package febTestNg2023;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Validations extends Controler {

//private WebDriver driver;

    public Validations(WebDriver driver) {
    	super();        
    	this.driver = driver;
    }

    public void assertXpath(String xpath, String expectedText) {
        WebElement element = driver.findElement(By.xpath(xpath));
        String actualText = element.getText();
        Assert.assertEquals(actualText, expectedText);
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
    public void assertElementPresent(By by) {
        Assert.assertTrue(driver.findElement(by).isDisplayed(), "Element not found: " + by);
    }

    public void assertElementNotPresent(By by) {
        Assert.assertFalse(isElementPresent(by), "Element is present: " + by);
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
