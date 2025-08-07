package dp.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import dp.Base.BaseTest;
import dp.utils.WaitUtils;

public class Productscatalogue extends BaseTest {

	@Test
	public void ProductsList(){
		
		driver.findElement(By.cssSelector("i[class*=' card_travel']")).click();
		
		WaitUtils.waitForElementToBeClickable(driver, By.xpath("//a[@href='#Men']"), 10).click();
//		driver.findElement(By.xpath("//a[@href='#Men']")).click();
		WaitUtils.waitForElementToBeClickable(driver, By.xpath("//*[text()='Tshirts ']"), 10).click();

//		driver.findElement(By.xpath("//*[text()='Tshirts ']")).click();
		String tShirtHeader=driver.findElement(By.xpath("//*[text()='Men - Tshirts Products']")).getText();
		String expectedTshirtHeader = "Men - Tshirts Products";
		Assert.assertTrue(expectedTshirtHeader.equalsIgnoreCase(tShirtHeader));
		
	}
	
}
