package TestNG_NAL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

 
public class ParametersTest 
{
	WebDriver driver;
	@Test
	@Parameters({"env", "browser", "URL", "emailid"})
	public void yaohoologintest(String env, String browser, String URL, String emailid)
	{
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
		    driver = new FirefoxDriver();
		}

		driver.get(URL);
		driver.findElement(By.id("login-username")).clear();
		driver.findElement(By.id("login-username")).sendKeys("test@yahoo.com");
		driver.findElement(By.id("login-signin")).click();
	}
}