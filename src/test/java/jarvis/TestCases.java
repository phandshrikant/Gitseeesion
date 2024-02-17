package jarvis;


import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.jarvis.base.TestBase;
import com.jarvis.keywords.Keyword;
import com.jarvis.pages.HomePage;
import com.jarvis.pages.SearchResultPage;
import com.jarvis.waits.WaitFor;
//The below Test Case is noemal Automation Test Case without Framework.
public class TestCases extends TestBase {
	@Test
	public void m1() {

		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://www.myntra.com");
		driver.findElement(By.xpath("//input[@class=\"desktop-searchBar\"]")).sendKeys("Levis", Keys.ENTER);
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(Duration.ofMillis(500));
		wait.withTimeout(Duration.ofSeconds(60));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//h3[@class=\"product-brand\"]"), 1));

		List<WebElement> productTitles = driver.findElements(By.xpath("//h3[@class=\"product-brand\"]"));

		SoftAssert softly = new SoftAssert();
		for (WebElement productTitle : productTitles) {
			String text = productTitle.getText();
			System.out.println("Checking: " + text);
			softly.assertTrue(text.contains("Levis"));
		}

		softly.assertAll();
		driver.quit();
	}
//The below test case using Keyword driven Framework.
	@Test

	public void m2() {
		Keyword keywod = new Keyword();
	    keywod.enterText("xpath"," //input[@class=\"desktop-searchBar\"]", "Levis",Keys.ENTER);
		WaitFor.numberOfElementsToBeMoreThan("xpath","//h3[@class=\"product-brand\"]",1);
		keywod.getTexts("xpath","//h3[@class=\"product-brand\"]");
		SoftAssert softly = new SoftAssert();
		softly.assertAll();
		
		

	}
	
	// The below Test Case is using Page Object Model.
	@Test
	
  public void usingPageObjectModel() throws InterruptedException {
		
	HomePage homepage = new HomePage();
	homepage.enterProductToSearch("Levis",Keys.ENTER);
	SearchResultPage resultPage = new SearchResultPage();
	resultPage.verifyProductTitlesContains("Levis");
	

}
}