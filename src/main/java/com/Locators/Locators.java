package com.Locators;

import org.openqa.selenium.By;

public class Locators {
	

public By login= By.className("login");
public By userName= By.id("email");
public By password=By.name("passwd");
public By sighIn= By.id("SubmitLogin");
public By signOut=By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a");



public By productSearch=By.xpath("//*[@id=\"search_query_top\"]");
public By searchButton=By.tagName("button");
public By searchvalidation=By.xpath("//*[@id=\"center_column\"]/h1/span[1]");

public By product=By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img");
public By addToCart=By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[1]/span");	
public By checkOut=By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span");
public By expProduct=By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a");
public By actProduct=By.xpath("//*[@id='cart_summary']/tbody/tr/td[2]/p/a");
	
	
public By acEmail=By.id("email_create");
public By createACbtn=By.id("SubmitCreate");
public By genderSelect=By.xpath("//input[@id='id_gender1']");
public By firstName=By.id("customer_firstname");
public By lastName=By.id("customer_lastname");
public By passcode=By.id("passwd");
public By dAy=By.id("days");
public By month=By.id("months");
public By year=By.id("years");
public By cusAdrress=By.id("address1");
public By cusCity=By.name("city");
public By cusState=By.name("id_state");
public By zipCode=By.cssSelector("input#postcode");
public By cusCountry=By.name("id_country");
public By mobileNo=By.id("phone_mobile");
public By aliasAdd=By.xpath("//input[@id='alias']");
public By register=By.name("submitAccount");
public By registervalidation=By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a");


public By deleteItem=By.xpath("//*[@id=\"5_19_0_639177\"]/i");
public By empty=By.cssSelector("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a/span[5]");

public By empty1=By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a");









}
