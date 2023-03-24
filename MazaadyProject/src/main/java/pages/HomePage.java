package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;

public class HomePage {

	private WebDriver driver;
	private By profileActions = By.xpath("(//span[@class='action-icons-text'])[1]");
	private By loginNavigationButton = By.xpath("(//a[@href='https://mazaady.com/login'])[1]");
	private By AddProductNavigationButton = By.xpath("(//a[@href='https://mazaady.com/add-product'])[1]");

	public HomePage(WebDriver driver) {
		this.driver=driver;	
	}

	@Step("User Navigates To LOgin Page")
	public LoginPage navigateToLoginPage() {
		driver.findElement(profileActions).click();
		driver.findElement(loginNavigationButton).click();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return new LoginPage(driver);
	}

	@Step("User Navigates To Add Product Page")
	public AddProductPage navigateToAddProductPage() {
		driver.findElement(profileActions).click();
		driver.findElement(AddProductNavigationButton).click();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return new AddProductPage(driver);
	}

	public By getProfileActionsLocator() {
		return profileActions;
	}

}
