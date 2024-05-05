package com.bb.tests;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bb.base.BasePage;
import com.bb.pages.RegisterPage;

public class RegisterTest extends BasePage {
	RegisterPage registerPage;
	@BeforeSuite
	public void setUp() {
		invokeBrowser();
		registerPage = new RegisterPage(driver);
	}
	
	@DataProvider(name = "registerwithValidData")
	public Object[][] validRegisetr(){
		return new Object[][] {{"srini","rap","srinirap1324@gmail.com","123123","123123"}};
	}
	
	//@Test(dataProvider = "registerwithValidData",enabled = true,priority = 0)
	public void verify_the_register_functionality_with_valid_data(String firstName,String LastName, String EmailAddress, String Password, String ConfirmPassword) {
		registerPage.clickOnRegsisterLink();
		registerPage.clickOnMaleRadioButton();
		registerPage.enterFirstName(firstName);
		registerPage.enterLastName(LastName);
		registerPage.enterEmailAddress(EmailAddress);
		registerPage.enterPassword(Password);
		registerPage.enterConfirmPassword(ConfirmPassword);
		registerPage.clickOnRegisterButton();
		registerPage.verifySuccessMsg();
		registerPage.clickOnLogout();
	}
	
	@DataProvider(name = "registerwithInvalidEmail")
	public Object[][] inValidRegisetr(){
		return new Object[][] {{"srini","rap","srinirapw21@gmail","123123","123123"}};
	}
	
	//@Test(dataProvider = "registerwithInvalidEmail",enabled = true,priority = 1)
	public void verify_the_register_functionality_with_inValid_Email(String firstName,String LastName, String EmailAddress, String Password, String ConfirmPassword) {
		registerPage.clickOnRegsisterLink();
		registerPage.clickOnMaleRadioButton();
		registerPage.enterFirstName(firstName);
		registerPage.enterLastName(LastName);
		registerPage.enterEmailAddress(EmailAddress);
		registerPage.enterPassword(Password);
		registerPage.enterConfirmPassword(ConfirmPassword);
		registerPage.clickOnRegisterButton();
		registerPage.invalidMailMsg();
	}

	@Test(enabled = true,priority = 2)
	public void verify_the_register_functionality_By_click_on_Resgister_Butoon_without_Entering_The_data() {
		registerPage.clickOnRegsisterLink();
		registerPage.clickOnRegisterButton();
		registerPage.verifyTheErrorMsgs();
	}

	@DataProvider(name = "differentPasswords")
	public Object[][] differentPasswords(){
		return new Object[][] {{"srini","rap","srinirapw21@gmail.com","000000","123123"}};
	}
//	@Test(dataProvider = "differentPasswords",enabled = true,priority = 3)
	public void verify_the_register_functionality_By_Entering_different_password(String firstName,String LastName, String EmailAddress, String Password, String ConfirmPassword) {
		registerPage.clickOnRegsisterLink();
		registerPage.clickOnMaleRadioButton();
		registerPage.enterFirstName(firstName);
		registerPage.enterLastName(LastName);
		registerPage.enterEmailAddress(EmailAddress);
		registerPage.enterPassword(Password);
		registerPage.enterConfirmPassword(ConfirmPassword);
		registerPage.clickOnRegisterButton();
		registerPage.differentPasswordsErrorMessage();
	}
	
}
