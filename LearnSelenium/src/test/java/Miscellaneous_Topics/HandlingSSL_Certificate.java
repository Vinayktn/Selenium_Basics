package Miscellaneous_Topics;


import java.util.Arrays;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandlingSSL_Certificate 
{
	public static void main(String[] args)
	{
		//handling SSL certificates
		ChromeOptions options = new ChromeOptions();
	//	options.setAcceptInsecureCerts(true);
		options.addArguments("start-maximized");
	
		options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));

//		//Handling proxy's
//		Proxy proxy = new Proxy();
//		proxy.setHttpProxy("proxy srting");
//		options.setCapability("Proxy", proxy);

		//Passing the chromeoptions object into chromedriver so that we control the behavior of the browser
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.amazon.in/");
		driver.quit();

	}
}
