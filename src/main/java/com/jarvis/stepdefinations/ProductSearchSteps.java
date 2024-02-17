package com.jarvis.stepdefinations;

import com.jarvis.pages.HomePage;
import com.jarvis.pages.SearchResultPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSearchSteps {

	@Given("Enter Levis in search component")
	public void enterProductToSearch() {

		HomePage homePage = new HomePage();
		homePage.enterProductToSearch("Levis");

	}

	@When("User clicks on serach magnifier")
	public void clickOnSearchMagnifier() {
		HomePage homePage = new HomePage();
		homePage.clickOnSearchMagnifier();

	}
	@Then ("All results populated must contain word Levis in it")
	public void assertResults() {
		SearchResultPage search = new SearchResultPage();
		search.verifyProductTitlesContains("Levis");

	}
}
