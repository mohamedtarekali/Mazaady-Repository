package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;

public class LoginPage {

	private WebDriver driver;
	private By emailAddress = By.id("email");
	private By password = By.id("password");
	private By loginButton = By.xpath("//button[text()='Login']");

	public LoginPage(WebDriver driver) {
		this.driver=driver;	
	}
	@Step("User Enters Valid Email Adress And Password And Clicks ON LOgin Button")
	public HomePage userLoginWithValidUserAndPass(String email , String pass) {
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		driver.findElement(emailAddress).sendKeys(email);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(loginButton).click();
		return new HomePage(driver);
	}
}
