package dp.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.asserts.SoftAssert;

import dp.utils.WaitUtils;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterTest {

	@Test
	public void registerNewUser() {

		WebDriverManager.chromedriver().setup();

//		ChromeOptions co = new ChromeOptions();
//		co.addArguments("--headless");
		WebDriver driver = new ChromeDriver();

		driver.get("https://automationexercise.com/");
		driver.manage().window().maximize();
		SoftAssert softAssert = new SoftAssert();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		String at = driver.getTitle();
		String et = "Automation Exercise";
		Assert.assertEquals(at, et, "failed to load the home page");
		WaitUtils.waitForElementToBeClickable(driver, By.xpath("//a[contains(text(),'Signup')]"), 10).click();
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Signup')]"))).click();
		WebElement newUserSignUpText = WaitUtils.visibilityOfElementLocated(driver,
				By.xpath("//h2[contains(text(),'New User Signup!')]"), 10);
//		WebElement newUserSignUpText = wait.until(
//				ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'New User Signup!')]")));
		softAssert.assertTrue(newUserSignUpText.isDisplayed(), "New user signup! not visible");

//		Boolean newuservisibibilty = driver.findElement(By.xpath("//h2[contains(text(),'New User Signup!')]"))
//				.isDisplayed();
//		softAssert.assertFalse(newuservisibibilty);
		driver.findElement(By.xpath(" //input[@placeholder='Name']")).sendKeys("MPRASAD");
		driver.findElement(By.xpath("//input[@data-qa='signup-email' ] ")).sendKeys("MPRASAD@gmail.com");
		driver.findElement(By.xpath("//button[contains(text(),'Signup')]")).click();
		WebElement enterAccInfo = WaitUtils.visibilityOfElementLocated(driver,
				By.xpath("//h2[@class='title text-center']/b[contains(text(),'Account')]"), 10);
//		WebElement enterAccInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//h2[@class='title text-center']/b[contains(text(),'Account')]")));
		softAssert.assertTrue(enterAccInfo.isDisplayed(), "ENTER A/C INFO IS NOT VISIBLE");
//		Boolean enterac = driver.findElement(By.xpath("//h2[@class='title text-center']/b[contains(text(),'Account')]"))
//				.isDisplayed();
//		softAssert.assertTrue(enterac);

		WebElement radioGender = driver.findElement(By.id("id_gender1"));
		if (!radioGender.isSelected()) {
			radioGender.click();
		}

		driver.findElement(By.id("password")).sendKeys("Hello@123");
		driver.findElement(By.cssSelector("select[id='days'] option[value='1']")).click();
		driver.findElement(By.cssSelector("select[id='months'] option[value='8']")).click();
		driver.findElement(By.cssSelector("select[id='years'] option[value='1999']")).click();

		WebElement newsLetter = driver.findElement(By.id("newsletter"));
		if (!newsLetter.isSelected()) {
			newsLetter.click();
		}

		WebElement newsLetter2 = driver.findElement(By.id("optin"));
		if (!newsLetter2.isSelected()) {
			newsLetter2.click();
		}
		driver.findElement(By.id("first_name")).sendKeys("Durga");
		driver.findElement(By.id("last_name")).sendKeys("Prasad");
		driver.findElement(By.id("company")).sendKeys("TESTCOMPANY");
		driver.findElement(By.id("address1")).sendKeys("hno 123,testaddress");
		driver.findElement(By.id("address2")).sendKeys("address2 test");
		driver.findElement(By.cssSelector("select[id='country'] option[value='India']")).click();
		driver.findElement(By.id("state")).sendKeys("Andhra pradesh");
		driver.findElement(By.id("city")).sendKeys("Kurnool");
		driver.findElement(By.id("zipcode")).sendKeys("518001");
		driver.findElement(By.id("mobile_number")).sendKeys("9988776655");
		driver.findElement(By.xpath("//button[contains(text(),'Create Account')]")).click();

		WebElement accountCreatedMsg = WaitUtils.visibilityOfElementLocated(driver,
				By.xpath("//h2[@data-qa='account-created']/b[contains(text(),'Account Created')]"), 10);
		Assert.assertTrue(accountCreatedMsg.isDisplayed(), "'ACCOUNT CREATED!' message is not visible.");

		WaitUtils.waitForElementToBeClickable(driver, By.xpath("//a[contains(text(),'Continue')]"), 10).click();
		WebElement loggedUser = WaitUtils.visibilityOfElementLocated(driver, By.xpath("//a/b"), 10);
		String username = loggedUser.getText();
		System.out.println("Logged in as: " + username);

//		String username = driver.findElement(By.xpath("//a/b")).getText();
//		System.out.println(username);
		driver.findElement(By.cssSelector("i[class='fa fa-trash-o'] ")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();
		softAssert.assertAll();
		driver.quit();

	}

	

}
