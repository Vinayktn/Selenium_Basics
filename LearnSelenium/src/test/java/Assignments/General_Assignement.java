package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class General_Assignement 
{
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();

		//Handling checkbox
		driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click();

		//grabbing the text of the selected checkbox and storing it in a variable
		String optiontext = driver.findElement(By.xpath("//label[@for='bmw']")).getText();

		//Handling static dropdown
		WebElement staticdropdown = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
		Select dropdown = new Select(staticdropdown);
		dropdown.selectByVisibleText(optiontext);

		//Handling textbox and sending the text dynamically
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(optiontext);
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();

		//Switching to alert and validating the entered text there
		String alerttext = driver.switchTo().alert().getText();

		if(alerttext.contains(optiontext))
		{
			Assert.assertTrue(true);
			System.out.println("Text validation successfull");
		}
		else
		{
			Assert.assertTrue(false);
			System.out.println("Text validation un-successfull");
		}
		driver.switchTo().alert().accept();
		driver.quit();
	}
}