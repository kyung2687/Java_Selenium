package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

public class Selenium {

	public static void main(String[] args) {
		Selenium sel = new Selenium();
		sel.crawl();
	}
	//WebDriver
	private WebDriver driver;
	
	private WebElement webElement;
	
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH = "D:\\selenium\\chromedriver.exe";
	
	private String base_url = "https://nid.naver.com/nidlogin.login";
	
	public Selenium() {
		super();
		
		//System Property Setup
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		
		//Driver Setup
		ChromeOptions options = new ChromeOptions();
		options.setCapability("ignoreProtectedModeSetting", true);
		driver = new ChromeDriver(options);
	}
	
	public void crawl() {
		try {
			driver.get(base_url);
			
			//driver.switchTo().frame(driver.findElement(By.id()));
			
			webElement = driver.findElement(By.id("id"));
			String user_id = "asdf";
			webElement.sendKeys(user_id);
			
			webElement = driver.findElement(By.id("pw"));
			String user_pw = "asdf";
			webElement.sendKeys(user_id);
			
			driver.findElement(By.className("btn_global")).submit();
			//webElement = driver.findElement(By.className("btn_global"));
			//webElement.submit()
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
	}
}
