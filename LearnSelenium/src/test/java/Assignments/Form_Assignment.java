package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Form_Assignment {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@class='form-group'] //input[@name='name']")).sendKeys("Vinay");
		driver.findElement(By.xpath("//div[@class='form-group'] //input[@name='email']")).sendKeys("baradwajvinay.09@gmail.com");
		driver.findElement(By.xpath("//div[@class='form-group'] //input[@type='password']")).sendKeys("123456789");
		driver.findElement(By.id("exampleCheck1")).click();
		WebElement staticdropdown = driver.findElement(By.id("exampleFormControlSelect1"));
		Select dropdown = new Select(staticdropdown);
		dropdown.selectByIndex(0);

		driver.findElement(By.xpath("//input[@id='inlineRadio1']")).click();
		driver.findElement(By.xpath("//input[@name='bday']")).sendKeys("01/02/2023");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText());
	}
}