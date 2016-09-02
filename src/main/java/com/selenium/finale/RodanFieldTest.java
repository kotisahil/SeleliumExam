package com.selenium.finale;

import java.io.File;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class RodanFieldTest {

	private WebDriver driver;

	private static By ShopSkinCare_link= By.xpath("//a[@id='our-products']");
	private static By AllProduct_link= By.xpath("//ul[@id='dropdown-menu']/li[7]/div/a");
	private static By product_dd= By.xpath("//div[@id='quick-refine']/div[2]/div[1]/input");
	private static By redefine_chk= By.xpath("//input[@id='REDEFINE']/..");
	private static By reverse_chk= By.xpath("//input[@id='REVERSE']/..");
	private static By price_dd=By.xpath("//div[@id='quick-refine']/div[2]/div[2]/input");
	private static By pricevalue_chk=By.xpath("//input[@id='CAD$50 TO CAD$199.99']/..");
	private static By redefine_lbl=By.xpath("//div[@id='quick-filtered']/ul[2]/li[1]/form/label");	
	private static By reverse_lbl=By.xpath("//div[@id='quick-filtered']/ul[2]/li[2]/form/label");
	//private static By randomproduct=By.xpath("//div[@class='product-picture']");
	private static By pricerange=By.xpath("//p[@class='prices']");


	public RodanFieldTest(WebDriver driver){
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

	public void printCurrentUrl()
	{
		String currentURl=driver.getCurrentUrl();
		System.out.println("The Current Url is" + currentURl);
	}

	public void clickShopSkin()
	{
		WebElement shopskinlink=driver.findElement(ShopSkinCare_link);
		shopskinlink.click();

	}

	public void clickAllproducts() throws Exception
	{
		WebElement allProducts=driver.findElement(AllProduct_link);
		allProducts.click();
		Thread.sleep(5000);
	}

	public String verifyurl()
	{
		String quickshopUrl=driver.getCurrentUrl();
		return quickshopUrl;		
	}

	public void clickproductdd() throws Exception
	{
		WebElement productdd=driver.findElement(product_dd);
		productdd.click();
		Thread.sleep(5000);
	}

	public void clickredefine() throws Exception
	{
		WebElement redefine=driver.findElement(redefine_chk);
		redefine.click();
		Thread.sleep(10000);
	}

	public void clickreverse() throws Exception
	{
		WebElement reverse=driver.findElement(reverse_chk);
		reverse.click();
		Thread.sleep(10000);
	}

	public void clickpriceDD() throws Exception
	{
		WebElement pricedd=driver.findElement(price_dd);
		pricedd.click();
		Thread.sleep(10000);
	}

	public void clickpriceValue() throws Exception
	{
		WebElement pricevalue=driver.findElement(pricevalue_chk);
		pricevalue.click();
		Thread.sleep(10000);
	}

	public String verifylabelRedefine()
	{
		WebElement redefinelbl=driver.findElement(redefine_lbl);
		String redefinetext=redefinelbl.getText();
		return redefinetext;

	}

	public String verifylabelReverse()
	{
		WebElement reverselbl=driver.findElement(reverse_lbl);
		String reversetext=reverselbl.getText();
		return reversetext;
	}

	public void verifychkRedefine() throws Exception
	{
		Thread.sleep(10000);
		WebElement redefine=driver.findElement(redefine_chk);
		Assert.assertTrue(redefine.isSelected(), "The redefine chkbox is not selected");
		System.out.println("The redefine checkbox is selected");	
		Thread.sleep(10000);
	}

	public void verifychkReverse()
	{
		WebElement reverse=driver.findElement(reverse_chk);
		Assert.assertTrue(reverse.isSelected(), "The redefine chkbox is not selected");
		System.out.println("The redefine checkbox is selected");
	}


/*	public void verifPriceRange()
	{
        List<WebElement> allprice = driver.findElements(pricerange);
        List<WebElement> splitvalue = allprice.split("$");
		 for (int i=0; i< arrSplit.length; i++)
		    {
		      System.out.println(arrSplit[i]);
		    }
		  }*/
	

	public void takescreenShot()
	{
		try 
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("E:\\Selenium_Shubham\\ScreenShotPricepage"));
			
			System.out.println("Screenshot is printed");
		} 
		catch (Exception e) {
			System.out.println("Exception is handled");
			e.getMessage();
		}
	}

	
	
	}






