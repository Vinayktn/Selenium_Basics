package Frames;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames_Practice 
{
	public static void main(String[] args) throws InterruptedException 
	{
		
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
		driver.findElement(By.id("name")).sendKeys("Hello");

		//HANDLING NORMAL OR SINGLE FRAME
		//switching to frame-1
		driver.switchTo().frame(driver.findElement(By.id("frm1")));
		WebElement course = driver.findElement(By.xpath("//select[@id='course']"));
		Select dropdown = new Select(course);
		dropdown.selectByVisibleText("Java");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("World");

		//HANDLING NESTED FRAME
		//switching to frame-3
		driver.switchTo().frame(driver.findElement(By.id("frm3")));
		//switching to frame-1 within frame-3
		driver.switchTo().frame(driver.findElement(By.id("frm1")));
		WebElement course1 = driver.findElement(By.id("selectnav2"));
		Select dropdown1 = new Select(course1);
		dropdown1.selectByVisibleText("Contact");
		Thread.sleep(3000);
		driver.switchTo().parentFrame();
		driver.findElement(By.id("name")).sendKeys("World");
	}
}