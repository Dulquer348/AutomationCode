package com.Functionalities;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Locators.ExcelFileUtil;
import com.Locators.Locators;
import com.Locators.PropertyFileUtil;

public class AppTest2 extends Locators
{
	WebDriver driver;
	String excelpath="C:\\Users\\QV136ZX\\PIPPROJECT\\Practice\\TestInput\\TestData1.xlsx";
	String outputpath="C:\\Users\\QV136ZX\\PIPPROJECT\\Practice\\TestOutput\\Results.xlsx";
	
	@BeforeMethod	
	public void launchApp() throws Throwable 
	{
		 System.setProperty("webdriver.chrome.driver", PropertyFileUtil.getValueForKey("Chromepath"));
		 driver=new ChromeDriver();		
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		 driver.get(PropertyFileUtil.getValueForKey("Url"));
		 driver.findElement(login).click();
		 
	} 
	
@Test(priority = 0)
	public void registration() throws Throwable, IOException 
	{
		ExcelFileUtil xl=new ExcelFileUtil(excelpath);
		int rc=xl.rowCount("Sheet2");
		int cc=xl.colCount("Sheet2");
		for(int i=1; i<=rc; i++) 
		{
			String ACEmail=xl.getCellData("Sheet2", i, 0);
			String CusFirstName=xl.getCellData("Sheet2", i, 1);
			String CusLastName=xl.getCellData("Sheet2", i, 2);
			String PassCode=xl.getCellData("Sheet2", i, 3);
			String day=xl.getCellData("Sheet2", i, 4);
			String MontH=xl.getCellData("Sheet2", i, 5);
			String birtYear=xl.getCellData("Sheet2", i, 6);
			String CustAddress=xl.getCellData("Sheet2", i, 7);
			String CustCity=xl.getCellData("Sheet2", i, 8);
			String CustStae=xl.getCellData("Sheet2", i, 9);
			String pincode=xl.getCellData("Sheet2", i, 10);
			String CusCountry=xl.getCellData("Sheet2", i, 11);
			String PhnNo=xl.getCellData("Sheet2", i, 12);
			String AliasAdd=xl.getCellData("Sheet2", i, 13);
			
			driver.findElement(acEmail).clear();
			driver.findElement(acEmail).sendKeys(ACEmail);
			driver.findElement(createACbtn).click();
			Thread.sleep(3000);
			driver.findElement(genderSelect).click();
			driver.findElement(firstName).clear();
			driver.findElement(firstName).sendKeys(CusFirstName);
			driver.findElement(lastName).clear();
			driver.findElement(lastName).sendKeys(CusLastName);
			driver.findElement(passcode).clear();
			driver.findElement(passcode).sendKeys(PassCode);
			
			Select Day=new Select(driver.findElement(dAy));
			Day.selectByValue(day);
			 
			 Select Month=new Select(driver.findElement(month));
			 Month.selectByValue(MontH);
			 
			 Select Year=new Select(driver.findElement(year));
			 Year.selectByValue(birtYear);
			
			driver.findElement(cusAdrress).clear();
			driver.findElement(cusAdrress).sendKeys(CustAddress);
			driver.findElement(cusCity).clear();
			driver.findElement(cusCity).sendKeys(CustCity);
			Select state=new Select(driver.findElement(cusState));
			state.selectByValue(CustStae);
			 
			driver.findElement(zipCode).clear();
			driver.findElement(zipCode).sendKeys(pincode);

			Select country=new Select(driver.findElement(cusCountry));
			country.selectByValue(CusCountry);       
			 
			driver.findElement(mobileNo).clear();
			driver.findElement(mobileNo).sendKeys(PhnNo);
			driver.findElement(aliasAdd).clear();
			driver.findElement(aliasAdd).sendKeys(AliasAdd);
			Thread.sleep(5000);
			driver.findElement(register).click();
			
			 String registrationValidation=driver.findElement(signOut).getText();
			 if(registrationValidation.contains("Sign out"))
			 {
				 driver.findElement(signOut).click();
				 System.out.println("Registration Validation is successful for Iteration = "+i);
				 xl.setCellData("Sheet2", i, 14, "Pass", outputpath);
			 }else
			 {
				 xl.setCellData("Sheet2", i, 14, "Fail", outputpath);
				 System.out.println("Registration Validation is not successful for Iteration = "+i);
	 
			 }
		}
			}

     @Test(priority = 1)
	public void login() throws Throwable, IOException 
	{
		ExcelFileUtil xl=new ExcelFileUtil(excelpath);
		int rc=xl.rowCount("Sheet1");
		int cc=xl.colCount("Sheet1");
		for(int i=1; i<=rc; i++) 
		{
			String EmailID=xl.getCellData("Sheet1", i, 0);
			String Password=xl.getCellData("Sheet1", i, 1);
			
			 driver.findElement(userName).clear();
			 driver.findElement(userName).sendKeys(EmailID);
			 driver.findElement(password).clear();
			 driver.findElement(password).sendKeys(Password);
			 driver.findElement(sighIn).click(); 
			 Thread.sleep(5000);
			 
			 String loginValidation=driver.findElement(signOut).getText();
			 if(loginValidation.contains("Sign out"))
			 {
				 driver.findElement(signOut).click();
				 System.out.println("Login Validation is successful for Iteration = "+i);
				 xl.setCellData("Sheet1", i, 2, "Pass", outputpath);
			 }else
			 {
				 xl.setCellData("Sheet1", i, 2, "Fail", outputpath);

				 System.out.println("Login Validation is not successful for Iteration = "+i);

			 }
			 
			
	}
	
	}
	
	@AfterMethod
	public void closeBrowser() 
	{
		driver.close();
		
	}

}
