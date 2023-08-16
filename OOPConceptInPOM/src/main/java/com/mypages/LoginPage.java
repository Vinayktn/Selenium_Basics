package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	//url: https://app.hubspot.com/login/
	//page locators: with the help of By locators
	private By emailID = By.id("username");
	private By password = By.id("password");
	private By loginButton = By.id("loginButton");
	private By header = By.id("//i18n-string[contains(text(),\"Don't have an account?\")]");

	//getters
	/**
	 * @return the emailID
	 */
	public WebElement getEmailID() {
		return getElement(emailID);
	}

	/**
	 * @return the password
	 */
	public WebElement getPassword() {
		return getElement(password);
	}

	/**
	 * @return the loginButton
	 */
	public WebElement getLoginButton() {
		return getElement(loginButton);
	}

	/**
	 * @return the header
	 */
	public WebElement getHeader() {
		return getElement(header);
	}

	public String getLoginPageTitle()
	{
		return getPageTitle();
	}

	public String getLoginPageHeader()
	{
		return getPageHeader(header);
	}

	public HomePage doLogin(String username, String pwd)
	{
		getEmailID().sendKeys(username);
		getPassword().sendKeys(pwd);
		getLoginButton().click();

		return getInstance(HomePage.class);
	}

	public void doLogin( )
	{
		getEmailID().sendKeys( );
		getPassword().sendKeys( );
		getLoginButton().click();

	}

	public void doLogin(String userCred)
	{
		if(userCred.contains("username"))
		{
			getEmailID().sendKeys(userCred.split(":")[1].trim());
		}
		else if(userCred.contains("password"))
		{
			getEmailID().sendKeys(userCred.split(":")[1].trim());
		}
		getLoginButton().click();
		
	}





}
