package TestNG_NAL;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


//@BeforeSuite  -- setup system property for chrome
//@BeforeTest  -- launchbrowser
//@BeforeClass  -- login to app

//@BeforeMethod  -- enterURL
//@Test  -- google logo test
//@AfterMethod -- logout from app

//@BeforeMethod  -- enterURL
//@Test  -- Google title test
//@AfterMethod -- logout from app

//@BeforeMethod  -- enterURL
//@Test  -- search test
//@AfterMethod -- logout from app

//@AfterClass   -- close the browser
//@AfterTest  -- deleteallcookies


public class TestNgBasics 
{
	//pre-condition annotatioons -- starting with @Before
	@BeforeSuite  //1
	public void setup() 
	{
		System.out.println("@BeforeSuite  -- setup system property for chrome");
	}

	@BeforeTest  //2
	public void launchbrowser() 
	{
		System.out.println("@BeforeTest  -- launchbrowser");
	}

	@BeforeClass  //3
	public void login() 
	{
		System.out.println("@BeforeClass  -- login to app");
	}

	@BeforeMethod  //4  //7  //10
	public void enterURL() 
	{
		System.out.println("@BeforeMethod  -- enterURL");
	}

	@Test  //5
	public void googletitletest() 
	{
		System.out.println("@Test  -- Google title test");
	}

	@Test  //8
	public void searchtest() 
	{
		System.out.println("@Test  -- search test");
	}

	@Test	//11
	public void googlelogotest() 
	{
		System.out.println("@Test  -- google logo test");
	}

	@AfterMethod  //6  //9  //12
	public void logout() 
	{
		System.out.println("@AfterMethod -- logout from app");
	}

	@AfterClass  //13
	public void closebrowser() 
	{
		System.out.println("@AfterClass   -- close the browser");
	}

	@AfterTest  //14
	public void deleteallcookies() 
	{
		System.out.println("@AfterTest  -- deleteallcookies");
	}
}
