import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Revisioninfo_Project {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().browserVersion("latest").setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://revisioninfo.cerner.com/");
		driver.manage().window().maximize();			

		//		WebElement Frame1  = driver.findElement(By.id("Nav_Title"));
		//		WebElement Frame2  = driver.findElement(By.xpath("//frame[@id='Nav']"));
		//		WebElement Frame3  = driver.findElement(By.id("ifrSaveCookies"));

		String releasename = "2018.14.03";		
		driver.switchTo().frame(1);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='Pkg_Reports']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='qPackages']")).click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();

		driver.switchTo().frame(2);
		Actions actions = new Actions(driver);

		driver.findElement(By.xpath("//input[@id='ckPackageRelease']")).click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();

		Set<String> windows = driver.getWindowHandles();  //parentwindowID   and //childwindowID
		Iterator<String> it = windows.iterator();
		String ParentID = it.next();
		String ChildID = it.next();
		driver.switchTo().window(ChildID);
		driver.manage().window().maximize();
		Thread.sleep(3000);

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='selFilterValues']/option[1]")));		
		Wait<WebDriver> wait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(500))
				.ignoring(WebDriverException.class);		

		Actions a = new Actions(driver);
		WebElement move = driver.findElement(By.xpath("//select[@id='selFilterValues']/option[1]"));
		a.moveToElement(move).click().sendKeys(releasename).build().perform();

		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		System.out.println(driver.findElement(By.xpath("//input[@id='btnOK']")).isDisplayed());
		driver.findElement(By.xpath("//input[@id='btnOK']")).click();

		driver.switchTo().window(ParentID);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.switchTo().frame(2);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='btnGetInfo']")).click();



		//		//	dropdown.selectByVisibleText(releasename);
		//		Thread.sleep(3000);
		//		//driver.findElement(By.xpath("//input[@id='btnOK']")).click();
		//		driver.switchTo().parentFrame();
		//		driver.switchTo().frame(3);
		//
		//		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		//		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='btnClear']/following-sibling::div/input[1]")));
		//
		//		Wait<WebDriver> wait = new FluentWait<>(driver)
		//				.withTimeout(Duration.ofSeconds(10))
		//				.pollingEvery(Duration.ofMillis(500))
		//				.ignoring(WebDriverException.class);
		//
		//
		//		Boolean b = driver.findElement(By.xpath("//input[@name='btnClear']/following-sibling::div/input[1]")).isDisplayed();
		//		System.out.println(b);
		//
		//
		//		WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='btnOK']")));
		//		okButton.click();
	}
}

//import java.time.LocalDate;
//import java.time.temporal.WeekFields;
//import java.util.Locale;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class Example {
//    public static void main(String[] args) {
//        // Get the current week number
//        WeekFields weekFields = WeekFields.of(Locale.getDefault());
//        int weekNumber = LocalDate.now().get(weekFields.weekOfWeekBasedYear());
//        
//        // Format the release number string
//        String releaseNumber = String.format("11.%02d", weekNumber);
//        
//        // Use the release number in your Selenium script
//        System.out.println("The current release is " + releaseNumber);
//        
//        // Example Selenium code to navigate to a website using the release number
//        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://example.com/releases/" + releaseNumber);
//        // ...
//        driver.quit();
//    }
//}



