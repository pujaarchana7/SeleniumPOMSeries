package com.qa.hubspot_base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public WebDriver driver;
	public Properties prop;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	public WebDriver init_driver(String browser) {
		System.out.println(" browser value is:" +browser);
		if(browser.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver();
			tlDriver.set(new ChromeDriver());
		}
		else if(browser.equalsIgnoreCase("firefox")){
			WebDriverManager.chromedriver().setup();
			//driver = new FirefoxDriver();
			tlDriver.set(new FirefoxDriver());
		}
		else if(browser.equalsIgnoreCase("safari")){
			WebDriverManager.chromedriver().setup();
			//driver = new SafariDriver();
			tlDriver.set(new SafariDriver());
		}
		else {
			System.out.println("Please pass correct browser : " + browser);
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
		
	}
	
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
	
	public Properties init_prop() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream ("./src/main/java/com/qa/hubspot_config/config.properties");
			prop.load(ip);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	public String getScreenshot() {
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
	
	
}
