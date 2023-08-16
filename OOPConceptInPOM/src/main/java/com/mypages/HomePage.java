package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	private By header = By.className("private-page__title");

	public WebElement getHeader() {
		return getElement(header);
	}

	public String getHomenPageTitle()
	{
		return getPageTitle();
	}

	public String getHomePageHeader()
	{
		return getPageHeader(header);
	}
}
