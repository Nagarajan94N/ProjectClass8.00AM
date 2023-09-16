package org.pages;

import org.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BaseClass {
	@FindBy(xpath="//a[text()='Create new account']")
	WebDriver click;
	
	@FindBy(xpath="(//input[@type='text'])[2]")
	WebElement firstname;
	
	@FindBy(xpath="(//input[@type='text'])[3]")
	WebElement lastname;
	
	@FindBy(xpath="(//input[@type='text'])[4]")
	WebElement phonenumber;
	
	@FindBy(xpath="(//input[@type='password'])[2]")
	WebElement newpass;

}
