package com.MyTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.mypages.BasePage;
import com.mypages.Page;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest 
{
	WebDriver driver;
	public Page page; //creating a class variable

	@BeforeMethod
	@Parameters(value= {"browser"})
	public void setUpTest(String browser) throws InterruptedException
	{

		if(browser.equals("chrome"))
		{
			ChromeOptions co = new ChromeOptions();
			co.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(co);
			driver.manage().window().maximize();
			Thread.sleep(8000);
		}
		else if(browser.equals("ff"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("no browser is defined in xml file....");
		}
		driver.get("https://app.hubspot.com/login/");
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		page = new BasePage(driver);
	}

	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}