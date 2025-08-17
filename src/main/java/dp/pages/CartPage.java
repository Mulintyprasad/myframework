package dp.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dp.testutils.WaitUtils;

public class CartPage {
	WebDriver driver;
	Actions a;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		a = new Actions(driver);
	}

	@FindBy(xpath = "//tbody//tr//td[@class='cart_description']//a")
	List<WebElement> productsinCart;

	@FindBy(xpath = "//a[contains(@class,'check_out')]")
	private WebElement checkoutBtn;

	@FindBy(xpath = "//u[text()='Register / Login']")
	private WebElement registerOrLogin;

	public WebElement getProductsInCart(String productName) {

		WebElement cartProd = productsinCart.stream().filter(product -> product.getText().contains(productName))
				.findFirst().orElse(null);
		return cartProd;
	}

	public void goToCheckOut() {
		WaitUtils.visibilityOfElementLocated(driver, checkoutBtn, 10).click();
	}

	public void goToRegisterOrLogin() {
		WaitUtils.visibilityOfElementLocated(driver, registerOrLogin, 10).click();

	}

	public boolean askToRegisterOrLogin() {
		WebElement registerOrlogin = WaitUtils.visibilityOfElementLocated(driver, registerOrLogin, 10);
		return registerOrlogin.isDisplayed();
	}

}
