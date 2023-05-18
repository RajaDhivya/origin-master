package com.page;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass2;

public class LoginPage extends BaseClass2 {
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email")
	private WebElement txtUsername;
	@FindBy(id = "pass")
	private WebElement txtPassword;
	@FindBy(xpath = "//button[@value='login']")
	private WebElement btnlogin;
	@FindBy(xpath = "//a[@data-testid='username']")
	private WebElement txtSuccessmsg;
	@FindBy(id = "errorMessage")
	private WebElement txtErroMsg;

	public WebElement getTxtUsername() {
		return txtUsername;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnlogin() {
		return btnlogin;
	}

	public WebElement getTxtSuccessmsg() {
		return txtSuccessmsg;
	}

	public WebElement getTxtErroMsg() {
		return txtErroMsg;
	}

	// 1.Valid login scenario
	// 2.Invalid login Scenario
	public void validLogin(String username, String password) {
		sendValues(getTxtUsername(), username);
		sendValues(getTxtPassword(), password);
		elementClick(getBtnlogin());
	}
	// //2.Login with robot - with the help of Keyboard actions
	 public void loginWithRobotClass(String username,String password) throws
	 AWTException {
	 Robot robot = new Robot();
	 robot.keyPress(KeyEvent.VK_TAB);
	 robot.keyRelease(KeyEvent.VK_TAB);
	 sendkeysViaActiveElement(username);
	 robot.keyPress(KeyEvent.VK_TAB);
	 robot.keyRelease(KeyEvent.VK_TAB);
	 sendkeysViaActiveElement(password);
	 robot.keyPress(KeyEvent.VK_ENTER);
	 robot.keyRelease(KeyEvent.VK_ENTER);
	
	
	 }
	 public String errorMsg() {
		 String errormsg = getText(getTxtErroMsg());
		 System.out.println(errormsg);
		return errormsg;
     
	}

}
