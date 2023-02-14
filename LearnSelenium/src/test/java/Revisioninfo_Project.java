import java.time.Duration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Revisioninfo_Project {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://revisioninfo.cerner.com/");
		driver.manage().window().maximize();
 
 

		//		WebElement Frame1  = driver.findElement(By.id("Nav_Title"));
		//		WebElement Frame2  = driver.findElement(By.xpath("//frame[@id='Nav']"));
		//		WebElement Frame3  = driver.findElement(By.id("ifrSaveCookies"));

		String releasename = "2018.14.02";

		try 
		{
			driver.switchTo().frame(1);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='Pkg_Reports']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='qPackages']")).click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		try 
		{
			driver.switchTo().frame(2);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//input[@id='ckPackageRelease']")).click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();

		Set<String> windows = driver.getWindowHandles();  //parentwindowID   and //childwindowID
		Iterator<String> it = windows.iterator();
		String ParentID = it.next();
		String ChildID = it.next();
		driver.switchTo().window(ChildID);
		driver.manage().window().maximize();
		WebElement staticdropdown = driver.findElement(By.xpath("//select[@id='selFilterValues']"));
		Select dropdown3 = new Select(staticdropdown);
		dropdown3.selectByVisibleText(releasename);
		//	dropdown.selectByVisibleText(releasename);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='btnOK']")).click();

		try 
		{
			driver.switchTo().frame(2);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		Thread.sleep(3000);
 		    
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='btnClear']/following-sibling::div/input[1]")));
		driver.findElement(By.xpath("//input[@name='btnClear']/following-sibling::div/input[1]")).click();

 
 	}

}
