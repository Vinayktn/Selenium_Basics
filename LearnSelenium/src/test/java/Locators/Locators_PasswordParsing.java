package Locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
 
public class Locators_PasswordParsing {

	public static void main(String[] args) throws InterruptedException {
//		WebDriver driver = new ChromeDriver();
		WebDriver driver = new EdgeDriver();

		String name = "Vinay";
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().window().maximize();
		driver.findElement(By.id("inputUsername")).sendKeys("Vinay");
		driver.findElement(By.name("inputPassword")).sendKeys("ihihf");
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		Thread.sleep(3000);
		String password = getpassword(driver);
		driver.findElement(By.className("go-to-login-btn")).click();
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		Thread.sleep(3000);
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+name+",");
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();
		driver.close();
	}


	public static String getpassword(WebDriver driver) throws InterruptedException
	{
		String resetpassword = driver.findElement(By.cssSelector("form p")).getText();
		String[] passwordarray = resetpassword.split("'");
		System.out.println(passwordarray[1]);
		String password = passwordarray[1].split("'")[0];
		return password;
	}
}
