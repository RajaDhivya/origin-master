package com.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import BaseClass.BaseClass2;

public class ExploreHotelPage extends BaseClass2 {
	
	@FindBy(id="state")
	private WebElement ddnState;
	@FindBy(id="city")
	private WebElement ddnCity;
	@FindBy(id="room_type")
	private WebElement ddnRoomType;
	@FindBy(id = "check_in")
	private WebElement checkIn;
	@FindBy(id = "check_out")
	private WebElement checkOut;
	@FindBy(id = "no_rooms")
	private WebElement ddnNoOfRooms;
	@FindBy(id = "no_adults")
	private WebElement ddnNoOfAdults;
	@FindBy(id = "no_child")
	private WebElement ddnNoOfChilds;
	@FindBy(id = "hotelsearch_iframe")
	private WebElement iframes;
	@FindBy(id = "searchBtn")
	private WebElement btnSearch;
	@FindBy(id = "invalid-state")
	private WebElement stateErrorMsg;
	@FindBy(id = "invalid-city")
	private WebElement cityErrorMsg;
	@FindBy(id = "invalid-check_in")
	private WebElement checkInErrorMsg;
	@FindBy(id = "invalid-check_out")
	private WebElement checkOutErrorMsg;
	@FindBy(id = "invalid-no_rooms")
	private WebElement noOfRoomsErrorMsg;
	@FindBy(id = "invalid-no_adults")
	private WebElement noOfAdultsErrorMsg;
	@FindBy(xpath = "//div[@class='fliter_box_inner mb-4']//h5")
	private List<WebElement> hotelNames;
	@FindBy(xpath="//a[@class='icoTwitter mr-2 dropdown-toggle']")
	private WebElement successMsg;
	
	public WebElement getSuccessMsg() {
		return successMsg;
	}
	public WebElement getDdnState() {
		return ddnState;
	}
	public WebElement getDdnCity() {
		return ddnCity;
	}
	public WebElement getDdnRoomType() {
		return ddnRoomType;
	}
	public WebElement getCheckIn() {
		return checkIn;
	}
	public WebElement getCheckOut() {
		return checkOut;
	}
	public WebElement getDdnNoOfRooms() {
		return ddnNoOfRooms;
	}
	public WebElement getDdnNoOfAdults() {
		return ddnNoOfAdults;
	}
	public WebElement getDdnNoOfChilds() {
		return ddnNoOfChilds;
	}
	public WebElement getIframes() {
		return iframes;
	}
	public WebElement getBtnSearch() {
		return btnSearch;
	}
	public WebElement getStateErrorMsg() {
		return stateErrorMsg;
	}
	public WebElement getCityErrorMsg() {
		return cityErrorMsg;
	}
	public WebElement getCheckInErrorMsg() {
		return checkInErrorMsg;
	}
	public WebElement getCheckOutErrorMsg() {
		return checkOutErrorMsg;
	}
	public WebElement getNoOfRoomsErrorMsg() {
		return noOfRoomsErrorMsg;
	}
	public WebElement getNoOfAdultsErrorMsg() {
		return noOfAdultsErrorMsg;
	}
	public List getHotelNames() {
		return hotelNames;
	}
	
//	1. Enter all field and verify select hotel
//	2. Select multiple roomtype & verify same filter in header
	public void exploreHotels(String stateName,String cityName,String roomType,String checkInDate,String checkOutDate,
			String noOfRooms,String noOfAdults,String noOfChildrens) {
		
		boolean b = roomType.contains("/");
		if (b) {
			String[] split = roomType.split("/");
			for (String eachroomtype : split) {
				selectByOption(getDdnRoomType(), roomType);
			}
			
		} else {
			selectByOption(getDdnRoomType(), roomType);
		}
  selectByOption(getDdnState(), stateName);
  selectByOption(getDdnCity(), cityName);
  selectByOption(getDdnRoomType(), roomType);
  sendkeysJs(getCheckIn(), checkInDate);
  sendkeysJs(getCheckOut(), checkOutDate);
  selectByOption(getDdnNoOfRooms(), noOfRooms);
  selectByOption(getDdnNoOfAdults(), noOfAdults);
  selectByOption(getDdnNoOfChilds(), noOfChildrens);
  frames(getIframes());
  elementClick(getBtnSearch());
  defaultFrame();
	}
	

//	//3. Passing room type and verify same filter is listed
     public List<Boolean> verifyHotelNameEndsWithRoomType(String roomType) {
    	 List<Boolean> lstHotelResult = new ArrayList<Boolean>();
    	 for (WebElement eachHotelEelement : hotelNames) {
         String eachHotelName = getText(eachHotelEelement);   
         boolean isHotelEndsWith = eachHotelName.contains(roomType);
         lstHotelResult.add(isHotelEndsWith);
			
		}
    	 return lstHotelResult;

	}		
     
//     4.without enter any field click search & verify all 6 error messages
 	public void exploreHotels() {
 		frames(getIframes());
 	    elementClick(getBtnSearch());
 	    defaultFrame();
 	}
     //successmsg
 	public String successMsg() {
   String successmsg = getText(getSuccessMsg());
   System.out.println(successmsg);
return successmsg;
	}
		

}
