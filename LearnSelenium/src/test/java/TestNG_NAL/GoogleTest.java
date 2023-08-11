package TestNG_NAL;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest 
{

	WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.google.com/");
	}

	@Test(priority = 2, groups = "title")
	public void googletitletest()
	{
		System.out.println(driver.getTitle());
	}

	@Test(priority = 3, groups = "URL")
	public void googleURLtest()
	{
		System.out.println(driver.getCurrentUrl());
	}

	@Test(priority = 4, groups = "Test")
	public void Test1()
	{
		System.out.println("Test1");
	}

	@Test(priority = 5, groups = "Test")
	public void Test2()
	{
		System.out.println("Test2");
	}

	@Test(priority = 6, groups = "Test")
	public void Test3()
	{
		System.out.println("Test3");
	}

	@Test(priority = 1)
	public void gmailtest()
	{
		Boolean ele = driver.findElement(By.xpath("//a[contains(text(),'Gmail')]")).isDisplayed();
		Assert.assertTrue(ele);
	}

	@AfterMethod
	public void teardown() 
	{
		driver.quit();
	}
}