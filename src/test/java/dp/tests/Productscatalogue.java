package dp.tests;


import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import dp.Base.BaseTest;
import dp.pages.ProductPage;
import dp.pages.RegisterPage;

public class Productscatalogue extends BaseTest {
		
	
		String productName = "Men Tshirt";
		
	@Test(invocationCount=1)
	public void ProductsList() throws InterruptedException {
		
		ProductPage productPage =new ProductPage(driver);
		productPage.goToProducts();
		productPage.selectMenTshirt();
        Assert.assertTrue(productPage.validateMenTshirtHeader());
        productPage.getProductByName(productName);
        productPage.addProductToCart(productName);
        Assert.assertEquals(productPage.getToastMes(), "Added!");
        System.out.println(productPage.getToastMes());
        productPage.goToCart();
        WebElement cartProduct =productPage.getProductsInCart(productName);
        Assert.assertTrue(cartProduct.getText().contains("Tshirt"),
                "Cart does not contain the expected product: " + productName);
        productPage.goToCheckOut();
        Assert.assertTrue(productPage.askToRegisterOrLogin(),"Register/Login button should be displayed when checking out without logging in");
        
        
        

        
//		WaitUtils.waitForElementToBeClickable(driver, By.xpath("//a[@href='#Men']"), 10).click();
////		driver.findElement(By.xpath("//a[@href='#Men']")).click();
//		WaitUtils.waitForElementToBeClickable(driver, By.xpath("//*[text()='Tshirts ']"), 10).click();
////		driver.findElement(By.xpath("//*[text()='Tshirts ']")).click();
//		String tShirtHeader = driver.findElement(By.xpath("//*[text()='Men - Tshirts Products']")).getText();
//		String expectedTshirtHeader = "Men - Tshirts Products";
//		Assert.assertTrue(expectedTshirtHeader.equalsIgnoreCase(tShirtHeader));
//		List<WebElement> Tshirts = driver
//				.findElements(By.xpath("//div[@class='features_items']/div[@class='col-sm-4']"));
//		WebElement prod = Tshirts.stream()
//				.filter(product -> product.getText().contains(productName)).findFirst()
//				.orElse(null);
//		prod.findElement(By.cssSelector(".btn")).click();
//		String toast = WaitUtils.visibilityOfElementLocated(driver, By.cssSelector(".modal-content div h4"), 10)
//				.getText();		
////		String toast = driver.findElement(By.cssSelector(".modal-content div h4")).getText();
//		Assert.assertEquals(toast, "Added!");

	}
	
		@Test(enabled=true)
		public void verifyCartPage() {
			
			String email = "MPRASAD@gmail.com";
			String password = "Hello@123";
			RegisterPage registerPage = new RegisterPage(driver);
			registerPage.clickSignupLink();
			registerPage.enterEmailAndPassword(email, password);
			registerPage.clickLoginButton();
			ProductPage productPage =new ProductPage(driver);
			productPage.goToProducts();
	        productPage.getProductByName(productName);
	        productPage.addProductToCart(productName);
	        productPage.goToCart();
	        
	    


			
			
			
		}
		
	
	
	

}
