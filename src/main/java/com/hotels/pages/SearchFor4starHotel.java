package com.hotels.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.hotels.basepage.BasePage;

import utilities.hotels.ElementUtil;
import utilities.hotels.JavaScriptUtil;

public class SearchFor4starHotel extends BasePage {
	
	
	WebDriver driver;
	ElementUtil elementUtil;

	By ratingFour = By.id("f-star-rating-4");
	By landmarks = By.xpath("//h3[contains(text(),'Landmarks')]");
	By cityCenter = By.xpath("//input[@id='f-lid-1506246']");
	By milesOptions = By.xpath("//select[@id='f-distance']");
	By hotelList = By.xpath("//li//a[@class='property-name-link'][contains(text(),'')] ");
	By distance = By.xpath("//li[contains(text(),'miles to City center')] ");
	
	public SearchFor4starHotel(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	
	public void chooseFourStar() throws InterruptedException{
		WebElement fourStar = driver.findElement(ratingFour);
		JavaScriptUtil.scrollIntoView(fourStar, driver);
		elementUtil.doClick(ratingFour);
		Thread.sleep(4000);
	}

	
	public void filterHotelsByDistance() throws InterruptedException{
		WebElement lndmarks = driver.findElement(landmarks);
		JavaScriptUtil.scrollIntoView(lndmarks, driver);
		elementUtil.doClick(landmarks);
		Thread.sleep(3000);
		elementUtil.doClick(cityCenter);
		Thread.sleep(5000);
		
		WebElement tenMiles = driver.findElement(milesOptions);
		JavaScriptUtil.scrollIntoView(tenMiles, driver);
		elementUtil.doClick(milesOptions);
		elementUtil.selectDropdownValueByText(driver, milesOptions, "10 miles");
		Thread.sleep(4000);
	}
	
	public void scrollPageDown() throws InterruptedException{
		for(int i =0; i<10; i++){
			JavaScriptUtil.scrollPageDown(driver);
			Thread.sleep(3000);
	   }
	}
	
	public void showChosenHotels(){
	 List<WebElement> hotelsList = driver.findElements(hotelList);
		for(WebElement hotels: hotelsList){
			System.out.println("Four Star Hotels are "+ hotels.getText());
		}
		
	 List<WebElement> milesFromCityCenter = driver.findElements(distance);
		for(WebElement  milesList: milesFromCityCenter){
			System.out.println("Distances from city center are "+  milesList.getText());
		}
	
	}

}
