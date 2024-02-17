package com.jarvis.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jarvis.keywords.Keyword;



public class HomePage {
	
@FindBy(xpath=" //input[@class=\"desktop-searchBar\"]")
public WebElement searchComponent;

@FindBy(xpath="//span[@class=\"myntraweb-sprite desktop-iconSearch sprites-search\"]")
public WebElement searchMagnifier;


public HomePage() {
	PageFactory.initElements(Keyword.getDriver(),this);
}

public void enterProductToSearch (CharSequence...productName) {
	
	searchComponent.sendKeys(productName);
}
public void clickOnSearchMagnifier() {
	
searchMagnifier.click();
	}
}

