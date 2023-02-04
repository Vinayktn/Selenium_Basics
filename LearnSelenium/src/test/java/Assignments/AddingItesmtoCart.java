package Assignments;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddingItesmtoCart 
{
	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String[] productnames = {"Cucumber", "Brocolli", "Carrot", "Beetroot"};
		List<WebElement> products = driver.findElements(By.xpath("//h4[@class='product-name']"));
		int j=0;
		for (int i = 0; i < products.size(); i++) 
		{
			String[] name = products.get(i).getText().split("-");
			//name[0]-brocolli
			//name[1]-1 kg
			String formattedname = name[0].trim();
			//format the name to get the actual veggie name before passing to actual array

			//check weather the name you extracted is present in the above array or not
			//convert array into arraylist for easy search as it supports contains method
			List itemsneededlist = Arrays.asList(productnames);

			if (itemsneededlist.contains(formattedname)) 
			{
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(j==productnames.length)
				{
					break;
				}
			}
		}
		driver.findElement(By.xpath("//a[@class='cart-icon']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		driver.findElement(By.xpath("//div[@class='promoWrapper']/input")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();

		//Explicit wait
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));	
		System.out.println("Statement displayed - " + driver.findElement(By.xpath("//span[@class='promoInfo']")).isDisplayed());
		driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();

		WebElement countries = driver.findElement(By.xpath("//div/select"));
		Select dropdown = new Select(countries);
		dropdown.selectByVisibleText("India");
		if (driver.findElement(By.cssSelector(".chkAgree")).isSelected())
		{
			driver.findElement(By.xpath("//button[contains(text(),'Proceed')]")).click();
		}
		else
		{
			driver.findElement(By.xpath("//button[contains(text(),'Proceed')]")).click();
			System.out.println(driver.findElement(By.xpath("//span[@class='errorAlert']/b")).getText());
			Assert.assertEquals(driver.findElement(By.xpath("//span[@class='errorAlert']/b")).getText(), "Please accept Terms & Conditions - Required");
		}
		driver.findElement(By.cssSelector(".chkAgree")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Proceed')]")).click();
		driver.quit();
	}
}