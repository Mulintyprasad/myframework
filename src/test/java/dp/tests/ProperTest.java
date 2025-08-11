package dp.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;
import dp.Base.BaseTest;
import dp.pages.RegisterPage;
import dp.utils.WaitUtils;

public class ProperTest extends BaseTest {

	String email = "MPRASAD@gmail.com";

	String password = "Hello@123";
	String wrongpassword = "sdf345";

	
	@Test(enabled =true)
	public void registerNewUser() throws IOException {
//		String actualTitle = driver.getTitle();
//		String expectedTitle = "Automation Exercise";
//		Assert.assertEquals(actualTitle, expectedTitle, "failed to load the home page");
		RegisterPage registerPage = new RegisterPage(driver);

		registerPage.clickSignupLink();
		Assert.assertTrue(registerPage.isNewUserSignupVisible());

		registerPage.enterNameAndEmail("MPRASAD", "deletionACC@gmail.com");
		registerPage.clickSignupButton();
		Assert.assertTrue(registerPage.isAccountInfoVisible());

		registerPage.selectGenderMale();
		registerPage.enterPassword(password);
		registerPage.selectDOB();
		registerPage.selectNewsLetter();

		registerPage.enterAddress("Durga", "Prasad", "TESTCOMPANY", "hno 123,testaddress", "address2 test",
				"Andhra pradesh", "Kurnool", "518001", "9988776655");

		registerPage.clickCreateAccount();
		Assert.assertTrue(registerPage.isAccountCreatedVisible());

		registerPage.clickContinue();
		System.out.println(registerPage.getLoggedUsername());

		registerPage.deleteAccount();
		System.out.println("test1");

	}

	@Test(priority = 2)
	public void loginPositive() {
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.clickSignupLink();
		registerPage.enterEmailAndPassword(email, password);
		registerPage.clickLoginButton();
//		WaitUtils.visibilityOfElementLocated(driver, By.cssSelector("[class='fa fa-lock']"), 10);
		String userName = WaitUtils.waitForElementToBeClickable(driver, By.xpath("//li[10]//a[1]"), 10).getText();
		System.out.println("test2");
		System.out.println(userName);

	}

	@Test(priority = 3)
	public void loginNegative() {
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.clickSignupLink();
		registerPage.enterEmailAndPassword(email, wrongpassword);
		registerPage.clickLoginButton();
		String errorMes = WaitUtils
				.visibilityOfElementLocated(driver, By.xpath("//p[contains(text(),'incorrect')]"), 10).getText();
		System.out.println("test3");
		System.out.println(errorMes);
		Assert.assertEquals(errorMes,"Your email or password is incorrect!");

	}
}
