package pageobjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HumburgerMenuPage {
	
	private WebDriver driver;
	public HumburgerMenuPage(WebDriver driver){
		this.driver = driver;
	}

	private By humburgerMenuButton = By.cssSelector("div[class='zd icon list fontIcon']");
	private By dataSourceMenu = By.cssSelector("button[class='zd btn btn-link']  div[class='text']");
	private By amountOfResources = By.cssSelector("span.source-name-data");
	private By impalaElement = By.cssSelector("span.source-name-data");
	private By donutChart = By.cssSelector(".donut");
	private By scatterPlot = By.cssSelector(".scatterplot");
	private By donutPage = By.tagName("canvas");
	
	
	public void clickingHumburgerMenu() {
		WebElement loginButton = driver.findElement(humburgerMenuButton);
		if(loginButton.isDisplayed())
			loginButton.click();;
	}
	
	public void clickDataSources(){
		List<WebElement> li = driver.findElements(dataSourceMenu);
		li.get(1).click();
	}

	public void amountOfResources(int number) {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		List<WebElement> DataSourcesElements = driver.findElements(amountOfResources);
		Assert.assertEquals(DataSourcesElements.size(), number, "The amount of available resourses are not equal to " + number);
	}
	
	public void impalaAutomationClick(){
		List<WebElement> DataSourcesElements = driver.findElements(impalaElement);
		DataSourcesElements.get(0).click();
	}
		
	public void donutChartAvailability() {
		WebElement element = driver.findElement(donutChart );
		Assert.assertTrue(element.isDisplayed(), "Donut chart is not displayed");
	}
	
	public void donutSourceClicking(){
		WebElement element = driver.findElement(donutChart );
		element.click();
	}
	
	public void scatterPlotChartAvailability() {
		WebElement scatterPlotChart = driver.findElement(scatterPlot);
		Assert.assertTrue(scatterPlotChart.isDisplayed(), "Scater Plot chart is not displayed");
	}
		
	public void donutPageIsDisplayed(int secondsToWait) {
		WebDriverWait wait = new WebDriverWait(driver, secondsToWait);
		wait.until(ExpectedConditions.visibilityOfElementLocated(donutPage));
	}
}
	