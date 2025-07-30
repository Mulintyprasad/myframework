package dp.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;
import dp.Base.BaseTest;
import dp.pageobjects.RegisterPage;
import dp.utils.WaitUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ProperTest extends BaseTest{
	
	String email = "MPRASAD@gmail.com";
	
	String password = "Hello@123";
 
	@Test(enabled=false)
	public void registerNewUser() throws IOException{
		String actualTitle = driver.getTitle();
		String expectedTitle = "Automation Exercise";
		Assert.assertEquals(actualTitle, expectedTitle, "failed to load the home page");
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

//		registerPage.deleteAccount();
	
		
	}
	
	@Test
	 public void loginPositive() {
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.clickSignupLink();
		registerPage.enterEmailAndPassword(email, password);
		registerPage.clickLoginButton();
		WaitUtils.visibilityOfElementLocated(driver, By.cssSelector("[class='fa fa-lock']"), 10);
		String userName =driver.findElement(By.xpath("//li[10]//a[1]")).getText();
		System.out.println(userName);
		
	
		
////		driver.findElement(By.cssSelector("input[data-qa='login-email']")).sendKeys(email);
//		driver.findElement(By.cssSelector("input[data-qa='login-password']")).sendKeys(password);
//		driver.findElement(By.cssSelector("[data-qa='login-button']")).click();

		
		
		
	}
}
