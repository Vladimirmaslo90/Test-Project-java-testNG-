package pageobjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Mysql_automationPage {

	private WebDriver driver;
	
	public Mysql_automationPage (WebDriver driver){
				this.driver = driver;
			}
	
	private By heatMapImage = By.cssSelector("img[title='Heat Map']");
	private By sortGroupElement = By.cssSelector("div[class='data-items-limit sort-limit enabled']");
	private By elementToTest = By.cssSelector("div[class='zd-radial-item-center']");
	private By elementMoveFrom7 = By.cssSelector("canvas");
	private By cityAttribute = By.cssSelector("div[title='County']");
	private By group2Value = By.cssSelector("div[class='attrLabel label-button']");
	
	
	public void clickingHeatMapImage(int secondsToWait) {
		WebDriverWait wait = new WebDriverWait(driver, secondsToWait);
		wait.until(ExpectedConditions.visibilityOfElementLocated(heatMapImage));
		WebElement image = driver.findElement(heatMapImage);
		image.click();
	}
	
	public void validateLoadedCorrectly(int secondsToWait){
		WebDriverWait wait = new WebDriverWait(driver, secondsToWait);
		wait.until(ExpectedConditions.visibilityOfElementLocated(sortGroupElement));
		WebElement element = driver.findElement(sortGroupElement);
		Assert.assertTrue(element.isDisplayed(), "Heat map page was not loaded");
	}
	
	public void clickWidget(int secondsToWait) {
		WebDriverWait wait = new WebDriverWait(driver, secondsToWait);
		wait.until(ExpectedConditions.visibilityOfElementLocated(elementMoveFrom7));
		List<WebElement> listOfCanvas = driver.findElements(elementMoveFrom7);
		WebElement neededItem = listOfCanvas.get(0);
		Actions builder = new Actions(driver);
		builder.moveToElement(neededItem, 300, -500).click().build().perform();
		//builder.moveToElement(neededItem, 300, 500).click().build().perform();
	//	builder.moveToElement(neededItem, -300, -500).click().build().perform();
	
	}
	
	public void clickZoom(int secondsToWait) {
		WebDriverWait wait = new WebDriverWait(driver, secondsToWait);
		wait.until(ExpectedConditions.presenceOfElementLocated(elementToTest));
		List<WebElement> list = driver.findElements(elementToTest);
		WebElement zoom = list.get(3);
		WebElement takeSomeTIme = driver.findElement(By.cssSelector("div[class='metricLabel label-button']"));
		takeSomeTIme.getText();
		zoom.click();
		}
		
	public void selectCityAttribute(int secondsToWait){
		WebDriverWait wait = new WebDriverWait(driver, secondsToWait);
		wait.until(ExpectedConditions.elementToBeClickable(cityAttribute));
		WebElement element = driver.findElement(cityAttribute);
		element.click();
	}
	
	public void checkNewAttributeWasApplied(){
		List<WebElement> list = driver.findElements(group2Value);
		WebElement group2 = list.get(1);
		String group2Text = group2.getText();
		Assert.assertEquals(group2Text, "Group 2: County", "Zoom with 'Country' value was not applied");
	}
	
	

	
	
	
}
