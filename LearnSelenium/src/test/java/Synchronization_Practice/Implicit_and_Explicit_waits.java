package Synchronization_Practice;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class Implicit_and_Explicit_waits 
{
	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@id='start']/button")).click();

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(3))
				.ignoring(NoSuchElementException.class, ArithmeticException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>()
		{
			public WebElement apply(WebDriver driver) 
			{
				if(driver.findElement(By.xpath("//div[@id='finish']/h4")).isDisplayed())
				{
					return driver.findElement(By.xpath("//div[@id='finish']/h4"));
				}

				else
				{
					return null;
				}
			}
		});
		System.out.println(driver.findElement(By.xpath("//div[@id='finish']/h4")).getText());
	}
}