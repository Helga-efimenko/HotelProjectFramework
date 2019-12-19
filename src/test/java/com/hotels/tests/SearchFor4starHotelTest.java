package com.hotels.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hotels.basepage.BasePage;
import com.hotels.pages.HotelsHomePage;
import com.hotels.pages.SearchFor4starHotel;


public class SearchFor4starHotelTest extends BasePage {

	

	WebDriver driver;
	Properties prop;
	BasePage basePage;
	HotelsHomePage hotelsHomePage;
	SearchFor4starHotel searchFor4starHotel;
	
	@BeforeMethod
	public void setup() throws InterruptedException{
      basePage = new BasePage();
	  prop = basePage.initialize_properties();
	  driver = basePage.initialize_driver(prop);
	  hotelsHomePage = new HotelsHomePage(driver);
	  hotelsHomePage.fillWhereToForm();
	  searchFor4starHotel = new SearchFor4starHotel(driver);
	  
	  
	  try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority=1,description="This method searches for 4 star hotels"
			+ " with distance less than 10 miles from city center and gives a list of the hotels")
	public void fourStars() throws InterruptedException{
	 searchFor4starHotel.chooseFourStar();	
	 searchFor4starHotel.filterHotelsByDistance();
	 searchFor4starHotel.scrollPageDown();
	 searchFor4starHotel.showChosenHotels();
	}
	
	

	

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
