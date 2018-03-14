package sample.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage {
	WebDriver driver;

	// The FindBy annotation simplifies how web elements are found.
	// These items can be called in the test code by calling, for example:
	// google.searchBar
	
	@FindBy(className = "gsfi")
	public WebElement searchBar;
	@FindBy(name = "btnK")
	public WebElement searchButton;
	@FindBy(tagName = "cite")
	public List<WebElement> searchResultURLs;
	
	String homepage = "http://www.google.com";
	
	
	public GooglePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void goToHomePage() {
		driver.get(homepage);
	}
	
	public void performSearch(String search) {
		searchBar.sendKeys(search);
		searchButton.click();
	}
	
	public boolean resultsContain(String expectedURL) {
		for (WebElement element : searchResultURLs) {
			if (element.getText().contains(expectedURL)) {
				return true;
			}
		}
		return false;
	}
	
}
