package com.qa.hubspot_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.hubspot.utils.Constants;
import com.qa.hubspot_base.BaseTest;
import com.qa.hubspot_pages.LoginPage;


public class LoginPageTest extends BaseTest{

	public LoginPage loginPage;
	
	@Test(priority =1)
	public void verifyLoginPageTitleTest() {
		loginPage = new LoginPage(driver);
		String title = loginPage.getLoginPageTitle();
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority =3)
	public void doLoginTest() {
		loginPage.doLogin();
	}
	
	@Test(priority =2)
	public void verifyForgotPwdLinkPresentTest() {
		boolean isForgotPwdLinkExist = loginPage.isForgotPwdLinkPresent();
		Assert.assertTrue(isForgotPwdLinkExist);
	}
}
