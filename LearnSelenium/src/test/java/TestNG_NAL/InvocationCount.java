package TestNG_NAL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.internal.thread.ThreadTimeoutException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InvocationCount 
{
	public WebDriver driver;

	@Test
	public void setup() 
	{
		WebDriverManager.chromedriver().setup();
		//driver = new ChromeDriver();
	}

	@Test(invocationTimeOut  = 3000, expectedExceptions = ThreadTimeoutException.class)
	public void countinginvocation()
	{
		int i=1;
		while(i==1)
		{
			System.out.println(i);
		}
	}
}
