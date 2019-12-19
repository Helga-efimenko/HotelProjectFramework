package com.hotels.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hotels.basepage.BasePage;
import com.hotels.pages.HotelsHomePage;
import com.hotels.pages.SearchFor5starHotel;

public class SearchFor5starHotelTest extends BasePage {

	WebDriver driver;
	Properties prop;
	BasePage basePage;
	HotelsHomePage hotelsHomePage;
	SearchFor5starHotel searchFor5starHotel;
	
	@BeforeMethod
	public void setup() throws InterruptedException{
      basePage = new BasePage();
	  prop = basePage.initialize_properties();
	  driver = basePage.initialize_driver(prop);
	  hotelsHomePage = new HotelsHomePage(driver);
	  hotelsHomePage.fillWhereToForm();
	  searchFor5starHotel = new SearchFor5starHotel(driver);
	  
	  try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority=1,description="This method searches for 5star hotels"
			+ " with distance less than 10 miles from city center and gives lists of hotels and their distance from center")
	public void fiveStars() throws InterruptedException{
	 searchFor5starHotel.chooseFiveStar();	
	 searchFor5starHotel.filterHotelsByDistance();
	 searchFor5starHotel.scrollPageDown();
	 searchFor5starHotel.showChosenHotels();
	}
	

	

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
}
