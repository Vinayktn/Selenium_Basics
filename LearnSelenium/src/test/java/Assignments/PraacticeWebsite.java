package Assignments;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PraacticeWebsite 
{
	public static void main(String[] args) throws InterruptedException 
	{
		// https://demo.nopcommerce.com/

		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		//creating an array for the products we want to add to the cart
		String[] itemsneeded = {"HTC One M8 Android L 5.0 Lollipop", "HTC One Mini Blue", "Nokia Lumia 1020"};
		driver.findElement(By.xpath("//ul[@class='top-menu notmobile'] //a[contains(@href, '/electronics')]")).click();
		driver.findElement(By.xpath("//div[@class='sub-category-item'] //a[@href='/cell-phones']")).click();
		List<WebElement> products = driver.findElements(By.xpath("//h2[@class='product-title']"));
		int j=0;
		//converting array to list as the searching is easy in arraylist
		List itemsNeededList = Arrays.asList(itemsneeded);

		for(int i=0; i<products.size(); i++)
		{
			//extracting the names of the products visible in the screen
			String name = products.get(i).getText();
			System.out.println(products.get(i).getText());
			//check weather the name you extracted is present in the above array or not
			if(itemsNeededList.contains(name))
			{
				j++;
				if(driver.findElement(By.xpath("//button[@class='button-2 product-box-add-to-cart-button']")).isDisplayed())
				{
					driver.findElements(By.xpath("//button[@class='button-2 product-box-add-to-cart-button']")).get(i).click();

					if(driver.findElement(By.xpath("//span[@class='close']")).isDisplayed());
					{
						WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(10));
						w.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//span[@class='close']"))));
					}

				}
				else
				{
					//					//Explicit wait
					//					WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(5));
					//					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Shopping cart')]")));
					//					driver.findElements(By.xpath("//button[@class='button-2 product-box-add-to-cart-button']")).get(i).click();
					return;
				}
				if(j==itemsneeded.length)
				{
					break;
				}
			}
		}


	}
}