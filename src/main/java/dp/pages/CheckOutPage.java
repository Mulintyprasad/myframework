package dp.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dp.utils.WaitUtils;

public class CheckOutPage {
	WebDriver driver;
	Actions a;

	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		a = new Actions(driver);
	}

	@FindBy(css = "tr[id^='product-'] .cart_total_price")
	List<WebElement> totalPriceElements;

	@FindBy(xpath = "(//p[@class='cart_total_price'])[last()]")
	private WebElement totalAmount;
	
	@FindBy(css=".form-control")
	private WebElement commentBox;
	
	@FindBy(xpath="//a[text()='Place Order']")
	private WebElement placeOrderBtn;

	public int getCartSum() {
		int sum = 0;
		for (WebElement priceEl : totalPriceElements) {
			String priceText = priceEl.getText().replace("Rs. ", "").trim();
			sum += Integer.parseInt(priceText);
		}
		return sum;
	}

	public int getCartTotal() {
		WaitUtils.visibilityOfElementLocated(driver, totalAmount, 10);
		int totalBill = Integer.parseInt(totalAmount.getText().replace("Rs. ", "").trim());
		return totalBill;

	}
	
	
	public void orderComment(String comment) {
		
		commentBox.sendKeys(comment);		
	}

public void placeOrder(){
		
		placeOrderBtn.click();		
	}


}
