package testNGPackage;

import org.testng.annotations.Test;

public class TestNGDemo2 {

	@Test(priority=2,groups={"Reg"})
	public void testCase4()
	{
		System.out.println("Test Case4...");
	}
	
	@Test(priority=3, groups={"Reg","Sanity"})
	public void testCase5()
	{
		System.out.println("Test Case5...");
	}
	
	@Test(priority=1,groups={"Sanity"})
	public void testCase6()
	{
		System.out.println("Test Case6...");
	}
}
