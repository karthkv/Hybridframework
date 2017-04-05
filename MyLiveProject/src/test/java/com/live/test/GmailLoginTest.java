package com.live.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.live.base.BaseClass;
import com.live.pageobjects.GmailLoginPage;
import com.live.util.AppDataProvider;

public class GmailLoginTest extends BaseClass{

	@BeforeMethod
	public void init() {
		setBrowser();
		driver.get(appData.getProperty("GmailUrl"));
	}

	@AfterMethod
	public void tear_down()
	{
		quitBrowser();
	}
	
	
	@Test(dataProvider = "LoginData", dataProviderClass = AppDataProvider.class, priority = 1)
	public void gmailLoginTest(String username,String password)
	{
		objectpages();
		GmailLoginPage.login(username, password);
		
	}
}
