package com.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookingConfirmPage {
	public static String substring;
	
	@FindBy(xpath = "//h2//strong")
	private WebElement OrderId;
	@FindBy(xpath = "//h2[text()=' Booking is Confirmed ']")
	private WebElement txtBookingConfirm;

	public WebElement getOrderId() {
		return OrderId;
	}

	public WebElement getTxtBookingConfirm() {
		return txtBookingConfirm;
	}

//Get the order id and return it	
	public void bookingConfirmPage() {
		String text = getOrderId().getText();
		String[] x = text.split(" ");
		 substring = x[0].substring(1);
	}
	
	
	
}
