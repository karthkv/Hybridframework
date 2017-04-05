package com.live.util;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.live.base.BaseClass;


public class AppDataProvider extends BaseClass{
	
	//static String sheetCreateAccount = appElements.getProperty("CreateUserData");
	//static String sheetLoginUser = appElements.getProperty("LoginUserData");
	
	
	@DataProvider(name="LoginData")
    public static Object[][] getLoginData() throws IOException{
	
		Object[][]values = ExcelProvider.getDataProviderData(xls, "LoginUser");
		return values;
	}
	
	@DataProvider(name="CreateAccount")
	public static Object[][] getCreateAccountData() throws IOException {
		
		Object[][] values = ExcelProvider.getDataProviderData(xls, "CreateAccount");
		return values;

	}


}
