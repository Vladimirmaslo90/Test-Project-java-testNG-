package pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class VisualizationScatterPlotPage {
	
	private WebDriver driver;
			
	public VisualizationScatterPlotPage (WebDriver driver){
				this.driver = driver;
			}
	
	private By sortingInfo = By.cssSelector("div[class='data-items-limit sort-limit enabled']");
	
	//private By viewAllButtons = By.cssSelector("a.carousel-area-view-all-link");
	private By test1 = By.linkText("View All »");
	private By scatterPlot = By.cssSelector("img[title='Scatter Plot']");
	private By dateAttrubite = By.cssSelector("div.attr-indicator");
	private By yearTimeAttribute = By.cssSelector("div[title='Year']");
	private By closeDataBarElement = By.cssSelector("div[data-name='Time Bar'] button[title='Close']");
	private By leftDragElement = By.cssSelector("div[class='zdView-DragElement left ui-draggable']");
	private By rigtDragElement = By.cssSelector("div[class='zdView-DragElement right ui-draggable']");
	private By leftDataPickerContent = By.cssSelector("div[class='tooltipDatePicker-content left highlight']");
	private By rightDataPickerContent = By.cssSelector("div[class='tooltipDatePicker-content right highlight']");
	
				
			
	public void clickFirstViewAllButton(int secondsToWait){
		WebDriverWait wait = new WebDriverWait(driver, secondsToWait);
		wait.until(ExpectedConditions.visibilityOfElementLocated(test1));
		List<WebElement> viewAll = driver.findElements(test1);
		viewAll.get(0).click();
	}

	public void clickScatterPlotImage(int secondsToWait){
		WebDriverWait wait = new WebDriverWait(driver, secondsToWait);
		wait.until(ExpectedConditions.visibilityOfElementLocated(scatterPlot));
		WebElement image = driver.findElement(scatterPlot);
		image.click();
	}
	
	public void scatterPlotIsLoaded(int secondsToWait) {
		WebDriverWait wait = new WebDriverWait(driver, secondsToWait);
		wait.until(ExpectedConditions.visibilityOfElementLocated(sortingInfo));
		WebElement sortingInfoElement = driver.findElement(sortingInfo);
		Assert.assertTrue(sortingInfoElement.isDisplayed(), "Scatter Plot Page is not displayed");
	}
	
	public void clickDateAttribute(int secondsToWait) {
		WebDriverWait wait = new WebDriverWait(driver, secondsToWait);
		wait.until(ExpectedConditions.visibilityOfElementLocated(dateAttrubite));
		WebElement element = driver.findElement(dateAttrubite);
		element.click();
	}
	
	public void selectYearAttribute() {
		WebElement element = driver.findElement(yearTimeAttribute);
		element.click();
	}
	
	public void yearTimeWasApplied() {
		String retrieved_text = driver.findElement(dateAttrubite).getText(); 
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.cssSelector("div.attr-indicator"), retrieved_text));
		WebElement element = driver.findElement(dateAttrubite);
		String valueOfDiv = element.getText();
		Assert.assertEquals(valueOfDiv, "Year", "Time Bar has no 'Year' value");
		System.out.println(valueOfDiv);
	}
		
	public void closeDataBar() {
		WebElement element = driver.findElement(closeDataBarElement);
		element.click();
	}
	
	public void dragTimeElement() {
		Actions builder = new Actions(driver);
		WebElement element = driver.findElement(leftDragElement);
		WebElement target = driver.findElement(rigtDragElement);
		builder.dragAndDrop(element, target).perform();	
	}
	
	public void checkingIfDataPickersAreCorrect() {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebElement leftElement = driver.findElement(leftDataPickerContent);
		String valueOfLeftDiv = leftElement.getText();
		Assert.assertEquals(valueOfLeftDiv,  "2017", "Left Data Time value is not equal to 2017");
		
		WebElement rightElement = driver.findElement(rightDataPickerContent);
		String valueOfRightDiv = rightElement.getText();
		Assert.assertEquals(valueOfRightDiv,  "2018", "Right Data Time value is not equal to 2017");
	}
		
}
