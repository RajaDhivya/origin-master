package com.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import BaseClass.BaseClass2;

public class MyBookingPage extends BaseClass2 {

	@FindBy(xpath = "//a[@data-testid='username']")
	private WebElement welcomeBtn;
	@FindBy(xpath = "//a[text()='My Account']")
	private WebElement btnMyAccount;
	@FindBy(xpath = "//a[text()='My Bookings']")
	private WebElement MyBookingClick;
	@FindBy(name = "search")
	private WebElement txtSearchBox;
	@FindBy(xpath = "//a//h5")
	private WebElement txtBooking;
	@FindBy(xpath = "//button[@class='edit btn filter_btn']")
	private WebElement editBookingBtn;
	@FindBy(name = "check_in")
	private WebElement checkIn;
	@FindBy(xpath = "//button[text()='Confirm']")
	private WebElement confirmBtn;
	@FindBy(xpath = "//li[contains(text(),'Booking updated')]")
	private WebElement updateSuccessMsg;
	@FindBy(xpath = "(//a[text()='Cancel'])[1]")
	private WebElement cancelBtn;
	@FindBy(xpath = "//li[contains(text(),'cancelled successfully')]")
	private WebElement cancelSuccessMsg;

	public WebElement getWelcomeBtn() {
		return welcomeBtn;
	}
	public WebElement getBtnMyAccount() {
		return btnMyAccount;
	}
	public WebElement getMyBookingClick() {
		return MyBookingClick;
	}
	public WebElement getTxtSearchBox() {
		return txtSearchBox;
	}
	public WebElement getTxtBooking() {
		return txtBooking;
	}
	public WebElement getEditBookingBtn() {
		return editBookingBtn;
	}
	public WebElement getCheckIn() {
		return checkIn;
	}
	public WebElement getConfirmBtn() {
		return confirmBtn;
	}
	public WebElement getUpdateSuccessMsg() {
		return updateSuccessMsg;
	}
	public WebElement getCancelBtn() {
		return cancelBtn;
	}
	public WebElement getCancelSuccessMsg() {
		return cancelSuccessMsg;
	}
	//Change and Cancel Booking

	public void orderIdSearch() {
		elementClick(getWelcomeBtn());
		elementClick(getBtnMyAccount());
		sendkeysJs(getTxtSearchBox(), BookingConfirmPage.substring);
	}

	public void changeBooking(String checkIn) {
		orderIdSearch();
		elementClick(getEditBookingBtn());
		elementClick(getCheckIn());
		sendkeysJs(getCheckIn(), checkIn);
		elementClick(getConfirmBtn());

	}

	public void cancelBooking() {
		orderIdSearch();
		elementClick(getCancelBtn());
		alertAccept();
		getText(getCancelSuccessMsg());
	}

	public void cancelOrderIdE2E(String checkIn) {
		changeBooking(checkIn);
		cancelBooking();

		
	}
	}	
	
	
	
	
	

