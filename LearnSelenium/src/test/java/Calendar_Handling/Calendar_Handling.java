package Calendar_Handling;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Calendar_Handling 
{
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companion/");
		driver.manage().window().maximize();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)");		


		//		//Selecting the required month
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Date of travel']")).click();
		String month = driver.findElement(By.xpath("//div[@class='flatpickr-month']")).getText();
		while(!month.contains("August"))
		{
			driver.findElement(By.cssSelector(".flatpickr-next-month")).click();
			month = driver.findElement(By.xpath("//div[@class='flatpickr-month']")).getText();
		}

		//		//Selecting the required year
		//		Thread.sleep(10000);
		//		driver.findElement(By.xpath("//div[@class='numInputWrapper'] //span[@class='arrowUp']")).click();
		//		String year = driver.findElement(By.xpath("//div[@class='flatpickr-current-month']")).getText();
		//		Thread.sleep(10000);
		//		while(!year.contains("2027"))
		//		{
		//			driver.findElement(By.xpath("//div[@class='numInputWrapper'] //span[@class='arrowUp']")).click();
		//			Thread.sleep(1000);
		//			year = driver.findElement(By.xpath("//div[@class='flatpickr-current-month']")).getText();
		//			System.out.println(year);
		//		}
		Thread.sleep(1000);


		//selecting the date
		List<WebElement> dates = driver.findElements(By.xpath("//span[@class='flatpickr-day ']"));
		int count = dates.size();

		for(int i=0; i<count; i++)
		{
			WebElement date = dates.get(i);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(date));
			String datetext = date.getText();
			if(datetext.equalsIgnoreCase("27"))
			{
				date.click();
				break;
			}
		}
	}
}