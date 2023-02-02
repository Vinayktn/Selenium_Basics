package Assignments;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PraacticeWebsite {

	public static void main(String[] args) throws InterruptedException {
		// https://demo.nopcommerce.com/

		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();

		//creating an array for the products we want to add to the cart
		String[] itemsneeded = {"HTC One M8 Android L 5.0 Lollipop", "HTC One Mini Blue", "Nokia Lumia 1020"};
		driver.findElement(By.xpath("//ul[@class='top-menu notmobile'] //a[contains(@href, '/electronics')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='sub-category-item'] //a[@href='/cell-phones']")).click();
		Thread.sleep(2000);

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
				Thread.sleep(2000);
				driver.findElements(By.xpath("//button[@class='button-2 product-box-add-to-cart-button']")).get(i).click();
				Thread.sleep(2000);

				if(j==itemsneeded.length)
				{
					break;
				}
			}
		}
	}
}