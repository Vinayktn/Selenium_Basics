package Assignments;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddingItesmtoCart 
{
	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.manage().window().maximize();
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
	}
}