package Tables_AND_Scrolling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tabel_Chalenge 
{
	static WebDriver driver;
	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		System.out.println(findelemtposition("Germany"));
	}

	static boolean findelemtposition(String name)
	{
		boolean flag = false;
		//Getting the count of number of rows and number of columns in the given table
		int rowcount = driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
		System.out.println(rowcount);
		int colcount = driver.findElements(By.xpath("//table[@id='customers']//th")).size();

		for(int i=1; i<rowcount; i++)
		{
			for(int j=1; j<=colcount; j++)
			{
				String actvalue = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr["+(i+1)+"]/td["+j+"]")).getText();
				if(actvalue.equals(name))
				{
					flag=true;
					System.out.println(i+ " : " +j);
					break;
				}
			}
			if(flag)
			{
				return true;
			}
		}
		return flag;
	}
}