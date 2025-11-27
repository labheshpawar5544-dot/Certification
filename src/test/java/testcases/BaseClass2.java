package testcases;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import pageobjects.CertificationPage;
import utilities.ReadConfig;

public class BaseClass2 {
    ReadConfig readconfig = new ReadConfig();

    public String baseURL = readconfig.getApplicationURL();
    public String username = readconfig.getUsername();   // labheshpawar5544
    public String accessKey = readconfig.getAccessKey(); // LT_wbe3XUAMtjLqKVuxsnMjwyRxbgCl4CQIPBaBamb53t2cXwR

    public static WebDriver driver;
    public static Logger log;
    public CertificationPage loginpage;

    
    @BeforeMethod
    @Parameters({"browser", "browserVersion", "platform"})
    public void setup(String browser, String browserVersion, String platform) {
        log = LogManager.getLogger(BaseClass2.class);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browser);
        capabilities.setCapability("browserVersion", browserVersion);
        capabilities.setCapability("platformName", platform);

        capabilities.setCapability("build", "Final Testing Result Cross browser ");
        capabilities.setCapability("name", "labhesh11");

        try {
            driver = new RemoteWebDriver(
                new URL("https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub"),
                capabilities
            );
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(baseURL);
        waitForPageLoad(driver, 30);

        loginpage = new CertificationPage(driver);
    }


    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Utility methods remain the same
    public static void clickOnWebElement(WebElement element, long waitTimeInseconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeInseconds));
            WebElement elements = wait.until(ExpectedConditions.elementToBeClickable(element));
            elements.click();
        } catch (Exception e) {
            // log error if needed
        }
    }
    
    public static void waitForPageLoad(WebDriver driver, int timeoutInSeconds) {
	    new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds)).until(
	        webDriver -> ((JavascriptExecutor) webDriver)
	            .executeScript("return document.readyState").equals("complete"));
	}



    public static void moveAndClick(WebElement element) {
        try {
            element.click();
        } catch (ElementClickInterceptedException e) {
            Actions actions = new Actions(driver);
            actions.moveToElement(element, -10, -10).click().build().perform();
        }
    }

    public static void elementToBeVisibleLocator(By locator, long waitTimeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeInSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void sendKeys(WebElement element, String text) {
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public String captureScreen(String tname, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String target = System.getProperty("user.dir") + "\\Screenshot\\" + tname + ".png";
        FileUtils.copyFile(source, new File(target));
        return target;
    }

    public static void softAssertEquals(String expected, String actual) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actual, expected);
    }

    public static void selectByIndex(WebElement element, int i) {
        new Select(element).selectByIndex(i);
    }

    public static void selectByValue(WebElement element, String optionvalue) {
        new Select(element).selectByValue(optionvalue);
    }

    public static void selectByText(WebElement element, String optiontext) {
        new Select(element).selectByVisibleText(optiontext);
    }

    public static void scrollUptoWebElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void scrollDown200pixels() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 200);");
    }

    public static void scrollUp200pixels() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -200);");
    }

    public static void scrollRightToElement(WebDriver driver, WebElement element) {
        String script = "arguments[0].scrollIntoView({ behavior: 'auto', block: 'nearest', inline: 'end' });";
        ((JavascriptExecutor) driver).executeScript(script, element);
    }
}
