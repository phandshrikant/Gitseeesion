package com.jarvis.keywords;

import java.awt.AWTException;
import java.awt.Robot;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.jarvis.errors.InvalidBrowserError;
import com.jarvis.exceptions.InvalidSelectorException;

public class Keyword<getTexts> {

	private static RemoteWebDriver driver = null;

	/**
	 * This Method return Driver Instance.Make Sure before calling this method
	 * oneshould call openbrowser method.
	 * 
	 * @return
	 */

	public static RemoteWebDriver getDriver() {
		return driver;
	}

	public void openBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
			System.out.println("Opening Chrome Browser");

		} else if (browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
			System.out.println("Opening Firefox Browser");

		} else {
			System.out.println("Invalid browser name");
			throw new InvalidBrowserError(browserName);
		}

	}

	public void openurl(String url) {
		driver.get(url);
		System.out.println("Launching url");

	}

	public void closeBrowser() {
		driver.close();

	}

	public void quitAllWindows() {
		driver.quit();

	}

	public void clickOn(WebElement element) {
		element.click();

	}

public WebElement  getWebElement(String locatorType, String locatorValue) {
	if (locatorType.equalsIgnoreCase("id")) {
		return driver.findElement(By.id(locatorValue));
	} else if (locatorType.equalsIgnoreCase("css")) {
		return driver.findElement(By.cssSelector(locatorValue));
	} else if (locatorType.equalsIgnoreCase("xpath")) {
		return driver.findElement(By.xpath(locatorValue));
	} else if (locatorType.equalsIgnoreCase("name")) {
		return driver.findElement(By.name(locatorValue));
	} else if (locatorType.equalsIgnoreCase("class")) {
		return driver.findElement(By.className(locatorValue));
	} else if (locatorType.equalsIgnoreCase("tagname")) {
		return driver.findElement(By.tagName(locatorValue));
	} else if (locatorType.equalsIgnoreCase("linktext")) {
		return driver.findElement(By.linkText(locatorValue));
	} else if (locatorType.equalsIgnoreCase("partiallinktext")) {
		return driver.findElement(By.partialLinkText(locatorValue));
	} else {
		throw new InvalidSelectorException(locatorType);
	}
}
	public List<WebElement> getWebElements(String locatorType, String locatorValue) {
	
	
		if (locatorType.equalsIgnoreCase("id")) {
			return driver.findElements(By.id(locatorValue));
		} else if (locatorType.equalsIgnoreCase("css")) {
			return driver.findElements(By.cssSelector(locatorValue));
		} else if (locatorType.equalsIgnoreCase("xpath")) {
			return driver.findElements(By.xpath(locatorValue));
		} else if (locatorType.equalsIgnoreCase("name")) {
			return driver.findElements(By.name(locatorValue));
		} else if (locatorType.equalsIgnoreCase("class")) {
			return driver.findElements(By.className(locatorValue));
		} else if (locatorType.equalsIgnoreCase("tagname")) {
			return driver.findElements(By.tagName(locatorValue));
		} else if (locatorType.equalsIgnoreCase("linktext")) {
			return driver.findElements(By.linkText(locatorValue));
		} else if (locatorType.equalsIgnoreCase("partiallinktext")) {
			return driver.findElements(By.partialLinkText(locatorValue));
		} else {
			throw new InvalidSelectorException(locatorType);
		}
	}


	public void clickOn(String locatorType, String locatorValue) {

		getWebElement(locatorType, locatorValue).click();
	}

	public void enterText(String locatorType, String locatorValue, CharSequence... text) {

		getWebElement(locatorType, locatorValue).sendKeys(text);
	}

	public void hitKey(int keycode) {
		try {
			Robot robo = new Robot();
			robo.keyPress(keycode);
			robo.keyRelease(keycode);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public List<String> getTexts(String locatorType, String locatorValue) {

		List<String> texts = new ArrayList<String>();
		List<WebElement> elements = new ArrayList<WebElement>();
		elements= getWebElements(locatorType, locatorValue);
		
		for (WebElement element : elements) {
			texts.add(element.getText());
		}
		return texts;
	}

	public void maximizeBrowser() {
		driver.manage().window().maximize();		
	}

	public List<String> getTexts(List<WebElement> items) {
		
		List<String> texts = new ArrayList<String>();
		for (WebElement item : items) {
			texts.add(item.getText());
		}
		return texts;
	}

}
