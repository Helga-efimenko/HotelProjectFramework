package com.hotels.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hotels.basepage.BasePage;
import com.hotels.pages.HotelsHomePage;

import utilities.hotels.Constants;

public class HotelsHomePageTest extends BasePage{
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	HotelsHomePage hotelsHomePage;
	
	@BeforeMethod
	public void setUp(){
	basePage = new BasePage();
	prop = basePage.initialize_properties();
	driver = basePage.initialize_driver(prop);
	hotelsHomePage = new HotelsHomePage(driver);
	
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	}
	
	@Test(priority=1, description="This method verifies the title of the current page")
	public void getHotelsHomePageTitleTest(){
		String title = hotelsHomePage.getHotelsHomePageTitle();
		System.out.println("Home Page title is "+ title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
	}
	
	@Test(priority=2, description="This method chooses the destination, number of children,"
			+ " selects children's ages and submits the info on the page")
	public void homePageActions() throws InterruptedException{
		hotelsHomePage.fillWhereToForm();
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
