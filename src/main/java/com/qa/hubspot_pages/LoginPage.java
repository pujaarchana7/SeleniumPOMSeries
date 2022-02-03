package com.qa.hubspot_pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementsUtil;
import com.qa.hubspot_base.BasePage;

public class LoginPage extends BasePage{
	
public WebDriver driver;
public ElementsUtil elementUtil;


// By locators

private By emailId = By.id("input-email");
private By password = By.id("input-password");
private By loginButton = By.xpath("//input[@value = 'Login' and @type = 'submit']");
private By forgotPwdLink = By.linkText("Forgotten Password");
private By registerLink = By.linkText("Register");


//Constructor of the page class

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementsUtil(this.driver);	
	//	WebElement element = (new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElemnetLocated(By.id()));
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		
	}
	
	//page action
	public String getLoginPageTitle() {
		return elementUtil.waitForTitlePresent(Constants.LOGIN_PAGE_TITLE, 5);
	}

//	public String getLoginPageTitle() {
//	String	title = driver.getTitle();
//		return title;
//	}
	
	public boolean isForgotPwdLinkPresent() {
		if(driver.findElement(forgotPwdLink).isDisplayed()) {
			return true;
		}
		return false;
	}
	

public void doLogin() {

	driver.findElement(emailId).sendKeys("pujaarchana9@gmail.com");
	driver.findElement(password).sendKeys("puma107#");
	driver.findElement(loginButton).click();
	
}
	
	
}
