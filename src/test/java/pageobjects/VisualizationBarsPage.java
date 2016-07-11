package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

    public class VisualizationBarsPage {
	private WebDriver driver;
	
	public VisualizationBarsPage (WebDriver driver){
		this.driver = driver;
	}
	
	private By groupAttributeCity = By.cssSelector("div[title='City']");
	private By barsElements = By.cssSelector("img[title='Bars']");
	private By barsElementToEnsurePageWasLoaded = By.cssSelector("canvas[class='zr-element']");
	private By groupButton = By.cssSelector("div[class='attrLabel label-button']");
	private By chartStyleButton = By.cssSelector("div[class='zd icon style']");
	private By tableChartStyleButton = By.cssSelector("div[class='icon table ']");
	private By tableChartElement = By.cssSelector("a.pivot_table");
	private By selectedCityAttribute = By.cssSelector("li[title='City']");
	private By configureButton = By.cssSelector("div[class='zd icon configure']");	
	
		
	
	public void clickFirstAvailableBar(int secondsToWait){
		WebDriverWait wait = new WebDriverWait(driver, secondsToWait);
		wait.until(ExpectedConditions.elementToBeClickable(barsElements));
		List<WebElement> li = driver.findElements(barsElements);
		li.get(0).click();
	}
	
	public void barWasLoaded(int secondsToWait){
		WebDriverWait wait = new WebDriverWait(driver, secondsToWait);
		wait.until(ExpectedConditions.visibilityOfElementLocated(barsElementToEnsurePageWasLoaded));
	}
	
	public void clickGroupButton(int secondsToWait){
		WebDriverWait wait = new WebDriverWait(driver, secondsToWait);
		wait.until(ExpectedConditions.elementToBeClickable(groupButton));
		WebElement button = driver.findElement(groupButton);
		button.click();
	}
	
	public void clickCityAttribute() {
		WebElement button = driver.findElement(groupAttributeCity);
		button.click();
	}
	
	public void clickChartStyle(){
		WebElement button = driver.findElement(chartStyleButton);
		button.click();
	}
	
	public void clickTableChartStyle() {
		WebElement button = driver.findElement(tableChartStyleButton);
		button.click();
	}
	
	public void clickTableChartElement() {
		WebElement button = driver.findElement(tableChartElement);
		button.click();
	}
	
	public void clickConfigure(int secondsToWait){
		WebDriverWait wait = new WebDriverWait(driver, secondsToWait);
		wait.until(ExpectedConditions.elementToBeClickable(configureButton));
		WebElement button = driver.findElement(configureButton);
		button.click();
	}
	
	public void checkIfCityAttributeIsSelected() {
		WebElement cityAttribute = driver.findElement(selectedCityAttribute);
		Assert.assertTrue(cityAttribute.isDisplayed(), "City attribute is not selected");
	}
	
}