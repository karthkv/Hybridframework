package com.live.base;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.live.pageobjects.GmailLoginPage;
import com.live.util.ExcelProvider;

public class BaseClass  {
	
	public static Properties appData = null;	
	public static Properties appElements = null;	
	public static WebDriver driver =null;	
	public static WebDriverWait wait	 =null;
    public static FileInputStream fip = null;
    public static ExcelProvider xls = null;
	
    @BeforeSuite
	public void initalize() throws Exception  {
		
		fip = new FileInputStream(System.getProperty("user.dir")+ "//src//test//resources//appData.properties");
		appData = new Properties();
		appData.load(fip);
		
		fip = new FileInputStream(System.getProperty("user.dir")+ "//src//test//resources//appElements.properties");
		appElements = new Properties();
		appElements.load(fip);
		
		//load the excel file 
			xls = new ExcelProvider(System.getProperty("user.dir")+ "//src//test//resources//TestData.xlsx");
	 		
	} 
	
	public static void setBrowser(){

		if (appData.getProperty("browser").equalsIgnoreCase("Chrome")) {
			//System.setProperty("webdriver.chrome.driver", "F://Artificats//LatestDrivers//chromedriver.exe");
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "//drivers//chromedriver.exe");
			driver = new ChromeDriver();
		} else if (appData.getProperty("browser").equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "F://Artificats//LatestDrivers//IEDriver.exe");
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "//drivers//IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
	}
		
	public static void quitBrowser()
	{
		driver.quit();
	}
	
	   public  static WebElement getElement(String element){
		   try{
		
		   WebElement x = driver.findElement(By.xpath(element));
		   return x;
		   } catch (Exception e){
			  System.out.println("Element" + element +"not found." );
			  e.printStackTrace();
			  return null;
		   }
		
	   }
	   
	   public static WebElement waitElement(String element)
	   {
		
		   try{
			   WebElement x = driver.findElement(By.xpath(element));
			   wait=new WebDriverWait(driver, 60);
			   wait.until(ExpectedConditions.visibilityOf(x));
			   return x;
		   }
		   catch(Exception e)
		   {
			   System.out.println("Element Not Loaded" + element  +" in given time");
			   return null;
		   }		
		   		   
	   }
	   
	   @BeforeClass
	   public static void objectpages()
	   {
		  GmailLoginPage gm=new GmailLoginPage(driver);
		 
		  
	   }
	   
}
