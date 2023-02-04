package Driver_Scope;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver_Scope 
{
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();

		//1. Give me the count of links on this page
		System.out.println("There are " + driver.findElements(By.tagName("a")).size() + " Links on this web page");

		//2. Get me the count of links in the footer section (Concept of limiting the webdriver scope)
		WebElement footerdriver = driver.findElement(By.xpath("//div[@id='gf-BIG']")); 
		System.out.println("There are " + footerdriver.findElements(By.tagName("a")).size() + " Links on the footer section");

		//3. Get the count of links in the first column
		WebElement columndriver = footerdriver.findElement(By.xpath("//table[@class='gf-t']/tbody/tr/td[1]/ul"));		
		System.out.println("There are " + columndriver.findElements(By.tagName("a")).size() + " Links on the first column");

		//4. Click on each link in the column and check if the pages are opening
		int columncount = columndriver.findElements(By.tagName("a")).size();
		for(int i=1; i<columncount; i++)
		{
			String clickonlink = Keys.chord(Keys.CONTROL,Keys.ENTER);
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlink);
		}
		System.out.println("There are " +driver.getWindowHandles().size()+ " tabs here");

		//Handling multiple windows
		Set<String> abc = driver.getWindowHandles();
		Iterator<String> it = abc.iterator();
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
	}
}