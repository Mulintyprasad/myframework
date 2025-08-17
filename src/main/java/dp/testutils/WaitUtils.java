package dp.testutils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

	public static WebElement waitForElementToBeClickable(WebDriver driver, By locator, int timeoutSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
		
		
	}
	public static WebElement waitForElementToBeClickable(WebDriver driver, WebElement element, int timeoutSeconds) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
	    return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static WebElement visibilityOfElementLocated(WebDriver driver, By locator, int timeoutSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}
	
	public static WebElement visibilityOfElementLocated(WebDriver driver, WebElement element, int timeoutSeconds) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
	    return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static WebElement presenceOfElementLocated(WebDriver driver, By locator, int timeoutSeconds) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
	    return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
    public static Boolean waitForElementToBeInvisible(WebDriver driver, By locator, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
}
