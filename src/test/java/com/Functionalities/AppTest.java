package com.Functionalities;
import java.io.IOException;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Locators.Locators;
import com.Locators.PropertyFileUtil;
public class AppTest extends Locators
{
	String excelpath="C:\\Users\\QV136ZX\\PIPPROJECT\\Practice\\TestInput\\TestData.xlsx";
	WebDriver driver;
	
	@BeforeMethod	
	public void launchApp() throws Throwable 
	{
		 System.setProperty("webdriver.chrome.driver", PropertyFileUtil.getValueForKey("Chromepath"));
		 driver=new ChromeDriver();		
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		 driver.get(PropertyFileUtil.getValueForKey("Url"));	
		 
	}
	
	
	@Test(priority = 0)
	public void registration() throws IOException, Throwable
	{

		 driver.findElement(login).click();
		 driver.findElement(acEmail).sendKeys(PropertyFileUtil.getValueForKey("ACEmail"));
		 driver.findElement(createACbtn).click();
		 Thread.sleep(5000);
		 driver.findElement(genderSelect).click();
		 driver.findElement(firstName).sendKeys(PropertyFileUtil.getValueForKey("CusFirstName"));
		 driver.findElement(lastName).sendKeys(PropertyFileUtil.getValueForKey("CusLastName"));
		 driver.findElement(passcode).sendKeys(PropertyFileUtil.getValueForKey("PassCode"));
		 
		 Select Day=new Select(driver.findElement(dAy));
		 Day.selectByValue(PropertyFileUtil.getValueForKey("day"));
		 
		 Select Month=new Select(driver.findElement(month));
		 Month.selectByValue(PropertyFileUtil.getValueForKey("MontH"));
		 
		 Select Year=new Select(driver.findElement(year));
		 Year.selectByValue(PropertyFileUtil.getValueForKey("birtYear"));
		 
		 driver.findElement(cusAdrress).sendKeys(PropertyFileUtil.getValueForKey("CustAddress"));
		 driver.findElement(cusCity).sendKeys(PropertyFileUtil.getValueForKey("CustCity"));  
		 
		 Select state=new Select(driver.findElement(cusState));
		 state.selectByValue(PropertyFileUtil.getValueForKey("CustStae"));
		 
		 driver.findElement(zipCode).sendKeys(PropertyFileUtil.getValueForKey("pincode"));    
		 
		 Select country=new Select(driver.findElement(cusCountry));
		 country.selectByValue(PropertyFileUtil.getValueForKey("CusCountry"));       
		 
		 driver.findElement(mobileNo).sendKeys(PropertyFileUtil.getValueForKey("PhnNo"));
		
		 driver.findElement(aliasAdd).sendKeys(PropertyFileUtil.getValueForKey("AliasAdd"));
		 driver.findElement(register).click();
		 
		 String registerValidation=driver.findElement(registervalidation).getText();
		 
		 if(registerValidation.contains(PropertyFileUtil.getValueForKey("CusFirstName")+" "+ PropertyFileUtil.getValueForKey("CusLastName")))
		 {
			 System.out.println("New User Registration is successfull");
			 
		 }else
		 {
			 System.out.println("New User Registration is not successfull");
		 }
		
	}	
	
	@Test(priority = 1)
	public void appLogin() throws Throwable 
	{
		 driver.findElement(login).click();
		 driver.findElement(userName).sendKeys(PropertyFileUtil.getValueForKey("Email"));
		 driver.findElement(password).sendKeys(PropertyFileUtil.getValueForKey("Password"));
		 driver.findElement(sighIn).click(); 
		 
		 String loginValidation=driver.findElement(signOut).getText();
		 System.out.println(loginValidation);
		 if(loginValidation.contains("Sign out"))
		 {
			 System.out.println("Login Validation is successfull");
		 }else
		 {
			 System.out.println("Login Validation is not successfull");

		 }
		
	}
	
