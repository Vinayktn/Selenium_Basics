package Handling_Alerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Alerts {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Vinay");
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();

		String Alerttext = driver.switchTo().alert().getText();
		Assert.assertEquals(Alerttext, "Hello Vinay, share this practice page and share your knowledge");
		driver.switchTo().alert().accept();
		
		driver.findElement(By.xpath("//input[@id='confirmbtn']")).click();
		String confirmtext = driver.switchTo().alert().getText();
		Assert.assertEquals(confirmtext, "Hello , Are you sure you want to confirm?");
		driver.switchTo().alert().dismiss();
	}
}