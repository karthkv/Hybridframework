package com.live.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.live.base.BaseClass;


public class GmailLoginPage extends BaseClass{
	
	WebDriver driver;
	@FindBy(id="Email") public static WebElement gmailUserName;
	@FindBy(id="Passwd") public static WebElement gmailPassword;
	@FindBy(id="signIn")public static WebElement gmailLoginbutton;
	public GmailLoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	public void SetUsername(String strUsername)
	{
		gmailUserName.sendKeys(strUsername);
	}
	
	public void SetUserPass(String strUserPass)
	{
		gmailPassword.sendKeys(strUserPass);
	}
	
	public void ClickSignIn()
	{
		gmailLoginbutton.click();
	}
	
	public static void login(String username, String password)
	{
		
		gmailUserName.sendKeys(username);
		gmailPassword.sendKeys(password);
		gmailLoginbutton.click();
	}
}
