package Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/locatorspractice/");

		//***IMP***This is the concept of implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		driver.findElement(By.id("inputUsername")).sendKeys("baradwajvinay.09@gmail.com");
		driver.findElement(By.name("inputPassword")).sendKeys("uhihoe");
		driver.findElement(By.className("submit")).click();

		//**CSS Selector**
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();

		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Vinay");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("joejefh@pjji.com");
		driver.findElement(By.xpath("//form/input[2]")).clear();
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("baradwajvinay.09@gmail.com");
		driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).sendKeys("8884916790");
		driver.findElement(By.cssSelector("//button[@class='reset-pwd-btn']")).click();
		//driver.quit();
	
	}
}
