package tests;

import org.testng.annotations.Test;
import data.ExcelReader;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pages.HomePage;
import utilities.TestListener;

import static org.testng.Assert.assertNotEquals;
import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

@Listeners({ TestListener.class})
@Epic("Regression 01")
@Feature("User Profile")
public class testLogin extends TestBase {

	@DataProvider(name="userDataFromExcel")
	public Object[][] userRegisterData() throws IOException
	{
		// get data from Excel Reader class 
		ExcelReader ER = new ExcelReader("LoginData");
		return ER.getExcelData();
	}

	@Test(priority=1,dataProvider="userDataFromExcel" , description="User CAn LOgin")
	@Description("User Can Login With VAlid Email & Password")
	@Severity(SeverityLevel.CRITICAL)
	@Story("User Login - 12345")
	public void userSuccessfullyLogin(String email , String pass) {
		new HomePage(driver).navigateToLoginPage().userLoginWithValidUserAndPass(email, pass);
		assertNotEquals(driver.findElement(new HomePage(driver).getProfileActionsLocator()).getText().toString() , "Login");
	}



}
