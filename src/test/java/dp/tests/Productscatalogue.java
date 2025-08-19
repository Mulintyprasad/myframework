package dp.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import dp.pages.ProductPage;
import dp.pages.RegisterPage;
import dp.Base.BaseTest;
import dp.pages.CartPage;
import dp.pages.CheckOutPage;

public class Productscatalogue extends BaseTest {

	String productName = "Men Tshirt";

	@Test
	public void addProdToCart() throws InterruptedException {
		// Verify the products added to cart shouldn't be able to checkout without
		// login/registering
		ProductPage productPage = new ProductPage(driver);
		productPage.goToProducts();
		productPage.selectMenTshirt();
		Assert.assertTrue(productPage.validateMenTshirtHeader());
		productPage.getProductByName(productName);
		productPage.addProductToCart(productName);
		String actualToastMes = productPage.getToastMes();
		String expectedToastMes = "Your product has been added to cart.";
		Assert.assertEquals(actualToastMes,expectedToastMes);
//		System.out.println(productPage.getToastMes());
		productPage.goToViewCart();
		productPage.goToCheckOut();
		Assert.assertTrue(productPage.askToRegisterOrLogin(),
				"Register/Login button should be displayed when checking out without logging in");
	}

	@Test(enabled=true)
	public void verifyCartPage() {
		// login and verify if the same product added is reflecting in cart page
		// and able to checkout
		String email = "MPRASAD@gmail.com";
		String password = "Hello@123";
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.clickSignupLink();
		registerPage.enterEmailAndPassword(email, password);
		registerPage.clickLoginButton();
		ProductPage productPage = new ProductPage(driver);
		productPage.goToProducts();
		productPage.getProductByName(productName);
		productPage.addProductToCart(productName);
		productPage.goToViewCart();
		CartPage cartPage = new CartPage(driver);
		WebElement cartProduct = cartPage.getProductsInCart(productName);
		Assert.assertTrue(cartProduct.getText().contains(productName));

	}

	@Test(enabled=true)
	public void checkOutCartAndPayment() throws InterruptedException {
		String email = "MPRASAD@gmail.com";
		String password = "Hello@123";
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.clickSignupLink();
		registerPage.enterEmailAndPassword(email, password);
		registerPage.clickLoginButton();
		ProductPage productPage = new ProductPage(driver);
		productPage.goToCart();
		CartPage cartPage = new CartPage(driver);
		cartPage.goToCheckOut();
		String checkoutPageTitle = driver.getTitle();
		Assert.assertTrue(checkoutPageTitle.toLowerCase().contains("checkout"));
		CheckOutPage checkOutPage = new CheckOutPage(driver);
		int sum = checkOutPage.getCartSum();
		int total = checkOutPage.getCartTotal();
		Assert.assertEquals(sum, total);
		checkOutPage.orderComment("Test comment for checkout");
		checkOutPage.placeOrder();
		String paymentPageTitle = driver.findElement(By.xpath("//li[@class='active']")).getText();
		Assert.assertTrue(paymentPageTitle.toLowerCase().contains("payment"));

	}

}
