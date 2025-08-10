package dp.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dp.utils.WaitUtils;

public class ProductPage {
	WebDriver driver;
	Actions a;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		a =new Actions(driver);
	} 
	
	@FindBy(css = "i[class*=' card_travel']")
	private WebElement productsLink;

	@FindBy(xpath = "//a[@href='#Men']")
	private WebElement menCategory;

	@FindBy(xpath = "//*[text()='Tshirts ']")
	private WebElement tshirtCategory;

	@FindBy(xpath = "//*[text()='Men - Tshirts Products']")
	private WebElement header;
	
	@FindBy(xpath="//u[text()='View Cart']")
	private WebElement viewCart;
	
	@FindBy(xpath="//button[text()='Continue Shopping']")
	private WebElement continueShopping;
	
	@FindBy(xpath = "//tbody//tr//td[@class='cart_description']//a")
	List<WebElement> productsinCart;
	
	@FindBy(xpath="//a[contains(@class,'check_out')]")
	private WebElement checkoutBtn;
	
	@FindBy(xpath="//u[text()='Register / Login']")
	private WebElement registerOrLogin;
	
	
	By addT0Cart = By.cssSelector(".btn");
	By toastMes = By.cssSelector(".modal-content div h4");
	By byProductsLink = By.cssSelector("i[class*=' card_travel']");

	@FindBy(xpath = "//div[@class='features_items']/div[@class='col-sm-4']")
	List<WebElement> productsOnPage;

	
	
	
	public void goToProducts() {
		WaitUtils.presenceOfElementLocated(driver, byProductsLink, 10).click();
	}

	public void selectMenTshirt() {
		WaitUtils.waitForElementToBeClickable(driver, menCategory, 10).click();
		WaitUtils.waitForElementToBeClickable(driver, tshirtCategory, 10).click();
	}

	public boolean validateMenTshirtHeader() {
		String expectedTshirtHeader = "Men - Tshirts Products";
		String tshirtHeader = header.getText();
		return tshirtHeader.equalsIgnoreCase(expectedTshirtHeader);
	}

	public WebElement getProductByName(String productName) {

		WebElement prod = productsOnPage.stream().filter(product -> product.getText().contains(productName)).findFirst()
				.orElse(null);
		return prod;
	}

	public WebElement getProductsInCart(String productName) {

		WebElement cartProd = productsinCart.stream().filter(product -> product.getText().contains(productName)).findFirst()
				.orElse(null);
		return cartProd;
	}	
	
		public void addProductToCart(String productName) {
			WebElement prod = getProductByName(productName);
			prod.findElement(addT0Cart).click();
//			WebElement desiredEle = prod.findElement(addT0Cart);
//			a.moveToElement(desiredEle).click().perform();

			}
		
	
	public String getToastMes() {
    return(WaitUtils.visibilityOfElementLocated(driver, toastMes, 10).getText());
	}

		
	public void goToCart() {
		WaitUtils.visibilityOfElementLocated(driver, viewCart, 10).click();
	}
	
	public void continueShopping() {
		WaitUtils.visibilityOfElementLocated(driver, continueShopping, 10).click();
	}
	
	public void goToCheckOut() {
		WaitUtils.visibilityOfElementLocated(driver, checkoutBtn, 10).click();
	}
	public void goToRegisterOrLogin() {
		WaitUtils.visibilityOfElementLocated(driver, registerOrLogin, 10).click();
	}
	
	public boolean askToRegisterOrLogin() {
		WebElement registerOrlogin=WaitUtils.visibilityOfElementLocated(driver, registerOrLogin, 10);
		return registerOrlogin.isDisplayed();
	}
	
}
