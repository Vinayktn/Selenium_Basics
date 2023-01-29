package CheckBoxes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkbox 
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		System.out.println("Checkbox selection: " + driver.findElement(By.xpath("//input[contains(@name,'eniorCitizenDiscount')]")).isSelected());
		driver.findElement(By.xpath("//input[contains(@name,'eniorCitizenDiscount')]")).click();
		System.out.println("Checkbox selection: " + driver.findElement(By.xpath("//input[contains(@name,'eniorCitizenDiscount')]")).isSelected());
		System.out.println("There are " +driver.findElements(By.xpath("//input[@type='checkbox']")).size() + " Checkboxes on the page");
	}
}
