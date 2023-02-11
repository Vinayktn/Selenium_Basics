package Streams_and_Lambda;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Example_2 
{
	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		driver.findElement(By.xpath("//thead/tr/th[1]")).click();

		//capture all the web elements into 1 list
		List<WebElement> elementslist = driver.findElements(By.xpath("//tr/td[1]"));

		//capture the text of all the web elements into 1 list
		List<String> originallist =	elementslist.stream().map(s->s.getText()).collect(Collectors.toList());

		//sort the original list
		List<String> sortedlist = originallist.stream().sorted().collect(Collectors.toList());

		//compare original list and sorted list
		Assert.assertEquals(originallist, sortedlist);
		
		driver.quit();
	}
}