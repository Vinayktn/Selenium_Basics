package Handling_Windows;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handling_MultipleWindows 
{
	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@class='blinkingText']")).click();
		Set<String> windows = driver.getWindowHandles();  //parentwindowID   and //childwindowID
		Iterator<String> it = windows.iterator();
		String ParentID = it.next();
		String ChildID = it.next();
		driver.switchTo().window(ChildID);
		String emailID = driver.findElement(By.xpath("//p[@class='im-para red']")).getText().split("at")[1].trim().split(" ")[0].trim();
		driver.switchTo().window(ParentID);
		driver.findElement(By.id("username")).sendKeys(emailID);
		

  	}
}
