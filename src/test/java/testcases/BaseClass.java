package testcases;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import pageobjects.CertificationPage;
import utilities.ReadConfig;

public class BaseClass {
	ReadConfig readconfig = new ReadConfig();

	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	public String passwordnormaluser = readconfig.getPasswordNormalUser();
	public String usernamenormaluser = readconfig.getUsernameNormalUser();
	public String invalidusername = readconfig.getInvalidUsername();
	public String invalidpassword = readconfig.getInvalidPassword();
	public String textsearchfield = readconfig.gettextsearchfield();

	public static WebDriver driver;
	public static Logger log;
	public CertificationPage loginpage;
	
	

	@BeforeMethod
	public void setup() {
		log = LogManager.getLogger(BaseClass.class);
		System.setProperty("webdriver.chrome.driver", readconfig.getChromepath());
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(option);
		driver.get(baseURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		loginpage = new CertificationPage(driver);
	

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	// This Method is used wait and click on weblement to clickable
	public static void clickOnWebElement(WebElement element, long waitTimeInseconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeInseconds));
			WebElement elements = null;
			elements = wait.until(ExpectedConditions.elementToBeClickable(element));
			elements.click();
		} catch (Exception e) {

		}

	}

	// This Method is used to moveAndClick
	public static void moveAndClick(WebElement element) {
		try {
			element.click(); // try clicking the element
		} catch (ElementClickInterceptedException e) {
			// the click was intercepted, perform an alternative action
			Actions actions = new Actions(driver);
			actions.moveToElement(element, -10, -10).click().build().perform();
		}
	}

	// This Method is used to elementToBeVisible
	public static void elementToBeVisible(WebElement element1, long waitTimeInseconds1) {

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(waitTimeInseconds1));
		w.until(ExpectedConditions.presenceOfElementLocated((By) element1));
	}

	// This Method is used to elementToBeVisible
	public static void elementToBeVisibleLocator(By locator, long waitTimeInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeInSeconds));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static void elementToBeVisibleB(WebDriver driver, WebElement element11, int timeout) {
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By) element11));
	}

	// This Method is used to sendkeys(character ,number ) on give text field
	public static void sendKeys(WebElement element, String text) {
		waitForElement(element, 20);
		element.click();
		element.clear();
		element.sendKeys(text);
	}

	private static void waitForElement(WebElement element, int i) {
		// TODO Auto-generated method stub
	}

	// This Method is used to take screenshot on failure oif test case ( calling
	// this method in listeners class to capture screenshot on test case failure)
	public String captureScreen(String tname, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String target = System.getProperty("user.dir") + "\\Screenshot\\" + tname + ".png";
		FileUtils.copyFile(source, new File(target));
		return target;
	}

	public static void softAssertEquals(String expected, String actual) {
		try {
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(actual, expected);
		} catch (AssertionError e) {
		}
	}

	// This Method Used For Select By Index From Dropdown
	public static void selectByIndex(WebElement element, int i) {
		Select se = new Select(element);
		se.selectByIndex(i);
	}

	// This Method Used For Select By Value From Dropdown
	public static void selectByValue(WebElement element, String optionvalue) {
		Select se = new Select(element);
		se.selectByValue(optionvalue);
	}

	// This Method Used For Select By Text From Dropdown
	public static void selectByText(WebElement element, String optiontext) {
		Select se = new Select(element);
		se.selectByVisibleText(optiontext);
	}

	// This Method Is Used To Scroll Along The Page Upto the WebElement
	public static void scrollUptoWebElement(WebElement element) throws InterruptedException {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		} catch (Exception e) {

		}

	}

	public static void scrollDown200pixels() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 200);");

	}

	public static void scrollUp200pixels() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, -200);");

	}

	public static void scrollRightToElement(WebDriver driver, WebElement element) {
		// Execute JavaScript to scroll the page horizontally until the element is in
		// view
		String script = "arguments[0].scrollIntoView({ behavior: 'auto', block: 'nearest', inline: 'end' });";
		((JavascriptExecutor) driver).executeScript(script, element);
	}

}
