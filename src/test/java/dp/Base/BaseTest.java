package dp.Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	public Properties prop;
	ChromeOptions cOptions = new ChromeOptions();
	FirefoxOptions fOptions = new FirefoxOptions();
	EdgeOptions eOptions = new EdgeOptions();

	@BeforeMethod
	public void initializeDriverAndLaunchApp() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\config.properties");
		prop.load(fis);

		String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
				: prop.getProperty("browser");

		if (browserName.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			cOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
			if (browserName.contains("headless")) {
				cOptions.addArguments("headless");
			}
			driver = new ChromeDriver(cOptions);
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			fOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
			driver = new FirefoxDriver(fOptions);
		} else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\durga\\Downloads\\edgedriver_win64\\msedgedriver.exe");
			eOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
			driver = new EdgeDriver();
		} else {
			throw new IllegalArgumentException("Browser not supported:" + browserName);
		}

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();

	}

	@AfterMethod
	public void TearDown() {

		driver.quit();
	}

}
