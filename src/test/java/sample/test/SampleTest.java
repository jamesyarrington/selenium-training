package sample.test;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import sample.page.GooglePage;

public class SampleTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void simplePassingTest() {
		assertTrue("This should always pass", true);
		// This is to make sure that everything is working, before we continue on.
	}

	@Test
	public void simpleFailingTest() {
		assertTrue("This should always fail", false);
		// This is to make sure that failing tests will fail.
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
		
		// Perform a Search for "Selenium"
		driver.findElementByClassName("gsfi").sendKeys("Selenium");
		driver.findElementByName("btnK").click();
		
		// Assert that at least one of the results is Selenium's home page:
		boolean found = false;
		for (WebElement element : driver.findElementsByTagName("cite")) {
			if (element.getText().contains("https://www.seleniumhq.org/")) {
				found = true;
				break;
			}
		}
		assertTrue("The Selenium homepage should be found.", found);
		
		// Close the driver when done.
		driver.close();
	}
	
	@Test
	public void useReadableLocators() {
		// This test goes through the same actions as the above test, but uses the Page Object.
		
		// Create the WebDriver object.  This is needed to send commands to the browser.
		ChromeOptions options = new ChromeOptions();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jyarrington\\Code\\node_modules\\chromedriver\\lib\\chromedriver\\chromedriver.exe");
		options.setBinary(new File("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe"));
		ChromeDriver driver = new ChromeDriver(options);
		
		// Navigate to google's home page.
		driver.get("http://www.google.com");
		
		// Create the Page Object
		GooglePage google = new GooglePage(driver);
		
		// Perform a Search for "Selenium", using the PageObject
		google.searchBar.sendKeys("Selenium");
		google.searchButton.click();
		
		// Assert that at least one of the results is Selenium's home page:
		boolean found = false;
		for (WebElement element : google.searchResultURLs) {
			if (element.getText().contains("https://www.seleniumhq.org/")) {
				found = true;
				break;
			}
		}
		assertTrue("The Selenium homepage should be found.", found);
		
		// Close the driver when done.
		driver.close();
	}
	
	@Test
	public void usePageObjectMethods() {
		// By adding methods to the Page Object, you abstract even more
		// of the element-finding logic from the test logic, making the
		// tests even more readable.
		
		// Create the WebDriver object.  This is needed to send commands to the browser.
		ChromeOptions options = new ChromeOptions();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jyarrington\\Code\\node_modules\\chromedriver\\lib\\chromedriver\\chromedriver.exe");
		options.setBinary(new File("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe"));
		ChromeDriver driver = new ChromeDriver(options);

		// Create the Page Object
		GooglePage google = new GooglePage(driver);
		
		// Navigate to google's home page.
		google.goToHomePage();
		
		// Perform a Search for "Selenium", using the PageObject
		google.performSearch("Selenium");
		
		// Assert that at least one of the results is Selenium's home page:
		assertTrue("The Selenium homepage should be found.",
				google.resultsContain("https://www.seleniumhq.org/")
				);
		
		// Close the driver when done.
		driver.close();
	}
	
	

}
