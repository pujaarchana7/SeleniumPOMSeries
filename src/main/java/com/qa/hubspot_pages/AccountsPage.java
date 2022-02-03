package com.qa.hubspot_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.utils.ElementsUtil;
import com.qa.hubspot_base.BasePage;

public class AccountsPage extends BasePage {

	private WebDriver driver;
	private ElementsUtil elemtUtil;
	
	
	//By Locator
	private By header = By.cssSelector("div#logo a");
	private By accountSectionHeaders = By.cssSelector("div#content h2");
	private By searchText = By.cssSelector("div#search input[name='search']");
	
}
