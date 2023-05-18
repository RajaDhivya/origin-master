package com.stepdefinition;


import org.junit.Assert;

import com.pageManager.PageObjectManager;

import BaseClass.BaseClass2;
import io.cucumber.java.en.*;

public class TC1_LoginStep extends BaseClass2 {
	PageObjectManager pom = new PageObjectManager();

	@Given("User is on the OMR branch hotel page")
	public void user_is_on_the_omr_branch_hotel_page() {
	}

	@When("User login {string},{string}")
	public void user_login(String username, String password) {
		pom.getLoginPage().validLogin(username, password);
	}

	@Then("User should verify success message after login {string}")
	public void user_should_verify_success_message_after_login(String expSuccessMsg) {
	String actSuccessMsg = pom.getExploreHotelPage().successMsg();	
	Assert.assertEquals(expSuccessMsg,actSuccessMsg,"Verify the success msg is present");	
		
	}

	@Then("User should verify error message after login {string}")
	public void user_should_verify_error_message_after_login(String string) {
	String actErrorMsg = pom.getLoginPage().errorMsg();
	Assert.assertEquals(actErrorMsg, "Invalid Login details or your password might have expired","Verify the error msg");
	}

}