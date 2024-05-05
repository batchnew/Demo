package com.bb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import junit.framework.Assert;

public class RegisterPage {

	WebDriver driver;
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
	}

	By regisetrlink= By.className("ico-register");
	By maleRadio = By.id("gender-male");
	By fname = By.id("FirstName");
	By lname= By.id("LastName");
	By email = By.id("Email");
	By pass= By.id("Password");
	By cpass= By.id("ConfirmPassword");
	By regiserBtn = By.id("register-button");
	By msg = By.className("result");
	By logoutLink= By.className("ico-logout");
	By errorMail  = By.className("field-validation-error");
	By fNameErrorMsg =By.xpath("(//*[@class=\"field-validation-error\"])[1]");
	By lNameErrorMsg =By.xpath("(//*[@class=\"field-validation-error\"])[2]");
	By errorMailMsg = By.xpath("(//*[@class=\"field-validation-error\"])[3]");
	By passErrorMsg =By.xpath("(//*[@class=\"field-validation-error\"])[4]");
	By cPassErrorMsg =By.xpath("(//*[@class=\"field-validation-error\"])[5]");
	By differentPassErrorMsg = By.className("field-validation-error");
	
	public void clickOnRegsisterLink() {
		driver.findElement(regisetrlink).click();
	}
	public void clickOnMaleRadioButton() {
		driver.findElement(maleRadio).click();
	}
	public void enterFirstName(String firstName) {
		driver.findElement(fname).sendKeys(firstName);
	}
	public void enterLastName(String lastName) {
		driver.findElement(lname).sendKeys(lastName);
	}
	public void enterEmailAddress(String emailAddress) {
		driver.findElement(email).sendKeys(emailAddress);
	}
	public void enterPassword(String password) {
		driver.findElement(pass).sendKeys(password);
	}
	public void enterConfirmPassword(String cPassword) {
		driver.findElement(cpass).sendKeys(cPassword);
	}
	public void clickOnRegisterButton() {
		driver.findElement(regiserBtn).click();
	}
	public void verifySuccessMsg() {
		String successMsg = driver.findElement(msg).getText();
		Assert.assertEquals(successMsg, "Your registration completed");
		
		
		/*
		 * if(successMsg.contains("Your registration completed")) {
		 * System.out.println("Successfully registered :"+successMsg); } else
		 * System.out.println("Not registered");
		 */
	}
	public void clickOnLogout() {
		driver.findElement(logoutLink).click();
		
	}
	public void invalidMailMsg() {
		String emailErrorMsg = driver.findElement(errorMail).getText();
		Assert.assertEquals(emailErrorMsg, "Wrong email");
		/*
		 * if(emailErrorMsg.contains("Wrong email")) {
		 * System.out.println(emailErrorMsg); } else {
		 * System.out.println("Valid email"); }
		 */
	}
	public void verifyTheErrorMsgs() {
		String fnameError= driver.findElement(fNameErrorMsg).getText();
		Assert.assertEquals(fnameError, "First name is required.");
		
		String lnameError= driver.findElement(lNameErrorMsg).getText();
		Assert.assertEquals(lnameError, "Last name is required.");
		
		String emailError= driver.findElement(errorMailMsg).getText();
		Assert.assertEquals(emailError, "Email is required.");
		
		String passError= driver.findElement(passErrorMsg).getText();
		Assert.assertEquals(passError, "Password is required.");
		
		String cpassError= driver.findElement(cPassErrorMsg).getText();
		Assert.assertEquals(cpassError, "Password is required.");
	}
	public void differentPasswordsErrorMessage() {
		String diffpassErrorMsg= driver.findElement(differentPassErrorMsg).getText();
		Assert.assertEquals(diffpassErrorMsg, "The password and confirmation password do not match.");
	}
	
}
