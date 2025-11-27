package testcases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.RerunFailedTest;

public class CertificationTest extends BaseClass2{
	@Test(description = "Test Scenario 1:")
	public void TestScenario_01() throws InterruptedException, IOException {
		loginpage.login();
		loginpage.clickSimpleDemoForm();
		Assert.assertTrue(driver.getCurrentUrl().contains("simple-form-demo"));
		loginpage.setword();
		loginpage.clickGetCheckedValue();
		Assert.assertEquals(loginpage.yourMessage(), "Welcome to LambdaTest");
	}
	
	@Test(description = "Test Scenario 2:")
	public void TestScenario_02() throws InterruptedException, IOException {
		loginpage.login();
		loginpage.clickDragAndDrop();
		loginpage.sliderValue();
		Assert.assertEquals(loginpage.sliderValue1(), "15");
		loginpage.dragSliderToTarget(95);
		System.out.println("Test successfully structured to drag slider and verify value.");
        Assert.assertEquals(loginpage.getCurrentSliderValue(), "95");
		
	}
	
	@Test( description = "Test Scenario 3:")
	public void TestScenario_03() throws InterruptedException, IOException {
		loginpage.login();
		loginpage.clickInputFormSubmit();
		loginpage.clickSubmitButton();
		String validationMessage = loginpage.getValidationMessage();
        Assert.assertEquals(validationMessage, "Please fill out this field.");
		loginpage.setName();
		loginpage.setEmail();
		loginpage.setPassword();
		loginpage.setCompany();
		loginpage.setWebsite();
		loginpage.selectCountry();
		loginpage.setCity();
		loginpage.setAddress1();
		loginpage.setAddress2();
		loginpage.setState();
		loginpage.setZipCode();
		loginpage.clicksubmit();
		 Assert.assertEquals(loginpage.thankMessage(), "Thanks for contacting us, we will get back to you shortly.");
		
	}
		
		
	}