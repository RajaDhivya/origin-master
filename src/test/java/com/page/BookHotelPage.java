package com.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import BaseClass.BaseClass2;

public class BookHotelPage extends BaseClass2 {
	
	@FindBy(id = "own")
	private WebElement btnMySelf;
	@FindBy(id = "user_title")
	private WebElement ddnSalutation;
	@FindBy(id = "first_name")
	private WebElement txtFirstName;
	@FindBy(id = "last_name")
	private WebElement txtLastName;
	@FindBy(id = "user_phone")
	private WebElement txtPhoneNo;
	@FindBy(id = "user_email")
	private WebElement txtEmail;
	@FindBy(id = "step1next")
	private WebElement btnNext;
	@FindBy(id = "step2next")
	private WebElement btnNext1;
	@FindBy(className = "credit-card pm")
	private WebElement paymentMethod;
	@FindBy(id = "payment_type")
	private WebElement ddnCardType;
	@FindBy(id = "card_type")
	private WebElement ddnCard;
	@FindBy(id = "card_no")
	private WebElement txtCardNo;
	@FindBy(id = "card_name")
	private WebElement nameOnCard;
	@FindBy(id = "card_month")
	private WebElement ddnMonth;
	@FindBy(id = "card_year")
	private WebElement ddnYear;
	@FindBy(id = "cvv")
	private WebElement txtCvv;
	@FindBy(id = "submitBtn")    
	private WebElement btnSubmit;
	@FindBy(className = "upi pm")
	private WebElement selectUpiMethod;
	public WebElement getBtnMySelf() {
		return btnMySelf;
	}
	public WebElement getDdnSalutation() {
		return ddnSalutation;
	}
	public WebElement getTxtFirstName() {
		return txtFirstName;
	}
	public WebElement getTxtLastName() {
		return txtLastName;
	}
	public WebElement getTxtPhoneNo() {
		return txtPhoneNo;
	}
	public WebElement getTxtEmail() {
		return txtEmail;
	}
	public WebElement getBtnNext() {
		return btnNext;
	}
	public WebElement getBtnNext1() {
		return btnNext1;
	}
	public WebElement getPaymentMethod() {
		return paymentMethod;
	}
	public WebElement getDdnCardType() {
		return ddnCardType;
	}
	public WebElement getDdnCard() {
		return ddnCard;
	}
	public WebElement getTxtCardNo() {
		return txtCardNo;
	}
	public WebElement getNameOnCard() {
		return nameOnCard;
	}
	public WebElement getDdnMonth() {
		return ddnMonth;
	}
	public WebElement getDdnYear() {
		return ddnYear;
	}
	public WebElement getTxtCvv() {
		return txtCvv;
	}
	public WebElement getBtnSubmit() {
		return btnSubmit;
	}
	public WebElement getSelectUpiMethod() {
		return selectUpiMethod;
	}
	public WebElement getTxtUpiId() {
		return txtUpiId;
	}
	@FindBy(id= "upi_id")
	private WebElement txtUpiId;



//1.Book hotel w/o includung GST-card(Credit Card-VISA)w/o special request
	public void bookHotel(String salutation, String firstName, String lastName, String mobileNo, String email,
			String cardType, String selectCard, String cardNo, String nameOnCard, String month, String year,
			String cvv) {
		addGuestDetails(salutation, firstName, lastName, mobileNo, email);
		elementClick(getBtnNext1());
		addPaymentDetails(cardType, selectCard, cardNo, nameOnCard, month, year, cvv);
	}
	
	//2.Enter invalid UPI ID and verify error message
		public void bookHotel(String salutation, String firstName, String lastName, String mobileNo, String email,String upiId) {
			addGuestDetails(salutation, firstName, lastName, mobileNo, email);
			elementClick(getBtnNext1());
			elementClick(getSelectUpiMethod());
	         sendValues(getTxtUpiId(), upiId);
		}
	// Enter Guest details
		public void addGuestDetails(String salutation, String firstName, String lastName, String mobileNo, String email) {
			elementClick(btnMySelf);
			selectByOption(ddnSalutation, salutation);
			sendValues(getTxtFirstName(), firstName);
			sendValues(getTxtLastName(), lastName);
			sendValues(getTxtPhoneNo(), mobileNo);
			sendValues(getTxtEmail(), email);
			elementClick(btnNext);

		}

		// Enter Payment details
		public void addPaymentDetails(String cardType, String selectCard, String cardNo, String nameOnCard, String month,
				String year, String cvv) {
			elementClick(getPaymentMethod());
			selectByOption(getDdnCard(), cardType);
			selectByOption(getDdnCardType(), selectCard);
			sendValues(getTxtCardNo(), cardNo);
			sendValues(getNameOnCard(), nameOnCard);
			sendValues(getDdnMonth(), month);
			sendValues(getDdnYear(), year);
			sendValues(getTxtCvv(), cvv);
		}
		}
