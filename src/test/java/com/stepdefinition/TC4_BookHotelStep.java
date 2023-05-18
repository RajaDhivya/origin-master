package com.stepdefinition;

import io.cucumber.java.en.*;

public class TC4_BookHotelStep {
	

	@When("User add guest details\"Ms.\",{string},{string},\"<Mobile no.>\"and\"dhivyaraja04@gmail.com\"")
	public void user_add_guest_details_ms_mobile_no_and_dhivyaraja04_gmail_com(String string, String string2) {
	}
	@When("User enter payment details,proceed with card type\"Cerdit Card\"")
	public void user_enter_payment_details_proceed_with_card_type_cerdit_card(io.cucumber.datatable.DataTable dataTable) {
	}
	@Then("User should verify the success message after payment {string} and save the order ID")
	public void user_should_verify_the_success_message_after_payment_and_save_the_order_id(String string) {
	}
	@Then("User should verify selected hotel is present")
	public void user_should_verify_selected_hotel_is_present() {
	}

	@When("User enter the payment details by UPI id {string}")
	public void user_enter_the_payment_details_by_upi_id(String string) {
	}
	@Then("User should verify the error message after payment details {string}")
	public void user_should_verify_the_error_message_after_payment_details(String string) {
	}

	@When("User enter payment details,proceed with card type\"<Card type>\"")
	public void user_enter_payment_details_proceed_with_card_type_card_type(io.cucumber.datatable.DataTable dataTable) {
	}
	@Then("User should verify the error message after entering card details {string}")
	public void user_should_verify_the_error_message_after_entering_card_details(String string) {
	}









}
