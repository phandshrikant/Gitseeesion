package com.jarvis.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.jarvis.keywords.Keyword;
import com.jarvis.waits.WaitFor;

public class SearchResultPage {

	@FindBy(xpath ="//h3[@class=\"product-brand\"]")
	public List<WebElement> productTitles;
	
	
	private By productTitle = By.xpath("//h3[@class=\"product-brand\"]");
	
	public SearchResultPage() {
		PageFactory.initElements(Keyword.getDriver(), this);
	}
	
	
	public List<String> getProductTitles() {
		WaitFor.numberOfElementsToBeMoreThan(productTitle, 1);
		Keyword keyword = new Keyword();
		return keyword.getTexts(productTitles);

	}
	public void verifyProductTitlesContains(String expectedText) {
	
List<String> titles = getProductTitles();

SoftAssert softly = new SoftAssert();
softly.assertAll();
}
	}

