package pageobjects;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import testcases.BaseClass;

public class CertificationPage extends BaseClass {
	WebDriver ldriver;

	public CertificationPage(WebDriver rdriver) {
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//ul[@class='list-disc pl-10 pb-30 grid grid-cols-4 w-full gap-10 mt-30 smtablet:grid-cols-1']/li/a[contains(text(), 'Simple Form Demo')]")
	@CacheLookup
	private WebElement simpledemoform;
	
	@FindBy(how = How.XPATH, using = "//input[@id='user-message']")
	@CacheLookup
	private WebElement usermessage;
	
	@FindBy(how = How.XPATH, using = "//button[@id='showInput']")
	@CacheLookup
	private WebElement getchcekedvalue;
	
	@FindBy(how = How.XPATH, using = "//p[@id='message']")
	@CacheLookup
	private WebElement yourmessage;
	
	@FindBy(how = How.XPATH, using = "//ul[@class='list-disc pl-10 pb-30 grid grid-cols-4 w-full gap-10 mt-30 smtablet:grid-cols-1']/li/a[contains(text(), 'Drag & Drop Sliders')]")
	@CacheLookup
	private WebElement draganddropslider;
	
	@FindBy(how = How.XPATH, using = "//div[@class='sp__range sp__range-success']/output")
	@CacheLookup
	private WebElement slidervalue;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"slider3\"]/div/input")
	@CacheLookup
	private WebElement sliderbar;
	
	@FindBy(how = How.XPATH, using = "//ul[@class='list-disc pl-10 pb-30 grid grid-cols-4 w-full gap-10 mt-30 smtablet:grid-cols-1']/li/a[contains(text(), 'Input Form Submit')]")
	@CacheLookup
	private WebElement inputformsubmit;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"seleniumform\"]/div/button[contains(text(), 'Submit')]")
	@CacheLookup
	private WebElement submitbutton;
	
	@FindBy(how = How.XPATH, using = "//div/input[@id='name']")
	@CacheLookup
	private WebElement name;
	
	@FindBy(how = How.XPATH, using = "//div/input[@placeholder='Email']")
	@CacheLookup
	private WebElement email;
	
	@FindBy(how = How.XPATH, using = "//div/input[@placeholder='Password']")
	@CacheLookup
	private WebElement pasword;
	
	@FindBy(how = How.XPATH, using = "//div/input[@placeholder='Company']")
	@CacheLookup
	private WebElement company;
	
	@FindBy(how = How.XPATH, using = "//div/input[@placeholder='Website']")
	@CacheLookup
	private WebElement website;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"seleniumform\"]/div[3]/div[1]/select")
	@CacheLookup
	private WebElement country;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"seleniumform\"]/div[3]/div[1]/select")
	@CacheLookup
	private WebElement countryoption;
	
	@FindBy(how = How.XPATH, using = "//div/input[@placeholder='City']")
	@CacheLookup
	private WebElement city;
	
	@FindBy(how = How.XPATH, using = "//div/input[@placeholder='Address 1']")
	@CacheLookup
	private WebElement addres1;
	
	@FindBy(how = How.XPATH, using = "//div/input[@placeholder='Address 2']")
	@CacheLookup
	private WebElement addres2;
	
	@FindBy(how = How.XPATH, using = "//div/input[@placeholder='State']")
	@CacheLookup
	private WebElement state;
	
	@FindBy(how = How.XPATH, using = "//div/input[@placeholder='Zip code']")
	@CacheLookup
	private WebElement zipcode;
	
	@FindBy(how = How.XPATH, using = "//div/p[contains(text(), 'Thanks for contacting us, we will get back to you shortly.')]")
	@CacheLookup
	private WebElement thanks;
	
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"seleniumform\"]//div//button")
	@CacheLookup
	private WebElement submit;
	
	
	
	public void setName() {
		String a = "labhesh pawar";
		name.sendKeys(a);
	}
	
	public void setEmail() {
		String a = "plab12344@gamil.com";
		email.sendKeys(a);
	}
	
	public void setPassword() {
		String a = "123344556";
		pasword.sendKeys(a);
	}
	
	public void setCompany() {
		String a = "hexa";
		company.sendKeys(a);
	}
	
	public void setWebsite() {
		String a = "https://www.lambdatest.com/selenium-playground/input-form-demo";
		website.sendKeys(a);
	}
	
	public void setCountry() {
		String a = "india";
		country.sendKeys(a);
	}
	
	public void setCity() {
		String a = "pune";
		city.sendKeys(a);
	}
	
	public void setAddress1() {
		String a = "pune pjhase1";
		addres1.sendKeys(a);
	}
	
	public void setAddress2() {
		String a = "mumbai";
		addres2.sendKeys(a);
	}
	
	public void setState() {
		String a = "maharahstra";
		state.sendKeys(a);
	}
	
	public void setZipCode() {
		String a = "422103";
		zipcode.sendKeys(a);
	}
	
	public String thankMessage() {
		return thanks.getText();
		
	}
	
	

	// This method is used to set password in password field
		public void setword() {
			String a = "Welcome to LambdaTest";
			usermessage.sendKeys(a);
		}


	public void clickSimpleDemoForm() {
		clickOnWebElement(simpledemoform, 10);
		}
	
	public void clicksubmit() {
		clickOnWebElement(submit, 10);
		}
	
	public void clickDragAndDrop() {
		clickOnWebElement(draganddropslider, 10);
		}
	
	public void clickGetCheckedValue() {
		clickOnWebElement(getchcekedvalue, 10);
		}

	public String yourMessage() {
		return yourmessage.getText();
		}
	
	public String sliderValue() {
		return slidervalue.getText();
		
		}
	public void dragSliderToTarget(int targetValue) {
		 System.out.println("Attempting to move slider from 15 to " + targetValue);
	        
	        // 1. Locate the slider handle element
	        WebElement handle = sliderbar;
	        
	        // 2. Initialize the Actions class
	        Actions actions = new Actions(driver);
	        
	        // 3. Determine the X-offset.
	        int xOffset = 215; 

	        // 4. Perform the drag-and-drop action
	        actions.dragAndDropBy(handle, xOffset, 0)
	               .perform();
	        
	        System.out.println("Slider dragged by " + xOffset + " pixels.");
	    }

   
    public String getCurrentSliderValue() {
        try {
            // Locating the output element to read the visible value
            return slidervalue.getText().trim();
        } catch (Exception e) {
            System.err.println("Could not read slider value from output element: " + e.getMessage());
            return "";
        }
    }
    
    // Assuming this utility method is needed by the test for initial assertion
    public String sliderValue1() {
        return getCurrentSliderValue();
    }


// This method is used to set valid username ,valid password and click on submitt button (Login)
	public void login() throws InterruptedException {
		
	}
	
	public void clickInputFormSubmit() {
		clickOnWebElement(inputformsubmit, 10);
		}

	public void clickSubmitButton() {
			clickOnWebElement(submitbutton, 10);
			}
	
	public String getAndAcceptAlert() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            System.out.println("Alert detected with text: " + alertText);
            alert.accept(); // Clicks OK/Accept
            return alertText;
        } catch (NoAlertPresentException e) {
            return null; // Return null if no alert is found

        }
    }
	
	public void selectCountry() throws InterruptedException {
	BaseClass.clickOnWebElement(country, 10);
		BaseClass.selectByIndex(countryoption, 1);
	
	}


}


