package Miscellaneous_Topics;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshot_1 
{
	public static void main(String[] args) throws IOException {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(co);
		driver.manage().window().maximize();

		driver.get("https://www.google.com/maps");

//		//File
//		File SourceFile = driver.getScreenshotAs(OutputType.FILE);
//		File DestFile = new File("./ScreenShots/img1.jpg");
//		FileUtils.copyFile(SourceFile, DestFile);
//		System.out.println("Screenshot saved successfully");
		//RemoteWebDriver
		
//		//Byte Array
//		byte[] bytearry = driver.getScreenshotAs(OutputType.BYTES);
//		File DestFile = new File("./ScreenShots/img2.jpg");
//		FileOutputStream fos = new FileOutputStream(DestFile);
//		fos.write(bytearry);
//		fos.close();
//		System.out.println("Screenshot saved successfully");
		
		//Base64 method
		String base64 = driver.getScreenshotAs(OutputType.BASE64);
		byte[] bytearry = Base64.getDecoder().decode(base64);
		File DestFile = new File("./ScreenShots/img3.jpg");
		FileOutputStream fos = new FileOutputStream(DestFile);
		fos.write(bytearry);
		fos.close();
		System.out.println("Screenshot saved successfully");
	}
}