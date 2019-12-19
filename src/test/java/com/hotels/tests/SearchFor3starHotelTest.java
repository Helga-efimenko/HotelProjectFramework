package com.hotels.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hotels.basepage.BasePage;
import com.hotels.pages.HotelsHomePage;
import com.hotels.pages.SearchFor3starHotel;


public class SearchFor3starHotelTest extends BasePage {
	

	WebDriver driver;
	Properties prop;
	BasePage basePage;
	HotelsHomePage hotelsHomePage;
	SearchFor3starHotel searchFor3starHotel;
	
	@BeforeMethod
	public void setup() throws InterruptedException{
      basePage = new BasePage();
	  prop = basePage.initialize_properties();
	  driver = basePage.initialize_driver(prop);
	  hotelsHomePage = new HotelsHomePage(driver);
	  hotelsHomePage.fillWhereToForm();
	  searchFor3starHotel = new SearchFor3starHotel(driver);
	  
	  try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority=1,description="This method searches for 3 star hotels"
			+ " with distance less than 10 miles from city center, give a list of these hotels and finds if Hilton hotel is available or not ")
	public void threeStars() throws InterruptedException{
	 searchFor3starHotel.chooseThreeStar();	
	 searchFor3starHotel.filterHotelsByDistance();
	 searchFor3starHotel.scrollPageDown();
     searchFor3starHotel.showChosenHotels();
	 searchFor3starHotel.isHiltonDisplayed();
		
	}
	


	

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
