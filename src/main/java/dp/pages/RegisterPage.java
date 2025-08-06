package dp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dp.utils.WaitUtils;

public class RegisterPage {
	WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Home and login&Signup
	@FindBy(xpath = "//a[contains(text(),'Signup')]")
	private WebElement signupLink;

	@FindBy(xpath = "//h2[contains(text(),'New User Signup!')]")
	private WebElement newUserSignUpText;

	@FindBy(xpath = "//input[@placeholder='Name']")
	private WebElement nameField;

	@FindBy(xpath = "//input[@data-qa='signup-email']")
	private WebElement emailField;
	
	@FindBy(xpath = "//button[contains(text(),'Signup')]")
	private WebElement signupButton;
	
	
	@FindBy(css = "input[data-qa='login-email']")
	private WebElement loginEmailField;
	
//	driver.findElement(By.cssSelector("input[data-qa='login-email']")).sendKeys(email);
	@FindBy(css = "input[data-qa='login-password']")
	private WebElement loginPasswordField;
//	driver.findElement(By.cssSelector("input[data-qa='login-password']")).sendKeys(password);


	@FindBy(css = "[data-qa='login-button']")
	private WebElement loginButton;

	
//	driver.findElement(By.cssSelector("[data-qa='login-button']")).click();

	// Account Info Page
	@FindBy(xpath = "//h2[@class='title text-center']/b[contains(text(),'Account')]")
	private WebElement accountInfoText;

	@FindBy(id = "id_gender1")
	private WebElement genderMaleRadio;

	@FindBy(id = "password")
	private WebElement passwordField;

	@FindBy(css = "select[id='days'] option[value='1']")
	private WebElement dayDropdown;

	@FindBy(css = "select[id='months'] option[value='8']")
	private WebElement monthDropdown;

	@FindBy(css = "select[id='years'] option[value='1999']")
	private WebElement yearDropdown;

	@FindBy(id = "newsletter")
	private WebElement newsletterCheckbox;

	@FindBy(id = "optin")
	private WebElement optinCheckbox;

	@FindBy(id = "first_name")
	private WebElement firstNameField;

	@FindBy(id = "last_name")
	private WebElement lastNameField;

	@FindBy(id = "company")
	private WebElement companyField;

	@FindBy(id = "address1")
	private WebElement address1Field;

	@FindBy(id = "address2")
	private WebElement address2Field;

	@FindBy(css = "select[id='country'] option[value='India']")
	private WebElement countryDropdown;

	@FindBy(id = "state")
	private WebElement stateField;

	@FindBy(id = "city")
	private WebElement cityField;

	@FindBy(id = "zipcode")
	private WebElement zipcodeField;

	@FindBy(id = "mobile_number")
	private WebElement mobileField;

	@FindBy(xpath = "//button[contains(text(),'Create Account')]")
	private WebElement createAccountButton;

	// Account Created Confirmation
	@FindBy(xpath = "//h2[@data-qa='account-created']/b[contains(text(),'Account Created')]")
	private WebElement accountCreatedMsg;

	@FindBy(xpath = "//a[contains(text(),'Continue')]")
	private WebElement continueButton;

	@FindBy(xpath = "//a/b")
	private WebElement loggedUser;

	@FindBy(css = "i[class='fa fa-trash-o']")
	private WebElement deleteAccountIcon;

	@FindBy(xpath = "//a[contains(text(),'Continue')]")
	private WebElement continueAfterDeleteButton;

	// Actions for page

	public void clickSignupLink() {
		signupLink.click();
	}

	public boolean isNewUserSignupVisible() {
		return newUserSignUpText.isDisplayed();
	}

	public void enterNameAndEmail(String name, String email) {
		nameField.sendKeys(name);
		emailField.sendKeys(email);
	}
	
	public void enterEmailAndPassword(String email, String password) {
		loginEmailField.sendKeys(email);
		loginPasswordField.sendKeys(password);
	}
	
	public void clickLoginButton() {
		loginButton.click();
	}

	public void clickSignupButton() {
		signupButton.click();
	}

	public boolean isAccountInfoVisible() {
		return accountInfoText.isDisplayed();
	}

	public void selectGenderMale() {
		if (!genderMaleRadio.isSelected()) {
			genderMaleRadio.click();
		}
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void selectDOB() {
		dayDropdown.click();
		monthDropdown.click();
		yearDropdown.click();
	}

	public void selectNewsLetter() {
		if (!newsletterCheckbox.isSelected()) {
			newsletterCheckbox.click();
		}
		if (!optinCheckbox.isSelected()) {
			optinCheckbox.click();
		}
	}

	public void enterAddress(String firstName, String lastName, String company, String address1, String address2,
			String state, String city, String zipcode, String mobile) {
		firstNameField.sendKeys(firstName);
		lastNameField.sendKeys(lastName);
		companyField.sendKeys(company);
		address1Field.sendKeys(address1);
		address2Field.sendKeys(address2);
		countryDropdown.click();
		stateField.sendKeys(state);
		cityField.sendKeys(city);
		zipcodeField.sendKeys(zipcode);
		mobileField.sendKeys(mobile);
	}

	public void clickCreateAccount() {
		createAccountButton.click();
	}

	public boolean isAccountCreatedVisible() {
		return accountCreatedMsg.isDisplayed();
	}

	public void clickContinue() {
		continueButton.click();
	}

	public String getLoggedUsername() {
		return loggedUser.getText();
	}

	public void deleteAccount() {
		WaitUtils.waitForElementToBeClickable(driver, deleteAccountIcon, 10).click();
		continueAfterDeleteButton.click();
	}

}
