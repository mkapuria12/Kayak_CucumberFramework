package com.kayak.qa.listner;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.kayak.qa.utilities.TestBase;


public class TestListener extends TestBase implements ITestListener {

	@Override
	public synchronized void onStart(ITestContext context)
	{
		System.out.println("***********************************\n");
		System.out.println("Test Suite started!\n");
		System.out.println("***********************************\n");

	}
	
	@Override
	public synchronized void onTestStart(ITestResult result)
	{
		System.out.println("***********************************\n");
		System.out.println(result.getMethod().getMethodName()+"------->"+"started!");
		System.out.println("***********************************\n");

		
	}
	
	@Override
	public synchronized void onTestSuccess(ITestResult result)
	{
		System.out.println("*******************************************************\n");
		System.out.println(result.getMethod().getMethodName()+"------->"+"passed!");
		System.out.println("*******************************************************\n");
	}
	
	@Override
	public synchronized void onTestFailure(ITestResult result)
	{
		System.out.println("*******************************************************\n");
		String failtest=result.getMethod().getMethodName();
		System.out.println(failtest+"------->"+"Failed!");
		System.out.println("*******************************************************\n");

	}
	
	@Override
	public synchronized void onTestSkipped(ITestResult result)
	{
		System.out.println("*******************************************************\n");
		System.out.println(result.getMethod().getMethodName()+"------->"+"skipped!");
		System.out.println("*******************************************************\n");
	}
	
	@Override
	public synchronized void onFinish(ITestContext context)
	{
		System.out.println("*******************************************************\n");
		System.out.println("Test Suite ended!");
		System.out.println("*******************************************************\n");

	}
	
}
