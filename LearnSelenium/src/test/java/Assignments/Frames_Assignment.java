package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames_Assignment {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		driver.manage().window().maximize();
		System.out.println(driver.findElements(By.tagName("frame")).size());
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-top']"))).switchTo().frame((driver.findElement(By.xpath("//frame[@name='frame-middle']"))));
		//driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-middle']")));
		System.out.println(driver.findElement(By.id("content")).getText());
	}

}
	