package listenrs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class Base{
	public static WebDriver driver;
	
	@BeforeTest
	public void openBrowser() {
		
		
		System.setProperty("webdriver.chrome.driver", "/Users/anamulhoque/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://www.google.com");
	}
	

}
