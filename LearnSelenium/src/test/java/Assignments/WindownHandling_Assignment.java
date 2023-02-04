package Assignments;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindownHandling_Assignment {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[contains(text(),'Multiple Windows')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();

		//fetching  the IDs of parent and child windows using getwindohandles method
		Set<String> windows = driver.getWindowHandles(); //ParentID , //ChildID

		//iterating through the multiple windows using iterator method
		Iterator<String> it = windows.iterator();
		String ParentID = it.next();  //Parentwindow
		String ChildID = it.next();   //child window

		//Swithcing to child window
		driver.switchTo().window(ChildID);
		System.out.println(driver.findElement(By.xpath("//h3[contains(text(),'New Window')]")).getText());

		//Swithcing to child window
		driver.switchTo().window(ParentID);
		System.out.println(driver.findElement(By.xpath("//h3[contains(text(),'Opening a new window')]")).getText());

		//closing the driver
		driver.quit();
	}
}
