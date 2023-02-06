package Tables_AND_Scrolling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Scrolling_and_Tables 
{
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=500");

		List<WebElement> values = driver.findElements(By.xpath("//div[@class='tableFixHead']/table/tbody/tr/td[4]"));
		int sum = 0;
		for(int i=0; i<values.size(); i++)
		{
			int num = (Integer.parseInt(values.get(i).getText()));
			sum = sum+num;
		}
		String total = driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(":")[1].trim();
		int totalval =	Integer.parseInt(total);
		Assert.assertEquals(sum, totalval);
	}
}