package pageobjects;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage {
	
private WebDriver driver;
	
	public HomePage (WebDriver driver){
		this.driver = driver;
	}
	
	private By availableDataResources = By.cssSelector("div[class='source-icon-container'] img[data-role='sourceIcon']");
	private By humburgetButton = By.cssSelector("div[class='zd icon list fontIcon']");
	private By dataSourcesButton = By.cssSelector("button[class='zd btn btn-link']  div[class='text']");
	
	
	public void homePageIsDisplayed(){
		Assert.assertEquals("Zoomdata", driver.getTitle(), "Homepage isn't displayed");
	}
	
	public void clickingHumburgerMenu() {
		WebElement humburgerButton = driver.findElement(humburgetButton);
		if(humburgerButton.isDisplayed())
			humburgerButton.click();;
	}
	
	public void clickDataSources(){
		List<WebElement> li = driver.findElements(dataSourcesButton);
		li.get(1).click();
	}
	
	public void availableResources(int number){
		List<WebElement> list = driver.findElements(availableDataResources);
		Assert.assertEquals(list.size(), number, "The nubmer of resources are not equal to " + number);
		
	}

}