	@Test(priority = 2)
	public void searchProduct() throws Throwable, Throwable
	{	
		 driver.findElement(login).click();
		 driver.findElement(userName).sendKeys(PropertyFileUtil.getValueForKey("Email"));
		 driver.findElement(password).sendKeys(PropertyFileUtil.getValueForKey("Password"));
		 driver.findElement(sighIn).click(); 
	
	//Search for the product
	driver.findElement(productSearch).sendKeys(PropertyFileUtil.getValueForKey("productName"));
	driver.findElement(searchButton).click();
	
	String searchValidation=driver.findElement(searchvalidation).getText();
	System.out.println(searchValidation);
	if(searchValidation.contains(PropertyFileUtil.getValueForKey("productName")))
	{
		System.out.println("Search Product validation is successful");
	}else
	{
		System.out.println("Search Product validation is not successful");

	}
	}
	
	@Test(priority = 3)
	public void addToCart() throws Throwable, Throwable
	{
		
		 driver.findElement(login).click();
		 driver.findElement(userName).sendKeys(PropertyFileUtil.getValueForKey("Email"));
		 driver.findElement(password).sendKeys(PropertyFileUtil.getValueForKey("Password"));
		 driver.findElement(sighIn).click(); 
	
	//Search for the product
	driver.findElement(productSearch).sendKeys(PropertyFileUtil.getValueForKey("productName"));
	driver.findElement(searchButton).click();
	
	String ExpectedProduct=driver.findElement(expProduct).getAttribute("title");
	System.out.println("ExpectedProduct = " +ExpectedProduct);
			
    //Add product to cart
	Actions act = new Actions(driver);
	act.moveToElement(driver.findElement(product));
	act.click(driver.findElement(addToCart));
	act.build().perform();
			
    Thread.sleep(5000);
    Actions act1 = new Actions(driver);
	act1.moveToElement(driver.findElement(checkOut)).click();
	//act1.click(driver.findElement(checkOut));
	act1.build().perform();
	
	String ActualProduct=driver.findElement(actProduct).getText();
	System.out.println("Actual Product = " +ActualProduct);
	Assert.assertEquals(ActualProduct, ExpectedProduct);
	
	if(ActualProduct.contains(ExpectedProduct))
		{
			System.out.println("The product in cart is same as selected");
		}else
		{
			System.out.println("The product in cart is not same as selected");
		}
	}
	

	@Test(priority = 4)
	public void deleteProduct() throws Throwable, Throwable
	{
		
		 driver.findElement(login).click();
		 driver.findElement(userName).sendKeys(PropertyFileUtil.getValueForKey("Email"));
		 driver.findElement(password).sendKeys(PropertyFileUtil.getValueForKey("Password"));
		 driver.findElement(sighIn).click(); 
	
	//Search for the product
	driver.findElement(productSearch).sendKeys(PropertyFileUtil.getValueForKey("productName"));
	driver.findElement(searchButton).click();
	
	Actions act = new Actions(driver);
	act.moveToElement(driver.findElement(product));
	act.click(driver.findElement(addToCart));
	act.build().perform();
			
    Thread.sleep(5000);
    Actions act1 = new Actions(driver);
	act1.moveToElement(driver.findElement(checkOut)).click();
	//act1.click(driver.findElement(checkOut));
	act1.build().perform();
	
    Thread.sleep(3000);
    Actions act2 = new Actions(driver);
	act2.moveToElement(driver.findElement(deleteItem)).click();
	act2.build().perform();
	 Thread.sleep(3000);
	String Empty = driver.findElement(empty1).getText();
	System.out.println(Empty);
	if(Empty.contains("Cart (empty)"))
	{
		System.out.println("Cart is empty");
	}else
	{
		System.out.println("Cart is not empty");
		
	}
	
	}
	


	@AfterMethod
	public void closeBrowser() 
	{
		driver.close();
		
	}

		
	
}



