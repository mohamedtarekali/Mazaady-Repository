package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;

public class AddProductPage {

	private WebDriver driver;

	String imageName="image.PNG";
	String imagePath=System.getProperty("user.dir")+"/uploads/"+imageName;
	//Step1 Locators
	private By NextToStep2Button = By.xpath("(//button[contains(text(),'Next Step')])[1]");
	//Step2 Locators
	private By auctionNameTextBox = By.xpath("//input[@placeholder='Auction Name']");
	private By mainCategoryDropDown = By.xpath("//label[text()='Main Category ']//following::input[1]");
	private By selectedMainCategory = By.xpath("(//*[contains(text(),'Equipments , Tools')])[3]");
	private By subCategoryDropDown = By.xpath("//label[text()='Sub category ']//following::input[1]");
	private By selectedSubCateg = By.xpath("(//*[contains(text(),'Scrap')])[2]");
	private By quantityTextBox = By.xpath("//input[@name='quantity']");
	private By productAdressTextBox = By.xpath("//input[@name='address']");	
	private By auctionDetailsIFrame = By.xpath("//iframe[@id='tinymce_description_ifr']");
	private By auctionDetailsBody = By.xpath("//body[@data-id='tinymce_description']");
	private By mainImage = By.xpath("//input[@id='main_image']");
	private By NextToStep3Button = By.xpath("(//button[contains(text(),'Next Step')])[2]");
	//Step3 Locators
	private By sellingType = By.xpath("//select[@name='selling_type']");
	private By byNowVAlueTextBox = By.xpath("//input[@placeholder='Buy Now Value']");
	private By startingBidValueTextBox = By.xpath("//input[@placeholder='Starting Bid Value']");
	private By estimatedValueTextBox = By.xpath("//input[@placeholder='Estimated Value']");
	private By datePickerButton = By.xpath("//input[@name='date']");
	private By selectedDate = By.xpath("//span[@id='mddtp-date__selected']//following::span[1]");
	private By confirmDateButton = By.id("mddtp-date__ok");
	private By timePickerButton = By.xpath("//input[@name='time']");
	private By confirmTimeButton = By.id("mddtp-time__ok");
	private By auctionShowTypeAudio = By.xpath("//span[text()='Audio']");
	private By NextToStep4Button = By.xpath("(//button[contains(text(),'Next Step')])[3]");
	//Step4 Locators
	private By AddButtonForSubmiting = By.xpath("//*[contains(text(),'Add') and @type='submit']");
	private By productAddedSuccessfullyMessage = By.xpath("//div[text()='product added successfully']");

	public AddProductPage(WebDriver driver) {
		this.driver=driver;	
	}

	@Step("User Enters Required Fields And Moves To Step 2 Of Adding new Product")
	public AddProductPage userEntersRequiredFieldsAndMoveToSecondStep() {
		driver.findElement(NextToStep2Button).click();
		return new AddProductPage(driver);
	}

	@Step("User Enters Required Fields And Moves To Step 3 Of Adding new Product")
	public AddProductPage userEntersRequiredFieldsAndMoveToThirdStep() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(auctionNameTextBox));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(auctionNameTextBox).sendKeys("test1");
		driver.findElement(mainCategoryDropDown).click();
		driver.findElement(selectedMainCategory).click();
		driver.findElement(subCategoryDropDown).click();
		driver.findElement(selectedSubCateg).click();
		driver.findElement(quantityTextBox).sendKeys("1");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(productAdressTextBox));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(productAdressTextBox).sendKeys("test2");
		WebElement iFrame1 = driver.findElement(auctionDetailsIFrame);
		driver.switchTo().frame(iFrame1);
		driver.findElement(auctionDetailsBody).sendKeys("test3");
		driver.switchTo().defaultContent();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(mainImage));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(mainImage).sendKeys(imagePath);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@class=\"image-edit display-flex cursor-pointer\"]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(NextToStep3Button));
		driver.findElement(NextToStep3Button).click();
		return new AddProductPage(driver);
	}

	@Step("User Enters Required Fields And Moves To Step 4 Of Adding new Product")
	public AddProductPage userEntersRequiredFieldsAndMoveToFourthStep() {
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='selling_type']")));
		Select select = new Select(driver.findElement(sellingType));
		select.selectByVisibleText("ESTIMATION VALUE");
		driver.findElement(byNowVAlueTextBox).sendKeys("2");
		driver.findElement(startingBidValueTextBox).sendKeys("1");
		driver.findElement(estimatedValueTextBox).sendKeys("1");
		driver.findElement(datePickerButton).click();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(selectedDate));
		driver.findElement(confirmDateButton).click();
		driver.findElement(timePickerButton).click();
		driver.findElement(confirmTimeButton).click();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(auctionShowTypeAudio));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(auctionShowTypeAudio).click();
		driver.findElement(NextToStep4Button).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return new AddProductPage(driver);
	}

	@Step("User Confirms Adding New Product")
	public AddProductPage confirmAddingProductInStep4() {
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Add') and @type='submit']")));
		driver.findElement(AddButtonForSubmiting).click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"swal-modal\"]")));
		return new AddProductPage(driver);
	}

	public By getSuccessMessageLocator() {
		return productAddedSuccessfullyMessage;
	}

}
