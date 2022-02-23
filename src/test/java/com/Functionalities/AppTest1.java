package com.Functionalities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Locators.Locators;
import com.Locators.PropertyFileUtil;

public class AppTest1 extends Locators
{
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
	
	@Test
	public void appLogin() throws Throwable 
	{
		 driver.findElement(login).click();
		 driver.findElement(userName).sendKeys(PropertyFileUtil.getValueForKey("Email"));
		 driver.findElement(password).sendKeys(PropertyFileUtil.getValueForKey("Password"));
		 driver.findElement(sighIn).click(); 
		 
		 String loginValidation=driver.findElement(signOut).getText();
		 //System.out.println(loginValidation);
		 if(loginValidation.contains("Sign out"))
		 {
			 System.out.println("Login Validation is successful");
		 }else
		 {
			 System.out.println("Login Validation is not successful");

		 }
		 
		//Search for the product
			driver.findElement(productSearch).sendKeys(PropertyFileUtil.getValueForKey("productName"));
			driver.findElement(searchButton).click();
			
			String searchValidation=driver.findElement(searchvalidation).getText();
			//System.out.println(searchValidation);
			if(searchValidation.contains(PropertyFileUtil.getValueForKey("productName")))
			{
				System.out.println("Search Product validation is successful");
			}else
			{
				System.out.println("Search Product validation is not successful");

			}
			
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
			
			Thread.sleep(3000);
		    Actions act2 = new Actions(driver);
			act2.moveToElement(driver.findElement(deleteItem)).click();
			act2.build().perform();
			Thread.sleep(3000);
			String Empty = driver.findElement(empty1).getText();
			//System.out.println(Empty);
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
