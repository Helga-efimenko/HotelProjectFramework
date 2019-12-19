package com.hotels.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.hotels.basepage.BasePage;

import utilities.hotels.Constants;
import utilities.hotels.ElementUtil;

public class HotelsHomePage extends BasePage {
	WebDriver driver;
	ElementUtil elementUtil;
	
	By destinationInput = By.cssSelector("input[id='qf-0q-destination']");
	By destinationChosen = By.xpath("//div[contains(text(),"
			+ "'New York, New York, United States of America')]");
	By childrenInput = By.id("qf-0q-room-0-children");
	By childOneAge = By.id("qf-0q-room-0-child-0-age");
	By childTwoAge = By.id("qf-0q-room-0-child-1-age");
	By searchBTN = By.xpath("//button[@type='submit']");
	
	public HotelsHomePage(WebDriver driver){
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	public String getHotelsHomePageTitle(){
		return elementUtil.waitForGetPageTitle(Constants.HOME_PAGE_TITLE);
	}
	
	public void fillWhereToForm() throws InterruptedException{
		elementUtil.doClick(destinationInput);
		elementUtil.doClick(destinationChosen);
		elementUtil.selectDropDownByIndex(driver, childrenInput, 2);
		elementUtil.selectDropDownByIndex(driver, childOneAge, 3);
		elementUtil.selectDropDownByIndex(driver, childTwoAge, 4);
		elementUtil.doClick(searchBTN);
		Thread.sleep(5000);
	}
	
	
}
