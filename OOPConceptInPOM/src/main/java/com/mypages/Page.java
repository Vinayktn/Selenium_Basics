package com.mypages;

import java.lang.reflect.InvocationTargetException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page 
{
	WebDriver driver;
	WebDriverWait wait;

	public Page(WebDriver driver) 
	{
		this.driver=driver;
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(15));
	}


	//abstract methods
	public abstract String getPageTitle();

	public abstract String getPageHeader(By locator);

	//this method will return us the webelement - we will create 
	//the getelement at the run time and will pass the locator at runtime
	public abstract WebElement getElement(By locator);

	//explicit wait for element present or not
	public abstract void waitForElementPresent(By locator);

	//explicit wait for pagetitle present or not
	public abstract void waitForPageTitle(String Title);

	//concept of generics
	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass)
	{

		try {
			return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;  
		}
	}
}