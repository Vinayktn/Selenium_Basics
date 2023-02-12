package Latest_Features;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Relative_Locators
{
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/"); 
		WebElement nameeditbox = driver.findElement(By.xpath("//div[@class='container'] //input[@name='name']"));

		//using above relative locator
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameeditbox)).getText());


		//using below relative locator
		WebElement dob = driver.findElement(By.xpath("//label[@for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(dob)).click();
		
		//toleftof relative locator
		WebElement icecreamlabel = driver.findElement(By.xpath("//label[@for='exampleCheck1']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(icecreamlabel)).click();

		//torightof relative locator
		WebElement radio = driver.findElement(By.xpath("//input[@id='inlineRadio1']"));
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(radio)).getText());
		driver.close();

	}
}