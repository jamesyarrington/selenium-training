package sample.test;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SampleTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void simplePassingTest() {
		System.out.println("Just a JUnit Test");
		// With nothing here, this test should pass.
		// This is to make sure that everything is working, before we continue on.
	}
	
	@Test
	public void googleSearchSeleniumTest() {
		// This test will go to www.google.com, and look for the google logo.
		
		// Create the WebDriver object.  This is needed to send commands to the browser.
		ChromeOptions options = new ChromeOptions();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jyarrington\\Code\\node_modules\\chromedriver\\lib\\chromedriver\\chromedriver.exe");
		options.setBinary(new File("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe"));
		ChromeDriver driver = new ChromeDriver(options);
		
		// Navigate to google's home page.
		driver.get("http://www.google.com");
		System.out.println("Chrome Driver Created!");
		
		// Perform a Search for "Selenium"
		driver.findElementByClassName("gsfi").sendKeys("Selenium");
		driver.findElementByName("btnK").click();
		
		// Assert that the first link is to the Selenium website:
		assertEquals(driver.findElementsByTagName("cite").get(0).getText(), "https://www.seleniumhq.org/");
		
		// Close the driver when done.
		driver.close();
	}

}
