package TestNG_NAL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DependsonMethod 
{
	public WebDriver driver;

	@Test(priority = 1)
	public void setup() 
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@Test(dependsOnMethods = "setup")
	public void login() 
	{
		System.out.println("Logged in");
	}

	@Test(dependsOnMethods = "login")
	public void gettitle() 
	{
		System.out.println(driver.getTitle());
	}

	@Test(dependsOnMethods = "login")
	public void getURL() 
	{
		System.out.println(driver.getCurrentUrl());
	}
}