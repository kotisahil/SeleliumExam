package com.execute.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.selenium.finale.RodanFieldTest;
import com.selenium.finale.RodanfTwoTest;

public class PageObjectTwoTest {
	
	WebDriver driver;

	@BeforeMethod	
	public void intializeDriver() 
	{
		System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	//@Parameters ("browser")
	@Test
	public void executeTest1() throws Exception
	{
		
		RodanfTwoTest second=new RodanfTwoTest(driver);
		second.openUrl();
		second.maximizeWindow();
		second.printCurrentUrl();
		second.clickBecomeConsultant();
		second.clickEnrollNow();
		second.clickPolicylink();
		second.handleWindow();
		String PageURL=second.verifyPolicyPage();
		Assert.assertTrue(PageURL.contains("Policies_Procedures_CANADA"), "The user is not navigated to policy page");
		System.out.println("The user is navigated to policy and privacy page");
		second.entertest();
		second.clickbutton();
		
	}

	@AfterMethod
	public void CloseBrowser()
	{
		driver.quit();	

	}


}
