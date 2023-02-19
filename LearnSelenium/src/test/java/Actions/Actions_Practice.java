package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Actions_Practice
{
	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		Actions a = new Actions(driver);
		WebElement move = driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
		a.moveToElement(move).build().perform();

		WebElement move1 = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		a.moveToElement(move1).click().keyDown(Keys.SHIFT).sendKeys("vinay").doubleClick().contextClick().build().perform();
		
		driver.quit();

	}
}
