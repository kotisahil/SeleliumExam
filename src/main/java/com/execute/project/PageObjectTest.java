package com.execute.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.selenium.finale.RodanFieldTest;

public class PageObjectTest {
	
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
		
		RodanFieldTest run=new RodanFieldTest(driver);
		run.openUrl();
		run.maximizeWindow();
		run.printCurrentUrl();
		run.clickShopSkin();
		run.clickAllproducts();
		String url=run.verifyurl();
		Assert.assertTrue(url.contains("quickShop"), "The user is not navigated to page 2");
		System.out.println("The user is navigated to quickShop page");
		run.clickproductdd();
		run.clickredefine();
		run.clickproductdd();
		run.clickreverse();
		run.clickpriceDD();
		run.clickpriceValue();
		String redefine=run.verifylabelRedefine();
		Assert.assertEquals(redefine, "REDEFINE");
		System.out.println("The label Redefine Exists on page");
		String reverse=run.verifylabelReverse();
		Assert.assertEquals(reverse, "REVERSE");
		System.out.println("The label Reverse Exists on page");
		run.verifychkRedefine();
		run.verifychkReverse();
		run.takescreenShot();
	
	}

	@AfterMethod
	public void CloseBrowser()
	{
		driver.quit();	

	}
	
	
}
