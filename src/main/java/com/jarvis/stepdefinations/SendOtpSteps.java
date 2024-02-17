package com.jarvis.stepdefinations;

import com.jarvis.keywords.Keyword;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SendOtpSteps {
	
@Given("Browser is opened and url is launched completely")
public void opnBrowserAndLaunchUrl() {
	
Keyword keyword = new Keyword();
keyword.openBrowser("Chrome");
keyword.openurl("https://www.myntra.com");
}

@When("User enters invalid phone number")
public void user_enters_invalid_phone_number() {
   
}

@Then("User should get error message")
public void user_should_get_error_message() {
   
}



}
