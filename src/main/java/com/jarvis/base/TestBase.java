package com.jarvis.base;


import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import com.jarvis.keywords.Keyword;

public class TestBase {
	Keyword keyword = new Keyword();
	
@BeforeMethod
public void setUp() throws Exception {
	
	keyword.openBrowser(Config.getBrowserName());
	keyword.maximizeBrowser();
	keyword.openurl(Config.getAppUrl());
}


@AfterMethod
public void tearDown() throws Exception {
	keyword.quitAllWindows();
}
}
