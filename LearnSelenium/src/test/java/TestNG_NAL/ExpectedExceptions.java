package TestNG_NAL;

import org.testng.annotations.Test;

public class ExpectedExceptions 
{

	@Test(expectedExceptions = NumberFormatException.class)
	public void expectedexcep_1()
	{
		String a = "100E";
		Integer.parseInt(a);
	}

	@Test(expectedExceptions = ArithmeticException.class)
	public void expectedexcep_2()
	{
		int a = 100/0;
	}
}
