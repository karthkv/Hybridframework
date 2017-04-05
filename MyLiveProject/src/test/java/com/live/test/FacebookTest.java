package com.live.test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.live.base.BaseClass;
import com.live.util.AppDataProvider;

public class FacebookTest extends BaseClass {

	@BeforeMethod
	public void init() {
		setBrowser();
		driver.get(appData.getProperty("appURL"));
	}

	@Test(dataProvider = "LoginData", dataProviderClass = AppDataProvider.class, priority = 1)
	public void loginUser(String username, String pwd) throws InterruptedException {

		Reporter.log("Entered into the LoginMethod");
		WebElement email = getElement(appElements.getProperty("login.email"));
		email.sendKeys(username);
		Thread.sleep(2000);
		WebElement password = getElement(appElements.getProperty("login.password"));
		password.sendKeys(pwd);
		Reporter.log("Completed LoginMethod");
		
	}

	@Test(dataProvider = "CreateAccount", dataProviderClass = AppDataProvider.class, priority = 2)
	public void createAccount(String fn, String ln) throws InterruptedException {

		try {
			Reporter.log("Entered Create Account method");
			WebElement fname = getElement(appElements.getProperty("create.fname"));
			WebElement lname = getElement(appElements.getProperty("create.lname"));
			fname.sendKeys(fn);
			Thread.sleep(1000);
			lname.sendKeys(ln);
			Thread.sleep(1000); // added thread to demo on the values entered
			String expectedBtn = "Create an account";
			String actualBtn = getElement(appElements.getProperty("create.button")).getText();
			Assert.assertEquals(expectedBtn, actualBtn);
			Reporter.log("Copmleted createAccount method");
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
