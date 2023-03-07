package febTestNg2023;


import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import Pages.SignIn;
import Pages.SignUp;
import io.github.bonigarcia.wdm.WebDriverManager;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class Controler {

	public WebDriver driver; 
		public static String AppUrl;
			public JavascriptExecutor js1;
				public WebDriverWait Ex;
					public ChromeOptions options;
						public SignIn login;
							public SignUp form;
	
	
//	public static ExtentReports extentReports;
 //   public static ExtentTest extentTest;
	//WebElement UserName;
	
	@BeforeSuite()
	public void config() {
	//	 ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir") + "/Reports/ExtentReport.html"));
	 //       extentReports = new ExtentReports();
	        //extentReports.attachReporter(htmlReporter);
	
	//System.setProperty("webdriver.chrome.driver","chromedriver.exe");
	
	AppUrl = "https://automationexercise.com/";
	options = new ChromeOptions();
	options.addArguments("--headless=new");
	
}
	@BeforeTest()
	public void setup() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver(options);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	login = new SignIn(driver);
	form = new SignUp(driver);
	}
	
	@BeforeClass
	 public void Synchronize() {
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@BeforeMethod() 
	public void BrowserConfig() {
		 //We maximize or change browser based on our preference.
		Ex = new WebDriverWait(driver, 15);
	}
	
	@AfterMethod()
	public void validations(){
    	System.out.println("Validations succesfully");// We validate our code executions.
    	System.out.println("Method executed succesfully");
    	//Ex = new WebDriverWait(driver, 10);
    }
	@AfterTest()
	public void BrowserClosing() throws InterruptedException, IOException, AWTException {
		
	    String testNgReportPath = "test-output\\index.html"; // Replace with the path to your TestNG report

	    File reportFile = new File(testNgReportPath);
	    if (!reportFile.exists()) {
	        System.out.println("Report file not found: " + testNgReportPath);
	        return;
	    }

	    try {
	        Desktop.getDesktop().browse(reportFile.toURI());
	    	//js1.executeScript("window.open('test-output\\index.html')");
	        Thread.sleep(5000); // Wait for the page to load

	        // Capture the screenshot
	       /* Robot robot = new Robot();
	        BufferedImage screenshot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));

	        // Save the screenshot to a folder
	        String folderName = "screenshots";
	        File folder = new File(folderName);
	        if (!folder.exists()) {
	            folder.mkdir();
	        }
	        String screenshotName = "screenshot-" + System.currentTimeMillis() + ".png";
	        File screenshotFile = new File(folderName + "\\" + screenshotName);
	        ImageIO.write(screenshot, "png", screenshotFile);

	        System.out.println("Screenshot saved to: " + screenshotFile.getAbsolutePath());
	        // Close the window after 30 seconds
	        Thread.sleep(30000);
	        robot.keyPress(KeyEvent.VK_ALT);
	        robot.keyPress(KeyEvent.VK_F4);
	        robot.keyRelease(KeyEvent.VK_F4);
	        robot.keyRelease(KeyEvent.VK_ALT);*/
	        
	        
	    } catch (IOException e) {
	        System.out.println("Error opening report file: " + e.getMessage());
	    } 
	}
    	
	@AfterSuite
	public void terminate() {
		driver.quit(); // We close the instance and terminate the session. It will erase all the cache memory and make our next execution better.
	}
	
}