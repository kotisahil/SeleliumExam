package com.selenium.finale;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RodanfTwoTest {

	private WebDriver driver;

	private static By consultant_lnk= By.xpath("//a[@id='corp-opp']");
	private static By enrollnow_lnk= By.xpath("//ul[@id='dropdown-menu']/li[2]/div/a");
	private static By policy_lnk= By.xpath("//div[@id='disclaimer']/div/p/a[1]");
	private static By test_txt= By.xpath("//input[@id='sponserparam']");
	private static By search_btn= By.xpath("//button[@id='search-sponsor-button']");
	



	public RodanfTwoTest(WebDriver driver){
		this.driver=driver;

	}

	public void openUrl()
	{
		String Rodan_Url = "https://www.rodanandfields.com/ca/";
		driver.get(Rodan_Url);

	}

	public void maximizeWindow()
	{
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); 
	}

	public void printCurrentUrl() throws Exception
	{
		String currentURl=driver.getCurrentUrl();
		System.out.println("The Current Url is" + currentURl);
		Thread.sleep(10000);
	}

	public void clickBecomeConsultant()
	{
		WebElement consultant=driver.findElement(consultant_lnk);
		consultant.click();

	}

	public void clickEnrollNow()
	{
		WebElement enroll=driver.findElement(enrollnow_lnk);
		enroll.click();

	}


	public void clickPolicylink() throws Exception
	{
		WebElement policy=driver.findElement(policy_lnk);
		policy.click();
		Thread.sleep(20000);	

	}

	public void handleWindow()
	{
		String ParentWdHandle=driver.getWindowHandle(); 
		Set<String> allhandle=driver.getWindowHandles();
		for(String winHandle :allhandle)
		{
			driver.switchTo().window(winHandle);
			if(driver.getTitle().equals("Consultant Policies and Procedures - Policies_Procedures_CANADA.pdf"))
				break;
			System.out.println("Title of the page after - switchingTo: " + driver.getTitle());
		}
	}		

	public String verifyPolicyPage()
	{	
		String pageurl=driver.getCurrentUrl();
		System.out.println("The current Url is"+ pageurl);
		return pageurl;
	}
	
	public void entertest() throws Exception
	{
		WebElement enterTest=driver.findElement(test_txt);
		enterTest.sendKeys("Test");

	}
	
	public void clickbutton()
	{
		WebElement searchbtn=driver.findElement(search_btn);
		searchbtn.click();

	}
	
	
	

}
