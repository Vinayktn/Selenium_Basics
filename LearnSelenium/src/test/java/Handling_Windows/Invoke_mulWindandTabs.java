package Handling_Windows;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Invoke_mulWindandTabs 
{
	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.WINDOW);
		Set<String> handels = driver.getWindowHandles();
		Iterator<String> it = handels.iterator();
		String Parentwindow = it.next();
		String Childwindow = it.next();
		driver.switchTo().window(Childwindow);
		driver.get("https://rahulshettyacademy.com");
		
		String firstcourse = driver.findElements(By.xpath("//a[contains(@href, 'https://courses.rahulshettyacademy.com/p')]")).get(1).getText();
		System.out.println(firstcourse);
		driver.switchTo().window(Parentwindow);
		driver.quit();
	}
}