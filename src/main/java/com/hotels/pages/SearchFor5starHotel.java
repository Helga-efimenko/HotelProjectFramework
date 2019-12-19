package com.hotels.pages;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.hotels.basepage.BasePage;

import utilities.hotels.ElementUtil;
import utilities.hotels.JavaScriptUtil;

public class SearchFor5starHotel extends BasePage {
	
	WebDriver driver;
	ElementUtil elementUtil;

	By ratingFive = By.id("f-star-rating-5");
	By landmarks = By.xpath("//h3[contains(text(),'Landmarks')]");
	By cityCenter = By.xpath("//input[@id='f-lid-1506246']");
	By milesOptions = By.xpath("//select[@id='f-distance']");
	By hotelList = By.xpath("//li//a[@class='property-name-link'][contains(text(),'')] ");
	By distance = By.xpath("//li[contains(text(),'miles to City center')] ");
	
	public SearchFor5starHotel(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	
	public void chooseFiveStar() throws InterruptedException{
		WebElement fiveStar = driver.findElement(ratingFive);
		JavaScriptUtil.scrollIntoView(fiveStar, driver);
		elementUtil.doClick(ratingFive);
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
			System.out.println("Five Star Hotels are "+ hotels.getText());
		}
		
	 List<WebElement> milesFromCityCenter = driver.findElements(distance);
		for(WebElement  milesList: milesFromCityCenter){
			System.out.println("Distances are "+  milesList.getText() + " to the city center");
		}
	
	}
	
	
	
	
	
	
	
	

}
