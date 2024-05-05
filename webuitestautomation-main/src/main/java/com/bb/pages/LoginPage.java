		package com.bb.pages;
		
		import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;
		
		public class LoginPage {
		
			WebDriver driver;
		
			public LoginPage(WebDriver driver) {
				this.driver = driver;
			}
			
			public String getTitle() {
			  return driver.getTitle();  // String format - return the string
			}
			
			/*
			 * Page Objects
			 */
			By loginlink = By.className("ico-login");
			By emailtxt = By.id("Email");
			By passwordtxt = By.id("Password");
			By Loginbtn = By.cssSelector("input.button-1.login-button");
			
			By logOutLink = By.className("ico-logout");
		
			/**
			 * This method is to click on Login link
			 */
			public void clickLoginLink() {
				driver.findElement(loginlink).click();
			}
		
			/**
			 * This method is to Enter email address
			 */
			public void enterEmailAddress(String emailaddress) {
				driver.findElement(emailtxt).sendKeys(emailaddress);
			}
		
			/**
			 * This method is to enter password in password field
			 */
			public void enterPassword(String pass) {
				driver.findElement(passwordtxt).sendKeys(pass);
			}
		
			/**
			 * This method is to click on Login button
			 */
		
			public void clickLoginBtn() {
				driver.findElement(Loginbtn).submit();
			}

			public void clickLogout() {
				driver.findElement(logOutLink).click();
				
			}
		}
