package tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import data.ExcelReader;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pages.AddProductPage;
import pages.HomePage;
import utilities.TestListener;

@Listeners({ TestListener.class})
@Epic("Regression 01")
@Feature("Product")
public class TestAddProduct extends TestBase{

	@DataProvider(name="userDataFromExcel")
	public Object[][] userRegisterData() throws IOException
	{
		// get data from Excel Reader class 
		ExcelReader ER = new ExcelReader("LoginData");
		return ER.getExcelData();
	}

	@Test(priority=1,dataProvider="userDataFromExcel" , description="User CAn Add Product")
	@Description("User Can Login With VAlid Email & Password Then He Can Add Product")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Add Product - 6789")
	public void userSuccessfullyAddProduct(String email , String pass) {
		new HomePage(driver).navigateToLoginPage().userLoginWithValidUserAndPass(email, pass).navigateToAddProductPage().userEntersRequiredFieldsAndMoveToSecondStep().userEntersRequiredFieldsAndMoveToThirdStep().userEntersRequiredFieldsAndMoveToFourthStep().confirmAddingProductInStep4();
		assertTrue(driver.findElement(new AddProductPage(driver).getSuccessMessageLocator()).isDisplayed());
	}

}
