package dp.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import dp.Base.BaseTest;
import dp.utils.WaitUtils;

public class Productscatalogue extends BaseTest {

	@Test
	public void ProductsList() throws InterruptedException {

		driver.findElement(By.cssSelector("i[class*=' card_travel']")).click();
		WaitUtils.waitForElementToBeClickable(driver, By.xpath("//a[@href='#Men']"), 10).click();
//		driver.findElement(By.xpath("//a[@href='#Men']")).click();
		WaitUtils.waitForElementToBeClickable(driver, By.xpath("//*[text()='Tshirts ']"), 10).click();
//		driver.findElement(By.xpath("//*[text()='Tshirts ']")).click();
		String tShirtHeader = driver.findElement(By.xpath("//*[text()='Men - Tshirts Products']")).getText();
		String expectedTshirtHeader = "Men - Tshirts Products";
		Assert.assertTrue(expectedTshirtHeader.equalsIgnoreCase(tShirtHeader));
		List<WebElement> Tshirts = driver
				.findElements(By.xpath("//div[@class='features_items']/div[@class='col-sm-4']"));
		WebElement prod = Tshirts.stream()
				.filter(product -> product.getText().contains("GRAPHIC DESIGN MEN T SHIRT - BLUE")).findFirst()
				.orElse(null);
		prod.findElement(By.cssSelector(".btn")).click();
		String toast = WaitUtils.visibilityOfElementLocated(driver, By.cssSelector(".modal-content div h4"), 10)
				.getText();
//		String toast = driver.findElement(By.cssSelector(".modal-content div h4")).getText();
		Assert.assertEquals(toast, "Added!");
		System.out.println("productcatalouge test ");

	}

}
