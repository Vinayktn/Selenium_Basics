package Streams_and_Lambda;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Pagination 
{
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//thead/tr/th[1]")).click();

		//capture all the web elements into 1 list
		List<WebElement> elementslist = driver.findElements(By.xpath("//tr/td[1]"));
		//elementslist.forEach(a->System.out.println(a.getText()));
		List<String> price;
		//scan the name column with get text of beans and get the price of the same
		price = elementslist.stream().filter(s->s.getText().contains("Beans")).map(s->getprice(s)).collect(Collectors.toList());
		price.forEach(b->System.out.println(b));

		do {			
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
			price = rows.stream().filter(s->s.getText().contains("Rice")).map(s->getprice(s)).collect(Collectors.toList());
			price.forEach(b->System.out.println(b));
			if(price.size()<1)
			{
				driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
			}
		}
		while(price.size()<1);
	}

	//extracting the price of item
	private static String getprice(WebElement s)
	{
		String priceofbeans = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceofbeans;
	}
}