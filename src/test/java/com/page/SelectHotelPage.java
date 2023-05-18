package com.page;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import BaseClass.BaseClass2;

public class SelectHotelPage extends BaseClass2 {
	
	@FindBy(xpath = "//a[text()='Continue'][1]")
	private WebElement btnContinue;
	@FindBy(xpath = "label[text()='Name Ascending']")
	private WebElement nameAsc;
	@FindBy(xpath = "//div[@class='fliter_box_inner mb-4']//h5")
	private List<WebElement> lstHotelNames;
	public WebElement getBtnContinue() {
		return btnContinue;
	}
	public WebElement getNameAsc() {
		return nameAsc;
	}
	public List<WebElement> getLstHotelNames() {
		return lstHotelNames;
	}
	public WebElement getCheckStandard() {
		return checkStandard;
	}
	@FindBy(id="Standard")
	private WebElement checkStandard;
	
	//1. Select Hotel and verify navigate to book Hotel upon accepting the alert
	public void selectHotelWithAlert() {
    elementClick(getBtnContinue());
    alertAccept();
	}
	
	//2 Select hotel and verify navigate to book hotel upon dismiss the alert
	public void selectHotelWithoutAlert() {
		elementClick(getBtnContinue());
		alertDismiss();
    
	}
	
	//3. Sort Name Ascending
	public Boolean VerifyHotelNameAsc() {
    elementClick(getNameAsc());
    List<String> lstHotelNameBeforeSort = new ArrayList<String>();
    for (WebElement eachHotelElement : getLstHotelNames()) {
    	String eachHotelName = getText(eachHotelElement);
    	lstHotelNameBeforeSort.add(eachHotelName);
	}
List<String> lstHotelNameAfterSort = new ArrayList<String>();
lstHotelNameAfterSort.addAll(lstHotelNameBeforeSort);
boolean isHotelNameAsc = lstHotelNameBeforeSort.equals(lstHotelNameAfterSort);
return isHotelNameAsc;
		
	}
	
	//4.Unselecting roomtype and verify listing all hotels
	public Boolean verifyUnselectRoomType() {
	  boolean isroomTypeCount=false;
	  List<WebElement> lstHotelElementbefore=getLstHotelNames();
	  int beforeCount = lstHotelElementbefore.size();
	elementClick(getCheckStandard());
	List<WebElement> lstHotelElementAfter = getLstHotelNames();
	int afterCount = lstHotelElementAfter.size();
	if (beforeCount==afterCount) {
		isroomTypeCount=true;
	}
	return isroomTypeCount;
	}
	
	

}
