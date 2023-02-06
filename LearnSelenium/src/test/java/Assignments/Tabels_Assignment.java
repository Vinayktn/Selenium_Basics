package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tabels_Assignment 
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(2000);

		//finding number of rows in the tabel
		int rows = driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr")).size();
		System.out.println("There are " +rows+ " rows in this tabel");

		//finding number of columns in the tabel
		int columns = driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr/th")).size();
		System.out.println("There are " +columns+ " columns in this tabel");

		//to print the content in the second row
		String content = driver.findElement(By.xpath("//table[@class='table-display']/tbody/tr[3]")).getText();
		System.out.println("The content inside the 2nd row is as folows: " +content);

	}
}
