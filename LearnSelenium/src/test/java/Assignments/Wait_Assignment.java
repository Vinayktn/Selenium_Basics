package Assignments;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait_Assignment {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		//Handling text boxes
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");

		//Handling RadioButtons
		driver.findElement(By.xpath("//span[contains(text(),'User')]")).click();

		//Explicit wait concept
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='okayBtn']")));
		driver.findElement(By.xpath("//button[@id='okayBtn']")).click();

		//Handling Static DropDowns
		WebElement staticdropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select dropdown = new Select(staticdropdown);
		dropdown.selectByIndex(2);

		//Handling Checkboxes
		driver.findElement(By.xpath("//input[@id='terms']")).click();

		//Handling buttons
		driver.findElement(By.xpath("//input[@id='signInBtn']")).click();

		//Explicit wait concept
		WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(5));
		w1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[@class='card-title']")));
		driver.findElement(By.xpath("//h4[@class='card-title']"));

		//putting all the items needed into an array
		String[] itemsneeded = {"iphone X", "Samsung Note 8", "Nokia Edge", "Blackberry"};
		List<WebElement> products = driver.findElements(By.xpath("//h4[@class='card-title']"));
		int j=0;
		for(int i=0; i<products.size(); i++)
		{
			String name = products.get(i).getText();
			//converting array into a list to access the contains method
			List itemsneededlist = Arrays.asList(itemsneeded);

			if(itemsneededlist.contains(name))
			{
				driver.findElements(By.xpath("//div[@class='card-footer']/button")).get(i).click();
			}
			else
			{
				return;
			}
			if(j==itemsneeded.length)
			{
				break;
			}
		}
		driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
		driver.quit();
	}
}