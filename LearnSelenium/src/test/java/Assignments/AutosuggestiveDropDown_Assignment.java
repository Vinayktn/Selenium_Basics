package Assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AutosuggestiveDropDown_Assignment {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("ind");
		// Thread.sleep(2000);
		// driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys(Keys.DOWN);
		// driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys(Keys.DOWN);
		// System.out.println(driver.findElement(By.xpath("//input[@id='autocomplete']")).getAttribute("value"));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		List<WebElement> countries = driver.findElements(By.xpath("//li[@class='ui-menu-item']/div"));

		for (WebElement country : countries)
		{
			if (country.getText().equalsIgnoreCase("India"))
			{
				System.out.println(country.getText());
				country.click();
			}
		}
 	}
}