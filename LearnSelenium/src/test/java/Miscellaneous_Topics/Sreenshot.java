package Miscellaneous_Topics;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Sreenshot {
	public static void main(String[] args) throws IOException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));

		//Passing the chromeoptions object into chromedriver so that we control the behavior of the browser
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.amazon.in/");


		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scr, new File( "C:\\Users\\VK075855\\OneDrive - Cerner Corporation\\Desktop\\Learning\\screenshot.png"));

		driver.quit();

	}
}
