package Miscellaneous_Topics;

import java.util.List;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Handling_BrokenLinks 
{
 	public static void main(String[] args) throws MalformedURLException, IOException 
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));

		//Passing the chromeoptions object into Chrome driver so that we control the behavior of the browser
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");


		List<WebElement> links = driver.findElements(By.xpath("//div[@id='gf-BIG']/table //li[@class='gf-li']/a"));
		//soft assertion
		SoftAssert s = new SoftAssert();
		for(WebElement link : links)
		{
			String url = link.getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respcode = conn.getResponseCode();
			System.out.println(respcode);
			s.assertTrue(respcode<400, "This link with text " + link.getText()+ "is broken with respense code " + respcode);
		}
		s.assertAll();
	}
}