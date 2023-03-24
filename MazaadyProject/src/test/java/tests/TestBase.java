package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.qameta.allure.Step;

public class TestBase {
	public WebDriver driver;
	String URL="https://mazaady.com/";

	@BeforeClass
	@Step("User Navigates To Main Page Of Website")
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
	}
	@Step("User Close The WebSite")
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
